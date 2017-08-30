/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 19941115</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.common.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.log4j.Logger;

import cn.ucaner.framework.config.SystemConfig;
import cn.ucaner.framework.exception.SystemException;

/**
* @Package：cn.ucaner.common.http   
* @ClassName：HttpClient   
* @Description：   <p> http客户端</p>
* @Author： - DaoDou 
* @CreatTime：2017年8月30日 下午2:28:15   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class HttpClient implements Serializable {

	private static final long serialVersionUID = 6762839916800221637L;
	protected static Logger logger = Logger.getLogger(HttpClient.class.getName());
	/**
	 * OK: Success!
	 */
	private static final int OK = 200;
	/**
	 * Move temporarily:The requested resource temporary from different URI in
	 * response to a request.
	 */
	private static final int NOT_RESOURCE = 302;
	/**
	 * Not Modified: If the client sends a GET request with the condition and
	 * the request is allowed, and the content of the document (since the last
	 * visit or request according to the conditions of) did not change, the
	 * server should return a status code.
	 */
	private static final int NOT_MODIFIED = 304;
	/**
	 * Bad Request: Semantic error, the current request cannot be understood by
	 * the server.
	 */
	private static final int BAD_REQUEST = 400;
	/**
	 * Unauthorized: Require the user to verify the current request.
	 */
	private static final int UNAUTHORIZED = 401;
	/**
	 * Forbidden: The server has understood the request, but refused to
	 * implement it.
	 */
	private static final int FORBIDDEN = 403;
	/**
	 * Not Found: The request failed requests, hope to get the resource is not
	 * found on the server.
	 */
	private static final int NOT_FOUND = 404;
	/**
	 * Not Acceptable:The content characteristics of the requested resource can
	 * not meet the head condition request, thus unable to generate the response
	 * entity.
	 */
	private static final int NOT_ACCEPTABLE = 406;
	/**
	 * Internal Server Error:The server encountered an unexpected condition,
	 * cause it can't fulfill the request processing.
	 */
	private static final int INTERNAL_SERVER_ERROR = 500;
	/**
	 * Bad Gateway: As a gateway or proxy work server attempts to execute the
	 * request, response from the upstream server received an invalid.
	 */
	private static final int BAD_GATEWAY = 502;
	/**
	 * Service Unavailable:Due to a temporary server maintenance or overload,
	 * the server cannot process the request.
	 */
	private static final int SERVICE_UNAVAILABLE = 503;

	private final static boolean DEBUG = SystemConfig.getBooleanValue("http_debug");
	private org.apache.commons.httpclient.HttpClient client = null;
	/**
	 * 多线程HTTP连接管理器
	 */
	private MultiThreadedHttpConnectionManager connectionManager;

	public HttpClient() {
		this(150, 20000, 20000, false);
	}

	public HttpClient(int maxConPerHost, int conTimeOutMs, int soTimeOutMs, boolean isHttps) {
		connectionManager = new MultiThreadedHttpConnectionManager();
		HttpConnectionManagerParams params = connectionManager.getParams();
		params.setDefaultMaxConnectionsPerHost(maxConPerHost);
		params.setConnectionTimeout(conTimeOutMs);
		params.setSoTimeout(soTimeOutMs);
		HttpClientParams clientParams = new HttpClientParams();
		// 忽略cookie 避免 Cookie rejected 警告
		clientParams.setCookiePolicy(CookiePolicy.IGNORE_COOKIES);
		client = new org.apache.commons.httpclient.HttpClient(clientParams, connectionManager);
		if (isHttps) {
			Protocol myhttps = new Protocol("https", new SSLSocketFactory(), 443);
			Protocol.registerProtocol("https", myhttps);
		}
	}

	/**
	 * log调试
	 * 
	 */
	private static void log(String message) {
		if (DEBUG) {
			logger.info(message);
		}
	}

	/**
	 * 处理http getmethod 请求
	 * 
	 */
	public HttpResponse get(String url) throws SystemException {
		return get(url, new PostParameter[0]);
	}

	/**
	 * 处理http getmethod 请求
	 * 
	 */
	public HttpResponse get(String url, PostParameter[] params) throws SystemException {
		log("Request:");
		log("GET:" + url);
		if (null != params && params.length > 0) {
			String encodedParams = HttpClient.encodeParameters(params);
			if (-1 == url.indexOf("?")) {
				url += "?" + encodedParams;
			} else {
				url += "&" + encodedParams;
			}
		}
		GetMethod getmethod = new GetMethod(url);
		return httpRequest(getmethod);
	}

	/**
	 * 处理http getmethod 请求
	 * 
	 */
	public HttpResponse get(String url, List<PostParameter> params) throws SystemException {
		log("Request:");
		log("GET:" + url);
		if (null != params && params.size() > 0) {
			String encodedParams = HttpClient.encodeParameters(params);
			if (-1 == url.indexOf("?")) {
				url += "?" + encodedParams;
			} else {
				url += "&" + encodedParams;
			}
		}
		GetMethod getmethod = new GetMethod(url);
		return httpRequest(getmethod);
	}

	/**
	 * 处理http deletemethod请求
	 */
	public HttpResponse delete(String url, PostParameter[] params) throws SystemException {
		log("Request:");
		log("DELETE:" + url);
		if (0 != params.length) {
			String encodedParams = HttpClient.encodeParameters(params);
			if (-1 == url.indexOf("?")) {
				url += "?" + encodedParams;
			} else {
				url += "&" + encodedParams;
			}
		}
		DeleteMethod deleteMethod = new DeleteMethod(url);
		return httpRequest(deleteMethod);

	}

	/**
	 * 处理http deletemethod请求
	 */
	public HttpResponse delete(String url, List<PostParameter> params) throws SystemException {
		log("Request:");
		log("DELETE:" + url);
		if (0 != params.size()) {
			String encodedParams = HttpClient.encodeParameters(params);
			if (-1 == url.indexOf("?")) {
				url += "?" + encodedParams;
			} else {
				url += "&" + encodedParams;
			}
		}
		DeleteMethod deleteMethod = new DeleteMethod(url);
		return httpRequest(deleteMethod);

	}

	/**
	 * 处理http postmethod请求
	 */
	public HttpResponse post(String url) throws SystemException {
		log("Request:");
		log("POST:" + url);
		PostMethod postMethod = new PostMethod(url);
		return httpRequest(postMethod);
	}

	/**
	 * 处理http post请求
	 * 
	 */
	public HttpResponse post(String url, List<PostParameter> params) throws SystemException {
		log("Request:");
		log("POST:" + url);
		PostMethod postMethod = new PostMethod(url);
		if (params != null && params.size() > 0) {
			for (int i = 0; i < params.size(); i++) {
				PostParameter parameter = params.get(i);
				postMethod.addParameter(parameter.getName(), parameter.getValue());
			}
		}
		HttpMethodParams param = postMethod.getParams();
		param.setContentCharset("UTF-8");
		return httpRequest(postMethod);
	}

	/**
	 * 处理http post请求 
	 * add by homer.yang
	 * add time 2015-12-01
	 * 重载了一个post方法，传入参数用Map<String, String>
	 */
	public HttpResponse post(String url, Map<String, String> params) throws SystemException {
		log("Request:");
		log("POST:" + url);
		PostMethod postMethod = new PostMethod(url);
		if (params != null) {
			for (Map.Entry<String, String> entry : params.entrySet()) {
				postMethod.addParameter(entry.getKey(), entry.getValue());
			}
		}
		HttpMethodParams param = postMethod.getParams();
		param.setContentCharset("UTF-8");
		return httpRequest(postMethod);
	}

	/**
	 * 处理http post请求
	 * 
	 * @param url
	 * @param value
	 * @return
	 * @throws SystemException
	 */
	public HttpResponse post(String url, String value, String contentType, String charset) throws SystemException {
		PostMethod postMethod = new PostMethod(url);
		postMethod.setRequestHeader("Content-Type", contentType + ";charset=" + charset);
		try {
			postMethod.setRequestEntity(new StringRequestEntity(value, contentType, charset));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return httpRequest(postMethod);
	}

	/**
	 * 处理http post请求
	 * 
	 */
	public HttpResponse post(String url, PostParameter[] params) throws SystemException {
		log("Request:");
		log("POST:" + url);
		PostMethod postMethod = new PostMethod(url);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				PostParameter parameter = params[i];
				postMethod.addParameter(parameter.getName(), parameter.getValue());
			}
		}
		HttpMethodParams param = postMethod.getParams();
		param.setContentCharset("UTF-8");
		return httpRequest(postMethod);
	}

	/**
	 * 执行请求
	 * 
	 * @param method
	 * @return
	 * @throws SystemException
	 */
	private HttpResponse httpRequest(HttpMethod method) throws SystemException {
		int responseCode = -1;
		InputStream resStream = null;
		BufferedReader br = null;
		try {
			method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));
			client.executeMethod(method);
			Header[] resHeader = method.getResponseHeaders();
			responseCode = method.getStatusCode();
			log("Response:");
			log("https StatusCode:" + String.valueOf(responseCode));
			if (DEBUG) {
				for (Header header : resHeader) {
					log(header.getName() + ":" + header.getValue());
				}
			}
			HttpResponse response = new HttpResponse();
			response.setStatusCode(responseCode);
			// response.setResponseAsString(method.getResponseBodyAsString());
			resStream = method.getResponseBodyAsStream();
			br = new BufferedReader(new InputStreamReader(resStream));
			StringBuffer resBuffer = new StringBuffer();
			String resTemp = "";
			while ( ( resTemp = br.readLine() ) != null) {
				resBuffer.append(resTemp);
			}
			response.setResponseAsString(resBuffer.toString());
			log(response.toString() + "\n");
			if (responseCode != OK) {
				throw new SystemException(getCause(responseCode));
			}
			return response;

		} catch (IOException ioe) {
			logger.info(ioe.getMessage());
			logger.error(ioe.getMessage(), ioe);
			throw new SystemException(ioe.getMessage(), ioe);
		} finally {
			method.releaseConnection();
			try {
				if (br != null) {
					br.close();
				}
				if (resStream != null) {
					resStream.close();
				}
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}

	}

	/**
	 * 对parameters进行encode处理
	 * 
	 * @param postParams
	 * @return
	 */
	public static String encodeParameters(PostParameter[] postParams) {
		StringBuffer buf = new StringBuffer();
		for (int j = 0; j < postParams.length; j++) {
			if (j != 0) {
				buf.append("&");
			}
			try {
				buf.append(URLEncoder.encode(postParams[j].getName(), "UTF-8")).append("=")
						.append(URLEncoder.encode(postParams[j].getValue(), "UTF-8"));
			} catch (UnsupportedEncodingException neverHappen) {
				throw new SystemException(neverHappen);
			}
		}
		return buf.toString();
	}

	/**
	 * 对parameters进行encode处理
	 * 
	 * @param postParams
	 * @return
	 */
	public static String encodeParameters(List<PostParameter> postParams) {
		StringBuffer buf = new StringBuffer();
		for (int j = 0; j < postParams.size(); j++) {
			if (j != 0) {
				buf.append("&");
			}
			try {
				PostParameter postParameter = postParams.get(j);
				buf.append(URLEncoder.encode(postParameter.getName(), "UTF-8")).append("=")
						.append(URLEncoder.encode(postParameter.getValue(), "UTF-8"));
			} catch (UnsupportedEncodingException neverHappen) {
				throw new SystemException(neverHappen);
			}
		}
		return buf.toString();
	}

	private static String getCause(int statusCode) {
		String cause = null;
		switch (statusCode) {
		case NOT_RESOURCE:
			cause = "Move temporarily:The requested resource temporary" + " from different URI in response to a request.";
			break;
		case NOT_MODIFIED:
			cause =
					"Not Modified: If the client sends a GET request with the condition and the request is allowed,"
							+ " and the content of the document (since the last visit or"
							+ " request according to the conditions of) did not change," + " the server should return a status code.";
		case BAD_REQUEST:
			cause = "Bad Request: Semantic error, the current request cannot be understood by the server.";
			break;
		case UNAUTHORIZED:
			cause = "Unauthorized: Require the user to verify the current request.";
			break;
		case FORBIDDEN:
			cause = "FORBIDDEN:Forbidden: The server has understood the request, but refused to implement it.";
			break;
		case NOT_FOUND:
			cause = "The request failed requests, hope to get the resource is not found on the server.";
			break;
		case NOT_ACCEPTABLE:
			cause =
					"The content characteristics of the requested resource can not meet the head condition request,"
							+ " thus unable to generate the response entity.";
			break;
		case INTERNAL_SERVER_ERROR:
			cause = "The server encountered an unexpected condition," + " cause it can't fulfill the request processing.";
			break;
		case BAD_GATEWAY:
			cause =
					"Bad Gateway:As a gateway or proxy work server attempts to execute the request,"
							+ " response from the upstream server received an invalid.";
			break;
		case SERVICE_UNAVAILABLE:
			cause = "Service Unavailable:Due to a temporary server maintenance or overload," + " the server cannot process the request.";
			break;
		default:
			cause = "";
		}
		return statusCode + ":" + cause;
	}
}
