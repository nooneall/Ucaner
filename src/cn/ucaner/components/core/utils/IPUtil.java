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
package cn.ucaner.components.core.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import cn.ucaner.components.core.json.JSON;

/**
* @Package：cn.ucaner.components.core.utils   
* @ClassName：IPUtil   
* @Description：   <p> IP工具类</p>
* @Author： - DaoDou 
* @CreatTime：2017年11月23日 下午11:28:47   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class IPUtil {

    private static final String SINA_API="http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json&ip=";
    
    private static final String TAOBAO_API="http://ip.taobao.com/service/getIpInfo.php?ip=";

    /**
     * 免费IP查询接口
     * @param ip
     * @return
     */
    public static Map query(String ip){
        String request = HttpUtil.getRequest(SINA_API+ip);
        HashMap responseData = JSON.iJsonInterface.parseObject(request, HashMap.class);
        Set set = responseData.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            String key = iterator.next().toString();
            responseData.put(key,new String(responseData.get(key).toString()));
        }
        return responseData;
    }

}
