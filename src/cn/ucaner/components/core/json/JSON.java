package cn.ucaner.components.core.json;

import cn.ucaner.components.core.config.Application;

/**
 * json装饰类
 *
 * @auther yangzhao
 * create by 17/10/9
 */
public final class JSON {

    public static final IJsonInterface iJsonInterface;

    static {
        int json = Application.sysConfig.getJson();
        switch (json){
            case 1:
                iJsonInterface = new FastJson();
                break;
            case 2:
                iJsonInterface = new Jackson();
                break;
            default:
                iJsonInterface=new FastJson();
        }
    }
}
