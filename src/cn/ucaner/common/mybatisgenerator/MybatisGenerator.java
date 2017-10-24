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
package cn.ucaner.common.mybatisgenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
* @Package：cn.ucaner.common.mybatisgenerator   
* @ClassName：MybatisGenerator   
* @Description：   <p> MybatisGenerator mybatis自动生成工具的具体实现</p>
* @Author： - DaoDou 
* @CreatTime：2017年10月20日 下午3:53:05   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
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
			System.out.println("[生成警告:]"+warnings.get(i));
		}

	}
}
