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
package cn.ucaner.pattern.action.command.command;

import cn.ucaner.pattern.action.command.absCommand.Command;


/***
 *作者：MirsFang    
 *模式：命令模式
 *时间：2017/03/14/下午1:06  
 *备注  新增一个页面
 ***/

public class AddPageCommand extends Command {
	
    @Override
    public void execute() {
        product.getCommand();
        ui.getCommand();
        code.getCommand();

        product.doAdd();
        product.plan();
        ui.doAdd();
        ui.plan();
        code.doAdd();
        code.plan();
    }
}
