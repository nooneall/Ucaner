package cn.ucaner.components.core.security;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;

public class RSA implements ISecurity {


	private final String SIGN_ALGORITHMS = "SHA1WithRSA";

	private final ISecurity base64 = SecurityUtil.getBase64();


	@Override
	public String Encrypt(String data) throws Exception {
		return null;
	}

	@Override
	public String Decrypt(String data) throws Exception {
		return null;
	}

	@Override
	public String Sign(String content, String privateKey) throws Exception {
		PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(base64.Decrypt(privateKey).getBytes("UTF-8"));
		KeyFactory keyf = KeyFactory.getInstance("RSA");
		PrivateKey priKey = keyf.generatePrivate(priPKCS8);
		Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
		signature.initSign(priKey);
		signature.update(content.getBytes("UTF-8"));
		byte[] signed = signature.sign();
		return base64.Encrypt(new String(signed));
	}
}