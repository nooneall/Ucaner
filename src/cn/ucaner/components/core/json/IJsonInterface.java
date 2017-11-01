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
package cn.ucaner.components.core.json;

import java.util.List;

/**
 * json接口
 *
 * @auther yangzhao
 * create by 17/10/9
 */
public interface IJsonInterface {

    public <T> T parseObject(String json,Class<T> t);

    public <T> List<T> parseList(String json, Class<T> t);

    public String toJsonString(Object obj);

}
