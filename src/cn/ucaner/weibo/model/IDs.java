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
package cn.ucaner.weibo.model;

import java.util.Arrays;

import cn.ucaner.weibo.Weibo;
import cn.ucaner.weibo.http.Response;
import cn.ucaner.weibo.org.json.JSONArray;
import cn.ucaner.weibo.org.json.JSONException;
import cn.ucaner.weibo.org.json.JSONObject;


/**
 * A data class representing array of numeric IDs.
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @editor SinaWeibo
 */
public class IDs extends WeiboResponse {
    private long[] ids;           //ids
    private long previousCursor;  //当前cursor
    private long nextCursor;      //下一个cursor
    private static final long serialVersionUID = -6585026560164704953L;
    /*package*/ IDs(Response res,Weibo w) throws WeiboException {
        super(res);
        if("[]\n".equals(res.asString())){
        	previousCursor=0;
        	nextCursor=0;
        	ids= new long[0];
        	return;
        }
        JSONObject json=  res.asJSONObject();
        try {
        	previousCursor = json.getLong("previous_cursor");
            nextCursor = json.getLong("next_cursor");
        	
            if(!json.isNull("ids")){
        		JSONArray jsona= json.getJSONArray("ids");
        		int size=jsona.length();
        		ids =new long[ size];
        		for (int i = 0; i < size; i++) {
        			ids[i] =jsona.getLong(i);
				}
        	}
        	
         } catch (JSONException jsone) {
             throw new WeiboException(jsone);
         } 
        
    }

    public long[] getIDs() {
        return ids;
    }

    /**
     *
     * @since weibo4j-V2 1.0.0
     */
    public boolean hasPrevious(){
        return 0 != previousCursor;
    }

    /**
     *
     * @since weibo4j-V2 1.0.0
     */
    public long getPreviousCursor() {
        return previousCursor;
    }

    /**
     *
     * @since weibo4j-V2 1.0.0
     */
    public boolean hasNext(){
        return 0 != nextCursor;
    }

    /**
     *
     * @since weibo4j-V2 1.0.0
     */
    public long getNextCursor() {
        return nextCursor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IDs)) return false;

        IDs iDs = (IDs) o;

        if (!Arrays.equals(ids, iDs.ids)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ids != null ? Arrays.hashCode(ids) : 0;
    }

    @Override
    public String toString() {
        return "IDs{" +
                "ids=" + ids +
                ", previousCursor=" + previousCursor +
                ", nextCursor=" + nextCursor +
                '}';
    }
}