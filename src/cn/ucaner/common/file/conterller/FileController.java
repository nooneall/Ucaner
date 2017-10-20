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
package cn.ucaner.common.file.conterller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.ucaner.common.file.service.FileService;
import cn.ucaner.common.file.vo.FileInfo;

/**
* @Package：cn.ucaner.common.file.conterller   
* @ClassName：FileController   
* @Description：   <p> 文件管理</p>
* @Author： - DaoDou 
* @CreatTime：2017年8月30日 下午2:19:05   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
//@Controller
//@RequestMapping("/file")
public class FileController {
	
	//@Autowired
	private FileService fileService;

	@ResponseBody
	@RequestMapping("/upload")
	public FileInfo upload(@RequestParam MultipartFile file, HttpServletRequest request) {
		return fileService.upload(file, request.getParameter("moduleName"));
	}

	@ResponseBody
	@RequestMapping("/uploads")
	public List<FileInfo> uploads(@RequestParam MultipartFile[] files, HttpServletRequest request) {
		return fileService.uploads(files, request.getParameter("moduleName"));
	}

}
