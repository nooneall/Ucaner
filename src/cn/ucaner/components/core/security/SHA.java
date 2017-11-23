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
* @Package：cn.ucaner.components.core.security   
* @ClassName：SHA   
* @Description：   <p> SHA</p>
* @Author： - DaoDou 
* @CreatTime：2017年11月23日 下午11:20:37   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
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
