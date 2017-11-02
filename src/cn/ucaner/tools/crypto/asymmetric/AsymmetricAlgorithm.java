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
package cn.ucaner.tools.crypto.asymmetric;

/**
 * 非对称算法类型<br>
 * 
 * @author Looly
 *
 */
public enum AsymmetricAlgorithm {
	RSA("RSA"), DSA("DSA");

	private String value;

	private AsymmetricAlgorithm(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
