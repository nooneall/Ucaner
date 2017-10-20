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
package cn.ucaner.demo.reflect.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import cn.ucaner.demo.reflect.InitData;

public class testReflect {
	
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		InitData initData = new InitData();
		
		Method[] methods = InitData.class.getDeclaredMethods();
		
		for (Method method : methods) {
			System.out.println(method.getName()+":");
			method.invoke(initData, "sss");
			
		}
		
	}
	
}
