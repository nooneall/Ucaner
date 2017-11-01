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
package cn.ucaner.components.pay.service;

public class PayFactory {
	
	private static final PayFactory instance = new PayFactory();

	public static PayFactory getInstance() {
		return instance;
	}

	public IPay init(int payWay) {
		IPay ipay = null;
		switch (payWay) {
		case 1:
			ipay = new WXPay();
			break;
		case 2:
			ipay = new AliPay();
			break;
		}
		return ipay;
	}
}
