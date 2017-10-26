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
package cn.ucaner.pattern.create.factory.human;

import cn.ucaner.pattern.create.factory.Human;

/***
 *作者：MirsFang    
 *模式：工厂模式
 *时间：2017/05/05/上午10:25  
 *备注  黑人
 ***/

public class BlackHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("黑人");
    }
}
