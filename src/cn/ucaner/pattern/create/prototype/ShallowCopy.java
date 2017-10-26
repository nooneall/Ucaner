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
package cn.ucaner.pattern.create.prototype;

import cn.ucaner.pattern.create.prototype.prototypeAbs.BaseMessage;

/***
 *作者：MirsFang    
 *模式： 原型模式
 *时间：2017/03/08/下午12:21  
 *备注  浅拷贝的对象
 ***/

public class ShallowCopy  extends BaseMessage implements Cloneable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ShallowCopy shallowCopy=null;
        try {
            shallowCopy= (ShallowCopy) super.clone();
        }catch (Exception e){
            e.printStackTrace();
        }
        return shallowCopy;
    }


}
