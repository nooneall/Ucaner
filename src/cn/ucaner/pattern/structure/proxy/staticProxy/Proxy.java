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
package cn.ucaner.pattern.structure.proxy.staticProxy;

import cn.ucaner.pattern.structure.decorator.decoratorAbs.Decorator;
/***
 *作者：MirsFang
 *模式：代理模式
 *时间：2017/2/28/
 *备注  代理模式代理类,他和装饰器模式的实现有点相近{@link Decorator}
 ***/
public class Proxy implements Subject {
    private Subject realSuject;

    public Proxy(Subject realSuject) {
        this.realSuject = realSuject;
    }

    @Override
    public void request() {
        if(realSuject!=null){
            realSuject.request();
        }
    }
}
