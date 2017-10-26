package cn.ucaner.pattern.action.state;


import cn.ucaner.pattern.action.state.absState.Context;
import cn.ucaner.pattern.action.state.allState.Run;

/***
 *作者：MirsFang    
 *模式：状态模式
 *时间：2017/03/16/下午12:36  
 *备注  执行类
 ***/

public class StateMain {
    public static void main(String[] args) {
        Context context=new Context();
        context.setNowState(new Run());
        context.open();
        context.close();
        context.run();
        context.stop();
    }
}
