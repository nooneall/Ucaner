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
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Date;
import java.util.zip.GZIPInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import cn.ucaner.framework.config.SystemConfig;
import cn.ucaner.framework.exception.SystemException;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

/**
* @Package：cn.ucaner.common.http   
* @ClassName：HttpResponse   
* @Description：   <p> Http响应</p>
* @Author： - DaoDou 
* @CreatTime：2017年8月30日 下午2:30:06   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */

public class HttpResponse {
	
	private static Logger logger = Logger.getLogger(HttpResponse.class.getName());
	
	private final static boolean DEBUG = SystemConfig.getBooleanValue("http_debug");
	
	private static ThreadLocal<DocumentBuilder> builders = new ThreadLocal<DocumentBuilder>() {
		@Override
		protected DocumentBuilder initialValue() {
			try {
				return DocumentBuilderFactory.newInstance().newDocumentBuilder();
			} catch (ParserConfigurationException ex) {
				throw new ExceptionInInitializerError(ex);
			}
		}
	};

	private int statusCode;
	private Document responseAsDocument = null;
	private String responseAsString = null;
	private InputStream is;
	private HttpURLConnection con;
	private boolean streamConsumed = false;

	public HttpResponse() {

	}

	public HttpResponse(HttpURLConnection con) throws IOException {
		this.con = con;
		this.statusCode = con.getResponseCode();
		is = con.getErrorStream();
		if (null == is) {
			is = con.getInputStream();
		}
		if (null != is && "gzip".equals(con.getContentEncoding())) {
			// the response is gzipped
			is = new GZIPInputStream(is);
		}
	}

	// for test purpose
	/* package */HttpResponse(String content) {
		this.responseAsString = content;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getResponseHeader(String name) {
		if (con != null) {
			return con.getHeaderField(name);
		} else {
			return null;
		}
	}

	/**
	 * Returns the response stream.<br>
	 * This method cannot be called after calling asString() or asDcoument()<br>
	 * It is suggested to call disconnect() after consuming the stream.
	 * 
	 * Disconnects the internal HttpURLConnection silently.
	 * 
	 * @return response body stream
	 * @throws WeiboException
	 * @see #disconnect()
	 */
	public InputStream asStream() {
		if (streamConsumed) {
			throw new IllegalStateException("Stream has already been consumed.");
		}
		return is;
	}

	/**
	 * Returns the response body as string.<br>
	 * Disconnects the internal HttpURLConnection silently.
	 * 
	 * @return response body
	 * @throws WeiboException
	 */
	public String asString() throws SystemException {
		if (null == responseAsString) {
			BufferedReader br;
			try {
				InputStream stream = asStream();
				if (null == stream) {
					return null;
				}
				br = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
				StringBuffer buf = new StringBuffer();
				String line;
				while (null != ( line = br.readLine() )) {
					buf.append(line).append("\n");
				}
				this.responseAsString = buf.toString();
				log(responseAsString);
				stream.close();
				con.disconnect();
				streamConsumed = true;
			} catch (NullPointerException npe) {
				// don't remember in which case npe can be thrown
				throw new SystemException(npe.getMessage(), npe);
			} catch (IOException ioe) {
				throw new SystemException(ioe.getMessage(), ioe);
			}
		}
		return responseAsString;
	}

	/**
	 * Returns the response body as org.w3c.dom.Document.<br>
	 * Disconnects the internal HttpURLConnection silently.
	 * 
	 * @return response body as org.w3c.dom.Document
	 * @throws WeiboException
	 */
	public Document asDocument() throws SystemException {
		if (null == responseAsDocument) {
			try {
				// it should be faster to read the inputstream directly.
				// but makes it difficult to troubleshoot
				this.responseAsDocument = builders.get().parse(new ByteArrayInputStream(asString().getBytes("UTF-8")));
			} catch (SAXException saxe) {
				throw new SystemException("The response body was not well-formed:\n" + responseAsString, saxe);
			} catch (IOException ioe) {
				throw new SystemException("There's something with the connection.", ioe);
			}
		}
		return responseAsDocument;
	}

	/**
	 * Returns the response body as sinat4j.org.json.JSONObject.<br>
	 * Disconnects the internal HttpURLConnection silently.
	 * 
	 * @return response body as sinat4j.org.json.JSONObject
	 * @throws WeiboException
	 */
	public JSONObject asJSONObject() throws SystemException {
		try {
			return JSONObject.parseObject(asString());
		} catch (JSONException jsone) {
			throw new SystemException(jsone.getMessage() + ":" + this.responseAsString, jsone);
		}
	}

	/**
	 * Returns the response body as sinat4j.org.json.JSONArray.<br>
	 * Disconnects the internal HttpURLConnection silently.
	 * 
	 * @return response body as sinat4j.org.json.JSONArray
	 * @throws WeiboException
	 */
	public JSONArray asJSONArray() {
		try {
			return JSONObject.parseArray(asString());
		} catch (Exception jsone) {
			throw new SystemException(jsone.getMessage() + ":" + this.responseAsString, jsone);
		}
	}

	public InputStreamReader asReader() {
		try {
			return new InputStreamReader(is, "UTF-8");
		} catch (java.io.UnsupportedEncodingException uee) {
			return new InputStreamReader(is);
		}
	}

	public void disconnect() {
		con.disconnect();
	}
	
	public static boolean isRequestSuccess(HttpResponse response){
		return response!=null && response.getStatusCode()==200;
	}

	@Override
	public String toString() {
		if (null != responseAsString) {
			return responseAsString;
		}
		return "Response{" + "statusCode=" + statusCode + ", response=" + responseAsDocument + ", responseString='" + responseAsString + '\''
				+ ", is=" + is + ", con=" + con + '}';
	}

	private void log(String message) {
		if (DEBUG) {
			logger.info("[" + new Date() + "]" + message);
		}
	}

	public String getResponseAsString() {
		return responseAsString;
	}

	public void setResponseAsString(String responseAsString) {
		this.responseAsString = responseAsString;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
}
