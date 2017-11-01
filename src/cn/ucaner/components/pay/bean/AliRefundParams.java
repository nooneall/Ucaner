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

/**
 * Created by yangzhao on 17/8/8.
 */
public class AliRefundParams extends AliRequestParams {

    private String method = "alipay.trade.refund";

    private String version = "1.0";
    //订单支付时传入的商户订单号
    private String outTradeNo;
    //需要退款的金额，该金额不能大于订单金额,单位为元，支持两位小数
    private double refundAmount;


    public String getMethod() {
        return method;
    }

    public String getVersion() {
        return version;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(double refundAmount) {
        this.refundAmount = refundAmount;
    }


}
