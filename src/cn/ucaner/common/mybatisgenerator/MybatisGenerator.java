/**
 * <html>
 * <body>
 *  <P> Copyright 2014 广东天泽阳光康众医疗投资管理有限公司. 粤ICP备09007530号-15</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2016年4月6日</p>
 *  <p> Created by 申姜</p>
 *  </body>
 * </html>
 */
package cn.ucaner.common.mybatisgenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * @Project: sunshine_health 
 * @Package: com.sunshine.framework.utils
 * @ClassName: MybatisGenerator
 * @Description: <p></p>
 * @JDK version used: 
 * @Author: 申姜
 * @Create Date: 2016年4月6日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public class MybatisGenerator {
	public static void main(String[] args) {
		List<String> warnings = new ArrayList<String>();
		final boolean overwrite = true;
		File configFile = new File(System.getProperty("user.dir") + "/WebRoot/WEB-INF/classes/mybatis/generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		try {
			Configuration configuration = cp.parseConfiguration(configFile);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator mybatisGenerator = new MyBatisGenerator(configuration, callback, warnings);
			mybatisGenerator.generate(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 0; i < warnings.size(); i++) {
			System.out.println(warnings.get(i));
		}

	}
}
