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

/***
 *作者：MirsFang
 *模式：代理模式
 *时间：2017/2/28/
 *备注  代理模式真实类
 ***/
public class RealSuject implements Subject {
    @Override
    public void request() {
        System.out.print("do request");
    }
}
