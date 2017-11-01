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

import cn.ucaner.components.pay.util.WXPayUtil;

/**
 * Created by yangzhao on 17/8/8.
 */
public class WXRequestParams extends RequestParams {

    private String appId = WXPayUtil.APPID;

    private String mchId = WXPayUtil.MCHID;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }
}
