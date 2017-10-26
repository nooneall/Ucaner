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
package cn.ucaner.pattern.action.visitor.visitorAbs;

import cn.ucaner.pattern.action.visitor.visitorIml.ConcreateElementAdmin;
import cn.ucaner.pattern.action.visitor.visitorIml.ConcreateElementUser;


/***
 *作者：MirsFang    
 *模式：访问者模式
 *时间：2017/03/02/下午12:26  
 *备注  抽象访问者
 ***/

public interface IVisitor {
    //可以访问哪些对象
    public void visit(ConcreateElementUser user);
    public void visit(ConcreateElementAdmin admin);
}
