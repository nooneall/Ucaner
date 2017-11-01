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
package cn.ucaner.components.core.security;

import java.security.MessageDigest;

/**
 * Created by yangzhao on 17/7/20.
 */
public class SHA implements ISecurity {

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
        byte[] bt = content.getBytes();
        String encName = "SHA-256";
        MessageDigest md = MessageDigest.getInstance(encName);
        md.update(bt);
        String strDes = bytes2Hex(md.digest());
        return strDes;
    }

    private String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }
}
