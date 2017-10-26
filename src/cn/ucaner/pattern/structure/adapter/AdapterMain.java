package cn.ucaner.pattern.structure.adapter;

import cn.ucaner.pattern.structure.adapter.adapterAbs.IUserInfo;

/***
 *作者：MirsFang    
 *模式：适配器模式
 *时间：2017/03/10/下午1:04  
 *备注  适配器模式执行类
 ***/

public class AdapterMain {
    public static void main(String[] args) {
        //得到一个其他的用户类型
        IUserInfo iUserInfo=new UserAdapter();
        iUserInfo.getHomeAddress();
        //得到一个自己的用户类
        IUserInfo iUserInfoMy=new MeUserInfo();
        iUserInfoMy.getHomeAddress();
    }
}
