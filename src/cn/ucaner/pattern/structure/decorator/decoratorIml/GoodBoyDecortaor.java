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
package cn.ucaner.pattern.structure.decorator.decoratorIml;

import cn.ucaner.pattern.structure.decorator.decoratorAbs.Decorator;
import cn.ucaner.pattern.structure.decorator.decoratorAbs.SchoolReport;

/***
 *作者：MirsFang
 *模式：装饰器模式
 *时间：2017/03/01/下午12:53
 *备注  装饰在学校的表现
 ***/


public class GoodBoyDecortaor extends Decorator {
    public GoodBoyDecortaor(SchoolReport schoolReport) {
        super(schoolReport);
    }

    private void goodBoyDecorator(){
        System.out.println("我在学校表现很好,没毛病");
    }

    @Override
    public void report() {
        goodBoyDecorator();
        super.report();

    }
}
