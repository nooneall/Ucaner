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
package cn.ucaner.weibo.model;

/**
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public class Version {
    private final static String VERSION = "1.0.0";
    private final static String TITLE = "weibo4jV2";

    public static String getVersion(){
        return VERSION;
    }
    public static void main(String[] args) {
        System.out.println(TITLE +" " + VERSION);
    }
}
