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
package cn.ucaner.common.utils.file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
* @Package：cn.ucaner.common.utils.file   
* @ClassName：ZipUitls   
* @Description：   <p> 文件压缩,解压工具类,文件压缩格式为zip</p>
* @Author： - DaoDou 
* @CreatTime：2017年10月26日 上午11:07:23   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class ZipUitls {
	
	/** 文件后缀名 */
	private static final String ZIP_FILE_SUFFIX = ".zip";
	
	/**
	 * 压缩文件
	 * @param resourcePath 源文件
	 * @param targetPath 目的文件,保存文件路径
	 */
	public static void zipFile(String resourcePath,String targetPath){
		File resourcesFile = new File(resourcePath); 
		File targetFile = new File(targetPath);
		
		//目的文件不存在，则新建
		if(!targetFile.exists()){
			targetFile.mkdirs();
		}
		//文件名
		String targetName = resourcesFile.getName() + ZIP_FILE_SUFFIX;
		
		ZipOutputStream out = null;
		try {
			FileOutputStream outputStream = new FileOutputStream(targetPath+"//"+targetName);
			out = new ZipOutputStream(new BufferedOutputStream(outputStream));

			compressedFile(out, resourcesFile, "");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		}
	}

	/**
	 * @param out
	 * @param resourcesFile
	 * @param dir
	 */
	private static void compressedFile(ZipOutputStream out, File file, String dir) {
		FileInputStream fis = null;
		try {
			if (file.isDirectory()) {	//文件夹
				// 得到文件列表信息
				File[] files = file.listFiles();
				// 将文件夹添加到下一级打包目录
				out.putNextEntry(new ZipEntry(dir + "/"));

				dir = dir.length() == 0 ? "" : dir + "/";

				// 循环将文件夹中的文件打包
				for (int i = 0; i < files.length; i++) {
					compressedFile(out, files[i], dir + files[i].getName()); // 递归处理
				}
			} else { 	//如果是文件则打包处理
				fis = new FileInputStream(file);

				out.putNextEntry(new ZipEntry(dir));
				// 进行写操作
				int j = 0;
				byte[] buffer = new byte[1024];
				while ((j = fis.read(buffer)) > 0) {
					out.write(buffer, 0, j);
				}
				// 关闭输入流
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
