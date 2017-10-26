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


/***
 *作者：MirsFang
 *模式：状态模式
 *时间：2017/03/16/下午12:23
 *备注  停止状态
 ***/

public class Stop extends State {

//停下来要开电梯门
    @Override
    public void open() {
        context.setNowState(Context.open);
        context.getNowState().open();
    }


    @Override
    public void close() {

    }

    @Override
    public void run() {
        context.setNowState(Context.run);
        context.getNowState().run();
    }

    @Override
    public void stop() {
        System.out.println("电梯停止了");
    }
}
