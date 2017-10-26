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
package cn.ucaner.pattern.create.factory;

/***             
 *作者：MirsFang    
 *模式：工厂模式
 *时间：2017/05/05/上午10:12  
 *备注  抽象出来的工厂
 ***/

public abstract class AbsHumanFactory {
    public abstract <T extends Human> T createHumen(Class<T> tClass);
}
