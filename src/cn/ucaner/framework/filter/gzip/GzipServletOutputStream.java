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
package cn.ucaner.framework.filter.gzip;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;

/**
 * GZIP压缩传输.
 * @Package: com.sunshine.framework.filter.gzip
 * @ClassName: GzipFilter
 * @Statement: <p>
 * GZipServletOutputStream继承自ServletOutputStream
 * 该类的对象用于替换HttpServletResponse.getOutputStream()方法返回的ServletOutputStream对象 其内部使用GZipServletOutputStream的write(int
 * b)方法实现ServletOutputStream类的write(int b)方法 以达到压缩数据的目的
 *             </p>
 * @JDK version used:
 * @Author: 申姜
 * @Create Date: 2016-4-2
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public class GzipServletOutputStream extends ServletOutputStream {
	private ByteArrayOutputStream buffer;

	public GzipServletOutputStream(ByteArrayOutputStream buffer) {
		this.buffer = buffer;
	}

	public void write(int b) throws IOException {
		buffer.write(b);
	}

	//jdk7有错误，增加未实现方法 青蒿 20160927
	public byte[] toByteArray() {
		return buffer.toByteArray();
	}
}
