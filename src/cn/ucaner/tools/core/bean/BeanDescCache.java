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
package cn.ucaner.tools.core.bean;

import cn.ucaner.tools.core.lang.SimpleCache;

/**
 * Bean属性缓存<br>
 * 缓存用于防止多次反射造成的性能问题
 * @author Looly
 *
 */
public enum BeanDescCache {
	
	INSTANCE;
	
	private SimpleCache<Class<?>, BeanDesc> bdCache = new SimpleCache<>();
	
	/**
	 * 获得属性名和{@link BeanDesc}Map映射
	 * @param beanClass Bean的类
	 * @return 属性名和{@link BeanDesc}映射
	 */
	public BeanDesc getBeanDesc(Class<?> beanClass){
		return bdCache.get(beanClass);
	}
	
	/**
	 * 加入缓存
	 * @param beanClass Bean的类
	 * @param BeanDesc 属性名和{@link BeanDesc}映射
	 */
	public void putBeanDesc(Class<?> beanClass, BeanDesc BeanDesc){
		bdCache.put(beanClass, BeanDesc);
	}
}
