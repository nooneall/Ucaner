package cn.ucaner.components.core.security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;

public class AES implements ISecurity {

	private static String sKey = "B31F2A75FBF94099";

	private static final String ALGORITHM = "AES/ECB/PKCS7Padding";

	private static byte[] raw = null;

	private final ISecurity base64 = SecurityUtil.getBase64();

	static {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		try {
			raw = sKey.getBytes();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 加密
	 * @param data
	 * @return
	 * @throws Exception
	 */
	@Override
	public String Encrypt(String data) throws Exception {
		byte[] encrypted=null;
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance(ALGORITHM, "BC");//"算法/模式/补码方式"
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		encrypted = cipher.doFinal(data.getBytes("utf-8"));
		return base64.Encrypt(new String(encrypted));//此处使用BASE64做转码功能，同时能起到2次加密的作用。
	}

	/**
	 * 解密
	 * @param data
	 * @return
	 * @throws Exception
	 */
	@Override
	public String Decrypt(String data) throws Exception {
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance(ALGORITHM, "BC");
		cipher.init(Cipher.DECRYPT_MODE, skeySpec);
		String decrypt = base64.Decrypt(data);//先用base64解密
		byte[] encrypted1 = decrypt.getBytes("UTF-8");
		byte[] original = cipher.doFinal(encrypted1);
		String originalString = new String(original, "utf-8");
		return originalString;
	}

	@Override
	public String Sign(String content, String privateKey) throws Exception {
		return null;
	}
}
