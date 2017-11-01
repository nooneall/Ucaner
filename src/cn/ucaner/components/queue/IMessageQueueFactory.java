package cn.ucaner.components.queue;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.ucaner.components.queue.jdk.JMessageQueue;
import cn.ucaner.components.queue.redis.RMessageQueue;

/**
 * Created by yangzhao on 16/8/28.
 */
@Component
public class IMessageQueueFactory {

    @Resource(name = "jMessageQueue")
    private JMessageQueue jMessageQueue;

    @Resource(name = "rMessageQueue")
    private RMessageQueue rMessageQueue;

    private IMessageQueue iMessageQueue = null;

    /**
     * 1=jdk默认实现 2=redis 3=kafka 4=rabbitmq
     * @param type
     */
    public void init(int type){
        switch (type){
            case 1 :
                iMessageQueue = jMessageQueue;
                break;
            case 2:
                iMessageQueue = rMessageQueue;
                break;
        }
    }

    public IMessageQueue getIMessageQueue(){
        return iMessageQueue;
    }
}
