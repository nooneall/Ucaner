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
package cn.ucaner.components.pay.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;

import cn.ucaner.components.core.config.Application;
import cn.ucaner.components.core.utils.MD5Util;

public class WXPayUtil {

	public static final String KEY="1d47f3da59e248b290f6a4f83ab08e73";

	public static final String APPID="wxce12d833b00981b7";

	public static final String MCHID="1446023502";
    //微信回调接口
	public static final String pay_notify_url = "http://test.huamaiwebchat.com/pay/weixin/notify";

	public static  String getSign(Map<String,String> map){
        ArrayList<String> list = new ArrayList<String>();
        for(Map.Entry<String,String> entry:map.entrySet()){
            if(entry.getValue()!=""){
                list.add(entry.getKey() + "=" + entry.getValue() + "&");
            }
        }
        int size = list.size();
        String [] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i ++) {
            sb.append(arrayToSort[i]);
        }
        String result = sb.toString();
        result += "key=" +KEY;
        result = MD5Util.MD5Encode(result, Application.sysConfig.getCharsetName()).toUpperCase();
        return result;
    }

	public static String getSign(List<NameValuePair> params) {
		ArrayList<String> list = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		for(NameValuePair pair:params){
			list.add(pair.getName() + "=" + pair.getValue() + "&");
		}
		int size = list.size();
        String [] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        for(int i = 0; i < size; i ++) {
            sb.append(arrayToSort[i]);
        }
        String result = sb.toString();
        result += "key=" +KEY;
        byte[] data=null;
		try {
			data = result.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        String appSign = MD5Util.sign(data).toUpperCase();
		return appSign;
	}
}
