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
package cn.ucaner.common.file.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cn.ucaner.common.file.vo.FileInfo;

/**
* @Package：cn.ucaner.common.file.service   
* @ClassName：FileService   
* @Description：   <p> 文件上传工具</p>
* @Author： - DaoDou 
* @CreatTime：2017年8月30日 下午2:20:10   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public interface FileService {
	/**
	 * 单文件上传
	 * @param request
	 * @return
	 */
	public FileInfo upload(MultipartFile file, String moduleName);

	/**
	 * 多文件上传
	 * @param files
	 * @param request
	 * @return
	 */
	public List<FileInfo> uploads(MultipartFile[] files, String moduleName);

	/**
	 * 删除文件
	 * @param relativePath
	 */
	public void delete(String relativePath);

	/**
	 * 删除文件
	 * @param moduleName
	 * @param realName
	 */
	public void delete(String moduleName, String realName);
}
