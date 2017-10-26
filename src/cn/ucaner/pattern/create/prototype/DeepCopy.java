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

import java.util.ArrayList;
import cn.ucaner.pattern.create.prototype.prototypeAbs.BaseMessage;

/***
 *作者：MirsFang    
 *模式：原型模式
 *时间：2017/03/08/下午12:21  
 *备注  原型模式深拷贝
 ***/

public class DeepCopy extends BaseMessage implements Cloneable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        DeepCopy deepCopy=null;
        try {
            deepCopy= (DeepCopy) super.clone();
            this.setImgList((ArrayList<String>) this.getImgList().clone());
        }catch (Exception e){
            e.printStackTrace();
        }
        return deepCopy;
    }
}
