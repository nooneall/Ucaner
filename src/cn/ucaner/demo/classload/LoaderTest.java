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
package cn.ucaner.demo.classload;

import java.net.URL;

import cn.ucaner.demo.annodemo.Demo;

/**
* @Package：cn.ucaner.demo.classload   
* @ClassName：LoaderTest   
* @Description：   <p>类加载器学习</p>
* @Author： - DaoDou 
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class LoaderTest {  
  
    public static void main(String[] args) {  
        try {  
            System.out.println(ClassLoader.getSystemClassLoader());  
            System.out.println(ClassLoader.getSystemClassLoader().getParent());  
            System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
            URL systemResource = ClassLoader.getSystemClassLoader().getSystemResource("spring-mvc.xml");
            System.out.println(systemResource);
            
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}  