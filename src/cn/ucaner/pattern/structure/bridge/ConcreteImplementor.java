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
package cn.ucaner.pattern.structure.bridge;

import cn.ucaner.pattern.structure.bridge.abs.Implementor;


/***
 *作者：MirsFang    
 *模式：桥接模式
 *时间：2017/04/05/下午12:24  
 *备注  具体实现类
 ***/

public class ConcreteImplementor implements Implementor {
    @Override
    public void doSomethingA() {
        System.out.println("bridge do something A");
    }

    @Override
    public void doSomethingB() {
        System.out.println("bridge do something B");
    }
}
