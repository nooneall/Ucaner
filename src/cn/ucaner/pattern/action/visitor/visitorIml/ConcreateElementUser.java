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
package cn.ucaner.pattern.action.visitor.visitorIml;


import java.util.Random;

import cn.ucaner.pattern.action.visitor.visitorAbs.Element;
import cn.ucaner.pattern.action.visitor.visitorAbs.IVisitor;

/***
 *作者：MirsFang    
 *模式：访问者模式
 *时间：2017/03/02/下午12:30  
 *备注  具体元素--用户
 ***/

    public class ConcreateElementUser extends Element {

    @Override
    public void doVisite() {
        Random random=new Random();
        System.out.println("我是用户,在线时长 "+random.nextInt(100)+" 分钟 ***********");
    }

    @Override
    public void accept(IVisitor iVisitor) {
        iVisitor.visit(this);
    }
}
