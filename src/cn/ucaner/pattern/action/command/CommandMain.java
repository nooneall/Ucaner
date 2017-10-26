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

import cn.ucaner.pattern.action.command.command.AddPageCommand;

/***
 *作者：MirsFang    
 *模式：命令模式
 *时间：2017/03/14/下午1:10  
 *备注  执行类
 ***/

public class CommandMain {

    public static void main(String[] args) {
        Invoker invoker=new Invoker();
        invoker.setCommand(new AddPageCommand());
        invoker.Action();
    }

}
