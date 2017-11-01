package cn.ucaner.components.pay.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;

/* *
 *类名：AlipayFunction
 *功能：支付宝接口公用函数类
 *详细：该类是请求、通知返回两个文件所调用的公用函数核心处理文件，不需要修改
 *版本：3.3
 *日期：2012-08-14
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayUtil {

	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	public static final String partner = "2088621646866515";
	//MD5 key
	public static final String key = "yih6nwzv7miz4pogm1pdmx716q6h7a9u";
	//支付宝应用2.0签约appid
	public static final String app_id = "";
	//自己创建应用的appid
	public static final String application_app_id = "2017032806442322";
	// 签名方式
	public static final String sign_type = "RSA2";
	//支付宝应用2.0签约设置的公钥
	public static final String publicKey = "";
	//支付宝应用2.0签约设置的私钥
	public static final String privateKey = "";
	//自己创建应用的公钥
	public static final String application_publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoma2sNDolxg1rZhn5KbuN1OzCiETRS2Ped6xNsnjGGBiwDjVduLcxGronRYwKcS2tBIPRdZJbkwCn1u8jnsUuj3Eax6NDZHQ74Xm3Vsrara6nuXXjcQLJyDgpPXPtyW+V442qS2O03T/9698lbUHKYJF5mNkIgs2fftEbS54hTeKLVupJP9ty0eZK3+HFVR64erg/dyoh3l+7ALmpm2abd94mb2ZVuh67grvtH0aAQQyvnpCxJy2x5SwezXVZpFbREmGr9vPMoupUUaz9ZG+PVIrGfrparUuum8A6weSV233ewCtgPBE2Qu78kpGCws/Cz5BErmYLwUpjg+bhBGfzQIDAQAB";
	//自己创建应用的私钥
	public static final String application_privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCiZraw0OiXGDWtmGfkpu43U7MKIRNFLY953rE2yeMYYGLAONV24tzEauidFjApxLa0Eg9F1kluTAKfW7yOexS6PcRrHo0NkdDvhebdWytqtrqe5deNxAsnIOCk9c+3Jb5XjjapLY7TdP/3r3yVtQcpgkXmY2QiCzZ9+0RtLniFN4otW6kk/23LR5krf4cVVHrh6uD93KiHeX7sAuambZpt33iZvZlW6HruCu+0fRoBBDK+ekLEnLbHlLB7NdVmkVtESYav288yi6lRRrP1kb49UisZ+ulqtS66bwDrB5JXbfd7AK2A8ETZC7vySkYLCz8LPkESuZgvBSmOD5uEEZ/NAgMBAAECggEATMTJL6RRjrs/BKS61/ehPD4wsGUaOuVioXWHyCJ/W5KUm9FB90Uenyr6cud+NQBsbYrr9VNqutzrkHFJHQFJtxBjvU9f1j5Lyi4+B/2E9JkUdvCniLhXnVOJXfFlE2qgI7tyU17Z2VPBfFBUUGCW1iRi7pmlSAKM69jPa90/05jArQO1yUHkwIX0r386Fe9Xyu8d97Vh+xB20X7fshobFRezwBvAvKt8SoI+SEsQEX2s0BvYdW09geac6FvEL+vLZIwkJFm8688aHPp/OQlORMeAYsaFjIIVK/yBEXm6WShuQRqv/qLP1I91iNRuoHvINZzCNYeaJWh/VG5chcPRAQKBgQDTmp0e2Likf/eQGjFWMth4zOAqMta0C9Q8XSeccUUGJDEPTFvDVl4bfjBK2H0R6KC72VrHYmE6180iZ9i8aOYIc56oOaB1oNJ2/NGucERjcEiB/uTxKwdjTs0c/Nq7pKOY3T6v8qK3uilzc6gT1uznZx+BFmyXTczADqba8ocWcQKBgQDEeWOWMHKyqmKq60LwjYZfaB1Q1RwnLvldpVGtjwQtboNV5sFBMP7HkoGfx/3Y22xer19WOJIgWi2RdKKBcVtfX2WMyEnRHHtvxp6AjM0L4oIINxda9Gs+bggM3g4RNmMMiBEclQ5ELTO1u/9x23LrtanfuyuWxPiDb+ShEUHlHQKBgBbBofQXSoQmXvFYX8XtYepb3h+rp/tk6kYznnbsl4e5jK0ggR3Yw/Yg9ACYl5q9ccvB7ElVAy/Y1W7FzEE25sYx6PYefGsqCHhTaBliaXhoMuQIDYcCIaFEcDqV1tAnPJDL+lnhti4cDykjXwgDLScVqAWx66u56jMdYERboLuBAoGBAIGrL9uuq/RY2Xe+f1ZtwTJ0b2yqycLekLuKYUavre0iE9H80qzo3i3u9lfy0Qlvf61aBwzLlz185rgqBxpxKwHd3xK0GWvGZX0W1AM5ahae7nznhyWDTMhOLEf5wcUAZQyfPNPlWB4MyyT1J5kIYWdJZQ0A5brC0tVEYtsenaPNAoGBAI8K/B9rZkP/Pl8hBhRQVRk0VEJFEKwI3F4+CaMzlqbVHHr4qU0DvOPDnu9t8SzwcpmfQCh4oMvVf8hbaHDsmal7LS8X29vXqoX3W6nMbVhApRnG5B+SK9TUYfttAz/Q2bi5ENJkKmJYznE7AL4EQA4I6xXlru9U6DcUCi5dbOTm";

	public static final String seller = "";
	//支付回调
	public static final String pay_notify_url = "http://test.huamaiwebchat.com/pay/ali/notify";
	//退款回调
	public static final String refund_notify_url = "";

	public static final String refund_url = "https://openapi.alipay.com/gateway.do?";
	//支付宝订单查询
	public static final String order_query_url = "https://openapi.alipay.com/gateway.do?";

	public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

	public static final String SIGN_256_ALGORITHMS = "SHA256WithRSA";

	/**
     * 支付宝消息验证地址
     */
    private static final String HTTPS_VERIFY_URL = "https://mapi.alipay.com/gateway.do?service=notify_verify&";
	
	/** 
	 * 除去数组中的空值和签名参数
	 * @param sArray 签名参数组
	 * @return 去掉空值与签名参数后的新签名参数组
	 */
	public static Map<String, String> paraFilter(Map<String, String> sArray) {

		Map<String, String> result = new HashMap<String, String>();

		if (sArray == null || sArray.size() <= 0) {
			return result;
		}

		for (String key : sArray.keySet()) {
			String value = sArray.get(key);
			if (value == null || value.equals("") || key.equalsIgnoreCase("sign")) {
				continue;
			}
			result.put(key, value);
		}

		return result;
	}

	/** 
	 * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
	 * @param params 需要排序并参与字符拼接的参数组
	 * @return 拼接后字符串
	 */
	public static String createLinkString(Map<String, String> params) {

		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);

		String prestr = "";

		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = params.get(key);

			if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
				prestr = prestr + key + "=" + value;
			} else {
				prestr = prestr + key + "=" + value + "&";
			}
		}

		return prestr;
	}

	/**
	* RSA签名
	* @param content 待签名数据
	* @param privateKey 商户私钥
	* @param input_charset 编码格式
	* @return 签名值
	*/
	public static String sign(String content, String privateKey, String input_charset) {
		try {
			PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey));
			KeyFactory keyf = KeyFactory.getInstance("RSA");
			PrivateKey priKey = keyf.generatePrivate(priPKCS8);
			Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
			signature.initSign(priKey);
			signature.update(content.getBytes(input_charset));
			byte[] signed = signature.sign();
			return new String(Base64.getEncoder().encode(signed));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * RSA签名
	 * @param content 待签名数据
	 * @param privateKey 商户私钥
	 * @param input_charset 编码格式
	 * @return 签名值
	 */
	public static String signRSA256(String content, String privateKey, String input_charset) {
		try {
			PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey));
			KeyFactory keyf = KeyFactory.getInstance("RSA");
			PrivateKey priKey = keyf.generatePrivate(priPKCS8);
			Signature signature = Signature.getInstance(SIGN_256_ALGORITHMS);
			signature.initSign(priKey);
			signature.update(content.getBytes(input_charset));
			byte[] signed = signature.sign();
			return new String(Base64.getEncoder().encode(signed));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	* RSA验签名检查
	* @param content 待签名数据
	* @param sign 签名值
	* @param ali_public_key 支付宝公钥
	* @param input_charset 编码格式
	* @return 布尔值
	*/
	public static boolean verify(String content, String sign, String ali_public_key, String input_charset) {
		try {
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			byte[] encodedKey = Base64.getDecoder().decode(ali_public_key);
			PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));

			Signature signature = Signature.getInstance(SIGN_256_ALGORITHMS);

			signature.initVerify(pubKey);
			signature.update(content.getBytes(input_charset));

			boolean bverify = signature.verify(Base64.getDecoder().decode(sign));
			return bverify;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	 /**
     * 验证消息是否是支付宝发出的合法消息
     * @param params 通知返回来的参数数组
     * @return 验证结果
     */
    public static boolean verify(Map<String, String> params) {

        //判断responsetTxt是否为true，isSign是否为true
        //responsetTxt的结果不是true，与服务器设置问题、合作身份者ID、notify_id一分钟失效有关
        //isSign不是true，与安全校验码、请求时的参数格式（如：带自定义参数等）、编码格式有关
    	String responseTxt = "false";
		if(params.get("notify_id") != null) {
			String notify_id = params.get("notify_id");
			responseTxt = verifyResponse(notify_id);
		}
	    String sign = "";
	    if(params.get("sign") != null) {sign = params.get("sign");}
	    boolean isSign = getSignVeryfy(params, sign);

        //写日志记录（若要调试，请取消下面两行注释）
        //String sWord = "responseTxt=" + responseTxt + "\n isSign=" + isSign + "\n 返回回来的参数：" + AlipayCore.createLinkString(params);
	    //AlipayCore.logResult(sWord);

        if (isSign && responseTxt.equals("true")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据反馈回来的信息，生成签名结果
     * @param Params 通知返回来的参数数组
     * @param sign 比对的签名结果
     * @return 生成的签名结果
     */
	private static boolean getSignVeryfy(Map<String, String> Params, String sign) {
    	//过滤空值、sign与sign_type参数
    	Map<String, String> sParaNew =paraFilter(Params);
        //获取待签名字符串
        String preSignStr = createLinkString(sParaNew);
        //获得签名验证结果
        boolean isSign = verify(preSignStr, sign, publicKey,"utf-8");
        return isSign;
    }
	/**
	    * 获取远程服务器ATN结果,验证返回URL
	    * @param notify_id 通知校验ID
	    * @return 服务器ATN结果
	    * 验证结果集：
	    * invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 
	    * true 返回正确信息
	    * false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
	    */
	    private static String verifyResponse(String notify_id) {
	        //获取远程服务器ATN结果，验证是否是支付宝服务器发来的请求
	        String veryfy_url = HTTPS_VERIFY_URL + "partner=" + partner + "&notify_id=" + notify_id;
	        return checkUrl(veryfy_url);
	    }

	    /**
	    * 获取远程服务器ATN结果
	    * @param urlvalue 指定URL路径地址
	    * @return 服务器ATN结果
	    * 验证结果集：
	    * invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 
	    * true 返回正确信息
	    * false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
	    */
	    private static String checkUrl(String urlvalue) {
	        String inputLine = "";

	        try {
	            URL url = new URL(urlvalue);
	            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
	            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection
	                .getInputStream()));
	            inputLine = in.readLine().toString();
	        } catch (Exception e) {
	            e.printStackTrace();
	            inputLine = "";
	        }

	        return inputLine;
	    }
}