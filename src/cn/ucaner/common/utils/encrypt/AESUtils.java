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
package cn.ucaner.common.utils.encrypt;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

/**
* @Package：cn.ucaner.common.utils.encrypt   
* @ClassName：AESUtils   
* @Description：   <p> AES加解密 </p>
* @Author： - DaoDou 
* @CreatTime：2017年10月25日 下午5:48:52   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
class AESUtils {
	
	/** 默认秘钥 */
	protected static final String KEY = "NOPO3nzMD3dndwS0MccuMeXCHgVlGOoYyFwLdS24Im2e7YyhB0wrUsyYf0";
	
    /**
     *  AES解密
     * @param encryptValue 待解密内容
     * @param key 秘钥
     * @return
     * @throws Exception
     */
    protected static String decrypt(String encryptValue, String key) throws Exception {  
        return aesDecryptByBytes(base64Decode(encryptValue), key);  
    }
    
    /**
     * AES加密 
     * @param value 待加密内容
     * @param key 秘钥
     * @return
     * @throws Exception
     */
    protected static String encrypt(String value, String key) throws Exception {  
        return base64Encode(aesEncryptToBytes(value, key));  
    }  
	
    private static String base64Encode(byte[] bytes){  
        return Base64Utils.encrypt(bytes);  
    }  
      
    @SuppressWarnings("static-access")
    private static byte[] base64Decode(String base64Code) throws Exception{  
        return base64Code == null ? null : new Base64Utils().decrypt(base64Code);  
    }  
      
    private static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {  
        KeyGenerator kgen = KeyGenerator.getInstance("AES");  
        kgen.init(128, new SecureRandom(encryptKey.getBytes()));  
  
        Cipher cipher = Cipher.getInstance("AES");  
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));  
          
        return cipher.doFinal(content.getBytes("utf-8"));  
    }  
      
    private static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {  
        KeyGenerator kgen = KeyGenerator.getInstance("AES");  
        kgen.init(128, new SecureRandom(decryptKey.getBytes()));  
          
        Cipher cipher = Cipher.getInstance("AES");  
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));  
        byte[] decryptBytes = cipher.doFinal(encryptBytes);  
          
        return new String(decryptBytes);  
    }  
    
}
