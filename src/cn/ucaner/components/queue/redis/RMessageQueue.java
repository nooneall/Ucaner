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
package cn.ucaner.components.queue.redis;

import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;
import cn.ucaner.components.core.json.JSON;
import cn.ucaner.components.core.redis.RedisUtil;
import cn.ucaner.components.queue.IMessageQueue;
import cn.ucaner.components.queue.QueueHandler;

/**
 * 基于redis实现消息队列
 * Created by yangzhao on 16/11/14.
 */
@Component("rMessageQueue")
public class RMessageQueue implements IMessageQueue {
    @Override
    public boolean publish(String channel, Object o) {
        Jedis jedis = RedisUtil.getInstance().getJedis();
        String jsonString = JSON.iJsonInterface.toJsonString(o);
        Long publisher = jedis.publish(channel,jsonString);
        logger.info("订阅该频道的人数：" + publisher);
        jedis.close();
        return true;
    }

    @Override
    public void subscribe(String channel, final QueueHandler queueHandler) throws Exception {
        Jedis jedis = RedisUtil.getInstance().getJedis();
        jedis.subscribe(new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                queueHandler.responseData(message);
            }
        }, channel);
//		    jedis.close();
    }

    @Override
    public void put(String channel, Object o) throws InterruptedException {
        this.publish(channel, o);
    }
}
