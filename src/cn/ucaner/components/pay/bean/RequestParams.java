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
package cn.ucaner.components.pay.bean;


import java.util.Random;

import cn.ucaner.components.core.utils.MD5Util;

/**
 * Created by yangzhao on 17/8/8.
 */
public abstract class RequestParams {

    public String genNonceStr() {
        Random random = new Random();
        return MD5Util.md5(String.valueOf(random.nextInt(10000)));
    }
}
