package cn.ucaner.pattern.structure.flyweight;


import java.util.Random;

import cn.ucaner.pattern.structure.flyweight.flyweightAbs.Flyweight;

/***
 *作者：MirsFang    
 *模式：享元模式
 *时间：2017/03/09/下午12:35  
 *备注  具体享元对象
 ***/

public class ConcreateFlyweight_1 extends Flyweight{

    //接受外部状态
    public ConcreateFlyweight_1(String extrinsic) {
        super(extrinsic);
    }

    //根据外部状态进行逻辑处理
    @Override
    public void operate() {
        System.out.println(Extrinsic+"订单,订单编号"+new Random().nextInt(99999));
    }
}
