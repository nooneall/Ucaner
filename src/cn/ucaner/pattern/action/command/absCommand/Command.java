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
package cn.ucaner.pattern.action.command.absCommand;

import cn.ucaner.pattern.action.command.Code;
import cn.ucaner.pattern.action.command.Product;
import cn.ucaner.pattern.action.command.UI;


/***
 *作者：MirsFang    
 *模式： 命令模式
 *时间：2017/03/14/下午12:57  
 *备注  处理命令
 ***/

public abstract class Command {
    protected Product product=new Product();
    protected UI ui=new UI();
    protected Code code =new Code();
    //执行
    public abstract void execute();
}
