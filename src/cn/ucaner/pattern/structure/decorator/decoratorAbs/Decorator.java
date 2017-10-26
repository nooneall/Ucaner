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
package cn.ucaner.pattern.structure.decorator.decoratorAbs;


/***
 *作者：MirsFang    
 *模式：装饰器模式
 *时间：2017/03/01/下午12:48  
 *备注  抽象装饰器 这种方式看起来和静态代理模式很像 {@link structure.proxy.staticProxy.Proxy }
 ***/

public abstract class Decorator extends SchoolReport {
    private SchoolReport  schoolReport;

    public Decorator(SchoolReport schoolReport) {
        this.schoolReport = schoolReport;
    }

    public void report(){
        schoolReport.report();
    }

    @Override
    public void sign(String name) {
        schoolReport.sign(name);
    }
}
