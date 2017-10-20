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

import static org.mybatis.generator.internal.util.StringUtility.isTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.InnerEnum;
import org.mybatis.generator.api.dom.java.JavaElement;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.MergeConstants;
import org.mybatis.generator.config.PropertyRegistry;

/**
* @Package：cn.ucaner.common.mybatisgenerator   
* @ClassName：MyCommentGenerator   
* @Description：   <p> 修改mybatisGenerator生成的注释 </p>
* @Author： - DaoDou 
* @CreatTime：2017年10月20日 下午3:53:57   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class MyCommentGenerator implements CommentGenerator {
	private Properties properties;
	private boolean suppressDate;
	private boolean suppressAllComments;

	public MyCommentGenerator() {
		super();
		properties = new Properties();
		suppressDate = false;
		suppressAllComments = false;
	}

	public void addJavaFileComment(CompilationUnit compilationUnit) {
		if (suppressAllComments) {
			return;
		}
		Calendar cal = Calendar.getInstance();
		compilationUnit.addFileCommentLine("/**");
		compilationUnit.addFileCommentLine("* <html>");
		compilationUnit.addFileCommentLine("*  <body>");
		compilationUnit.addFileCommentLine("*   <P> Copyright 1994 JasonInternational</p>");
		compilationUnit.addFileCommentLine("*   <p> All rights reserved.</p>");
		compilationUnit.addFileCommentLine("*   <p> Created on " + cal.get(Calendar.YEAR) + "年" + ( cal.get(Calendar.MONTH) + 1 ) + "月"
				+ cal.get(Calendar.DAY_OF_MONTH) + "日" + "</p>");
		compilationUnit.addFileCommentLine("*   <p> Created by 姓名</p>");
		compilationUnit.addFileCommentLine("*  </body>");
		compilationUnit.addFileCommentLine("* </html>");
		compilationUnit.addFileCommentLine("*/");
	}

	/**
	 * Adds a suitable comment to warn users that the element was generated, and
	 * when it was generated.
	 */
	public void addComment(XmlElement xmlElement) {
		if (suppressAllComments) {
			return;
		}

		xmlElement.addElement(new TextElement("<!--")); //$NON-NLS-1$

		StringBuilder sb = new StringBuilder();
		sb.append("  WARNING - "); //$NON-NLS-1$
		sb.append(MergeConstants.NEW_ELEMENT_TAG);
		xmlElement.addElement(new TextElement(sb.toString()));
		xmlElement.addElement(new TextElement("  This element is automatically generated by MyBatis Generator, do not modify.")); //$NON-NLS-1$

		String s = getDateString();
		if (s != null) {
			sb.setLength(0);
			sb.append("  This element was generated on "); //$NON-NLS-1$
			sb.append(s);
			sb.append('.');
			xmlElement.addElement(new TextElement(sb.toString()));
		}

		xmlElement.addElement(new TextElement("-->")); //$NON-NLS-1$
	}

	public void addRootComment(XmlElement rootElement) {
		// add no document level comments by default
		return;
	}

	public void addConfigurationProperties(Properties properties) {
		this.properties.putAll(properties);

		suppressDate = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE));

		suppressAllComments = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));
	}

	/**
	 * This method adds the custom javadoc tag for. You may do nothing if you do
	 * not wish to include the Javadoc tag - however, if you do not include the
	 * Javadoc tag then the Java merge capability of the eclipse plugin will
	 * break.
	 * 
	 * @param javaElement
	 *            the java element
	 */
	protected void addJavadocTag(JavaElement javaElement, boolean markAsDoNotDelete) {
		javaElement.addJavaDocLine(" *"); //$NON-NLS-1$
		StringBuilder sb = new StringBuilder();
		sb.append(" * "); //$NON-NLS-1$
		sb.append(MergeConstants.NEW_ELEMENT_TAG);
		if (markAsDoNotDelete) {
			sb.append(" do_not_delete_during_merge"); //$NON-NLS-1$
		}
		String s = getDateString();
		if (s != null) {
			sb.append(' ');
			sb.append(s);
		}
		javaElement.addJavaDocLine(sb.toString());
	}

	/**
	 * This method returns a formated date string to include in the Javadoc tag
	 * and XML comments. You may return null if you do not want the date in
	 * these documentation elements.
	 * 
	 * @return a string representing the current timestamp, or null
	 */
	protected String getDateString() {
		if (suppressDate) {
			return null;
		} else {
			return new Date().toString();
		}
	}

	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
		Calendar cal = Calendar.getInstance();
		innerClass.addJavaDocLine("/**");
		innerClass.addJavaDocLine("* 请添加类文件说明注释");
		innerClass.addJavaDocLine("* @Project: 请添加你的项目名称");
		innerClass.addJavaDocLine("* @Package: 请添加你的包路径");
		innerClass.addJavaDocLine("* @ClassName: 请添加你的类名称");
		innerClass.addJavaDocLine("* @Description: <p></p>");
		innerClass.addJavaDocLine("* @JDK version used: ");
		innerClass.addJavaDocLine("* @Author: 请添加你的姓名");
		innerClass.addJavaDocLine("* @Create Date: " + cal.get(Calendar.YEAR) + "年" + ( cal.get(Calendar.MONTH) + 1 ) + "月"
				+ cal.get(Calendar.DAY_OF_MONTH) + "日");
		innerClass.addJavaDocLine("* @modify By:");
		innerClass.addJavaDocLine("* @modify Date:");
		innerClass.addJavaDocLine("* @Why&What is modify:");
		innerClass.addJavaDocLine("* @Version: 1.0");
		innerClass.addJavaDocLine("*/");
	}

	public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
		if (suppressAllComments) {
			return;
		}

		StringBuilder sb = new StringBuilder();

		innerEnum.addJavaDocLine("/**"); //$NON-NLS-1$
		innerEnum.addJavaDocLine(" * This enum was generated by MyBatis Generator."); //$NON-NLS-1$

		sb.append(" * This enum corresponds to the database table "); //$NON-NLS-1$
		sb.append(introspectedTable.getFullyQualifiedTable());
		innerEnum.addJavaDocLine(sb.toString());

		addJavadocTag(innerEnum, false);

		innerEnum.addJavaDocLine(" */"); //$NON-NLS-1$
	}

	public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
		if (introspectedColumn.getRemarks() != null && !introspectedColumn.getRemarks().equals("")) {
			field.addJavaDocLine("/**");
			field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
			//addJavadocTag(field, false);
			field.addJavaDocLine(" */");
		}
	}

	public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
		if (suppressAllComments) {
			return;
		}

		StringBuilder sb = new StringBuilder();

		field.addJavaDocLine("/**"); //$NON-NLS-1$
		field.addJavaDocLine(" * This field was generated by MyBatis Generator."); //$NON-NLS-1$

		sb.append(" * This field corresponds to the database table "); //$NON-NLS-1$
		sb.append(introspectedTable.getFullyQualifiedTable());
		field.addJavaDocLine(sb.toString());

		addJavadocTag(field, false);

		field.addJavaDocLine(" */"); //$NON-NLS-1$
	}

	public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
		if (suppressAllComments) {
			return;
		}

		StringBuilder sb = new StringBuilder();

		method.addJavaDocLine("/**"); //$NON-NLS-1$
		method.addJavaDocLine(" * This method was generated by MyBatis Generator."); //$NON-NLS-1$

		sb.append(" * This method corresponds to the database table "); //$NON-NLS-1$
		sb.append(introspectedTable.getFullyQualifiedTable());
		method.addJavaDocLine(sb.toString());

		addJavadocTag(method, false);

		method.addJavaDocLine(" */"); //$NON-NLS-1$
	}

	public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
		if (suppressAllComments) {
			return;
		}
		//获取get方法名
		String methodName = method.getName();
		//根据方法名取得属性名称
		String paramName = methodName.substring("get".length(), methodName.length());
		//首字母转小写
		paramName = paramName.substring(0, 1).toLowerCase() + paramName.substring(1);
		method.addJavaDocLine("/**");
		method.addJavaDocLine("* @return the " + paramName + ""); //$NON-NLS-1$
		method.addJavaDocLine("*/");

	}

	public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
		if (suppressAllComments) {
			return;
		}
		Parameter parm = method.getParameters().get(0);
		method.addJavaDocLine("/**");
		method.addJavaDocLine("* @param code");
		method.addJavaDocLine("*            the " + parm.getName() + " to set");
		method.addJavaDocLine("*/");
	}

	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {

		Calendar cal = Calendar.getInstance();
		innerClass.addJavaDocLine("/**");
		innerClass.addJavaDocLine("* 请添加类文件说明注释");
		innerClass.addJavaDocLine("* @Project: 请添加你的项目名称");
		innerClass.addJavaDocLine("* @Package: 请添加你的包路径");
		innerClass.addJavaDocLine("* @ClassName: 请添加你的类名称");
		innerClass.addJavaDocLine("* @Description: <p></p>");
		innerClass.addJavaDocLine("* @JDK version used: ");
		innerClass.addJavaDocLine("* @Author: 请添加你的姓名");
		innerClass.addJavaDocLine("* @Create Date: " + cal.get(Calendar.YEAR) + "年" + ( cal.get(Calendar.MONTH) + 1 ) + "月"
				+ cal.get(Calendar.DAY_OF_MONTH) + "日");
		innerClass.addJavaDocLine("* @modify By:");
		innerClass.addJavaDocLine("* @modify Date:");
		innerClass.addJavaDocLine("* @Why&What is modify:");
		innerClass.addJavaDocLine("* @Version: 1.0");
		innerClass.addJavaDocLine("*/");
	}

	@Override
	public void addModelClassComment(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		// TODO Auto-generated method stub
		
	}
}
