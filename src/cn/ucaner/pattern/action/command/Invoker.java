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
package cn.ucaner.pattern.action.command;

import cn.ucaner.pattern.action.command.absCommand.Command;

/***
 *作者：MirsFang    
 *模式：命令模式
 *时间：2017/03/14/下午1:09  
 *备注  负责人
 ***/

public class Invoker   {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void setCommand(String str) {

    }

    public  void Action() {
        this.command.execute();
    }
}
