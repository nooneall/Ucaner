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
package cn.ucaner.pattern.action.state.allState;

import cn.ucaner.pattern.action.state.absState.Context;
import cn.ucaner.pattern.action.state.absState.State;

/**
* @Package：cn.ucaner.pattern.action.state.allState   
* @ClassName：Run   
* @Description：   <p> 状态模式  - 运行状态</p>
* @Author： - DaoDou 
* @CreatTime：2017年10月26日 下午4:56:57   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class Run extends State {


    //运行状态不糊开门
    @Override
    public void open() {
        //状态修改
    }

    //运行状态门就是观者的
    @Override
    public void close() {

    }

    @Override
    public void run() {
        System.out.println("电梯正在运行");
    }

    //停止运行
    @Override
    public void stop() {
        context.setNowState(Context.stop);
        context.getNowState().stop();
    }
}
