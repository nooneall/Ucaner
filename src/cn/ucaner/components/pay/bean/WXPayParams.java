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

import cn.ucaner.components.core.utils.UUIDUtil;

/**
 * Created by yangzhao on 17/8/8.
 */
public class WXPayParams extends WXRequestParams {
    //预支付订单id
    private String prepayId;
    //扩展字段 填写固定值Sign=WXPay
    private String pkg = "Sign=WXPay";

    private String noncestr = UUIDUtil.getUUID();

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getPkg() {
        return pkg;
    }

    public String getNoncestr() {
        return noncestr;
    }

}
