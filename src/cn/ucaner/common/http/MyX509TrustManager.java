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

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
* @Package：cn.ucaner.common.http   
* @ClassName：MyX509TrustManager   
* @Description：   <p> TODO</p>
* @Author： - DaoDou 
* @CreatTime：2017年8月30日 下午2:29:52   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class MyX509TrustManager implements X509TrustManager {

	public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
	}

	public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
	}

	public X509Certificate[] getAcceptedIssuers() {
		return null;
	}
}