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

import org.apache.http.NameValuePair;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.*;


/**
* @Package：cn.ucaner.components.core.utils   
* @ClassName：XMLUtil   
* @Description：   <p> XMLUtil</p>
* @Author： - DaoDou 
* @CreatTime：2017年11月23日 下午11:34:19   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class XMLUtil {
    @SuppressWarnings("unchecked")
    public static Map<String, Object> getMapFromXML(String xml) {
        try {
            Document document = DocumentHelper.parseText(xml);
            Element rootElement = document.getRootElement();
            List<Element> elements = rootElement.elements();
            return parseElements(elements);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> getMapFromXML(InputStream is) {
        SAXReader reader = new SAXReader();
        Document document;
        try {
            document = reader.read(is);
            Element rootElement = document.getRootElement();
            return parseElements(rootElement.elements());
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> parseElements(List<Element> elements) {
        Map<String, Object> map = new HashMap<String, Object>();
        for (Element element : elements) {
            String key = element.getName();
            String value = element.getText();
            map.put(key, value);
        }
        return map;
    }
    /**
     * 请求参数转换xml
     * @param params
     * @return
     */
    public static String toXml(List<NameValuePair> params) {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        for (int i = 0; i < params.size(); i++) {
            sb.append("<" + params.get(i).getName() + ">");

            sb.append(params.get(i).getValue());
            sb.append("</" + params.get(i).getName() + ">");
        }
        sb.append("</xml>");
        return sb.toString();
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static String toXml(Map<String,String> map){
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        Set keySet = map.keySet();
        Iterator<String> iterator=keySet.iterator();
        while(iterator.hasNext()){
            String key=iterator.next();
            String value=map.get(key);
            sb.append("<" +key+ ">");
            sb.append(value);
            sb.append("</" +key + ">");
        }
        sb.append("</xml>");
        return sb.toString();
    }
}
