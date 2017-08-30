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
package cn.ucaner.common.file.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.ucaner.common.GlobalConstant;
import cn.ucaner.common.PKGenerator;
import cn.ucaner.common.file.conterller.FileController;
import cn.ucaner.common.file.service.FileService;
import cn.ucaner.common.file.vo.FileInfo;
import cn.ucaner.framework.config.SystemConfig;
import cn.ucaner.framework.config.SystemConstants;
import cn.ucaner.framework.mvc.controller.RespBody.Status;



/**
* @Package：cn.ucaner.common.file.service.impl   
* @ClassName：FileServiceImpl   
* @Description：   <p> TODO</p>
* @Author： - DaoDou 
* @CreatTime：2017年8月30日 下午2:20:36   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
//@Service
public class FileServiceImpl implements FileService {
	private static Logger logger = LoggerFactory.getLogger(FileController.class);

	@Override
	public FileInfo upload(MultipartFile file, String moduleName) {
		FileInfo fileInfo = new FileInfo();
		if (StringUtils.isEmpty(moduleName)) {
			logger.error("模块名称不能为空!");
			fileInfo.setStatus(Status.ERROR);
			fileInfo.setMessage("模块名称不能为空!");
			return fileInfo;
		}

		if (!file.isEmpty()) {
			// 原始名称
			String originalName = file.getOriginalFilename();
			// 文件扩展名
			String extName = originalName.substring(originalName.lastIndexOf(".") + 1, originalName.length());
			// 存档后的真实名称
			String realName = PKGenerator.generateId() + "." + extName;
			// 相对路径
			String relativePath = SystemConstants.FILE_SEPARATOR + moduleName + SystemConstants.FILE_SEPARATOR
					+ realName;
			// 绝对路径
			String absolutePath = GlobalConstant.filePath + relativePath;
			// 存档目录路径
			// String catalogPath = SystemConfig.getStringValue("file_path") +
			// SystemConstants.FILE_SEPARATOR + moduleName;
			// 文件大小
			long fileSize = file.getSize();
			File localFile = new File(absolutePath);
			try {
				if (!localFile.getParentFile().exists()) {
					localFile.getParentFile().mkdirs();
				}
				file.transferTo(localFile);
				fileInfo.setStatus(Status.OK);
				fileInfo.setOriginalName(originalName);
				fileInfo.setRealName(realName);
				fileInfo.setRelativePath(relativePath);
				fileInfo.setAbsolutePath(absolutePath);
				fileInfo.setExtName(extName);
				fileInfo.setFileSize(fileSize);
				
				logger.info("图片上传成功,图片url:{}", fileInfo.getRelativePath());
			} catch (IllegalStateException e) {
				logger.error("文件上传异常!", e);
				fileInfo.setStatus(Status.ERROR);
				fileInfo.setMessage("文件上传异常!");
			} catch (IOException e) {
				logger.error("文件上传异常!", e);
				fileInfo.setStatus(Status.ERROR);
				fileInfo.setMessage("文件上传异常!");
			}
		} else {
			logger.error("没有发现需要上传的文件!");
			fileInfo.setStatus(Status.ERROR);
			fileInfo.setMessage("没有发现需要上传的文件!");
		}
		return fileInfo;
	}

	@Override
	public List<FileInfo> uploads(MultipartFile[] files, String moduleName) {
		List<FileInfo> fileInfos = new ArrayList<FileInfo>();
		for (MultipartFile file : files) {
			FileInfo fileInfo = upload(file, moduleName);
			fileInfos.add(fileInfo);
		}
		return fileInfos;
	}

	@Override
	public void delete(String relativePath) {
		String absolutePath = SystemConfig.getStringValue("file_path") + SystemConstants.FILE_SEPARATOR + relativePath;
		File file = new File(absolutePath);
		if (file.exists()) {
			file.delete();
		}
	}

	@Override
	public void delete(String moduleName, String realName) {
		String relativePath = moduleName + SystemConstants.FILE_SEPARATOR + realName;
		String absolutePath = SystemConfig.getStringValue("file_path") + SystemConstants.FILE_SEPARATOR + relativePath;
		File file = new File(absolutePath);
		if (file.exists()) {
			file.delete();
		}
	}

}
