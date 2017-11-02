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
package cn.ucaner.tools.crypto.digest;

/**
 * HMAC算法类型<br>
 * see: https://docs.oracle.com/javase/7/docs/technotes/guides/security/StandardNames.html#Mac
 * 
 * @author Looly
 */
public enum HmacAlgorithm {
	HmacMD5("HmacMD5"), 
	HmacSHA1("HmacSHA1"), 
	HmacSHA256("HmacSHA256"), 
	HmacSHA384("HmacSHA384"), 
	HmacSHA512("HmacSHA512");

	private String value;

	private HmacAlgorithm(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}