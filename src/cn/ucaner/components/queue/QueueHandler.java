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
package cn.ucaner.components.queue;

/**
 * 订阅数据回调业务层
 * Created by yangzhao on 16/11/14.
 */
public interface QueueHandler {

    public void responseData(String message);
}
