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
package cn.ucaner.common.file.vo;

import java.io.Serializable;

import cn.ucaner.framework.mvc.controller.RespBody;
/**
* @Package：cn.ucaner.common.file.vo   
* @ClassName：FileInfo   
* @Description：   <p> 文件信息</p>
* @Author： - DaoDou 
* @CreatTime：2017年8月30日 下午2:20:53   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class FileInfo extends RespBody implements Serializable {

	private static final long serialVersionUID = -1312635958750443602L;
	/**
	 * 原始文件名称
	 */
	private String originalName;
	/**
	 * 真实文件名称
	 */
	private String realName;
	/**
	 * 相对路径
	 */
	private String relativePath;
	/**
	 * 绝对路径
	 */
	private String absolutePath;
	/**
	 * 扩展名
	 */
	private String extName;
	/**
	 * 附件大小(以字节为单位)
	 */
	private Long fileSize;

	public FileInfo() {
		super();
	}

	/**
	 * 
	 * @param originalName
	 * @param realName
	 * @param relativePath
	 * @param absolutePath
	 * @param extName
	 * @param fileSize
	 */
	public FileInfo(String originalName, String realName, String relativePath, String absolutePath, String extName, Long fileSize) {
		super();
		this.originalName = originalName;
		this.realName = realName;
		this.relativePath = relativePath;
		this.absolutePath = absolutePath;
		this.extName = extName;
		this.fileSize = fileSize;
	}

	/**
	 * @return the originalName
	 */
	public String getOriginalName() {
		return originalName;
	}

	/**
	 * @param originalName the originalName to set
	 */
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	/**
	 * @return the realName
	 */
	public String getRealName() {
		return realName;
	}

	/**
	 * @param realName the realName to set
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}

	/**
	 * @return the relativePath
	 */
	public String getRelativePath() {
		return relativePath;
	}

	/**
	 * @param relativePath the relativePath to set
	 */
	public void setRelativePath(String relativePath) {
		this.relativePath = relativePath;
	}

	/**
	 * @return the absolutePath
	 */
	public String getAbsolutePath() {
		return absolutePath;
	}

	/**
	 * @param absolutePath the absolutePath to set
	 */
	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}

	/**
	 * @return the extName
	 */
	public String getExtName() {
		return extName;
	}

	/**
	 * @param extName the extName to set
	 */
	public void setExtName(String extName) {
		this.extName = extName;
	}

	/**
	 * @return the fileSize
	 */
	public Long getFileSize() {
		return fileSize;
	}

	/**
	 * @param fileSize the fileSize to set
	 */
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

}
