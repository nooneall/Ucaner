/**
 * <html>
 * <body>
 *  <P> Copyright 2014 广东天泽阳光康众医疗投资管理有限公司. 粤ICP备09007530号-15</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2016年4月2日</p>
 *  <p> Created by 无名子</p>
 *  </body>
 * </html>
 */
package cn.ucaner.common.spring.ext.config;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.util.CollectionUtils;

/**
 * @Package: com.sunshine.framework.common.spring.ext.config
 * @ClassName: YCTPropertyPlaceholderConfigurer
 * @Statement: <p>扩展PropertyPlaceholderConfigurer 使应用中能使用spring的文件解析类库 </p>
 * @JDK version used: 1.6
 * @Author: 无名子
 * @Create Date: 2016-4-2
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public class ExtPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	public ExtPropertyPlaceholderConfigurer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Return a merged Properties instance containing both the
	 * loaded properties and properties set on this FactoryBean.
	 */
	public Properties mergeProperties() throws IOException {
		Properties result = new Properties();

		if (this.localOverride) {
			// Load properties from file upfront, to let local properties override.
			loadProperties(result);
		}

		if (this.localProperties != null) {
			for (Properties localProp : this.localProperties) {
				CollectionUtils.mergePropertiesIntoMap(localProp, result);
			}
		}

		if (!this.localOverride) {
			// Load properties from file afterwards, to let those properties override.
			loadProperties(result);
		}

		return result;
	}

	public Map<String, String> convertPropsToMap(java.util.Properties props) {
		Map<String, String> propsMap = new HashMap<String, String>();
		Enumeration<?> propertyNames = props.propertyNames();
		do {
			if (!propertyNames.hasMoreElements()) {
				break;
			}
			java.lang.String propertyName = (java.lang.String) propertyNames.nextElement();
			java.lang.String propertyValue = props.getProperty(propertyName);
			propsMap.put(propertyName, propertyValue);

		} while (true);
		return propsMap;
	}
}
