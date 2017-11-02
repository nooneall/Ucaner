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
package cn.ucaner.tools.bloomFilter.bitMap;

public interface BitMap {

	public final int MACHINE32 = 32;
	public final int MACHINE64 = 64;

	public void add(long i);

	public boolean contains(long i);

	public void remove(long i);
}