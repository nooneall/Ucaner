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

/**
 * 过滤器BitMap在64位机器上.这个类能发生更好的效果.一般机器不建议使用
 * @author loolly
 *
 */
public class LongMap implements BitMap {

	private static final long MAX = Long.MAX_VALUE;

	public LongMap() {
		longs = new long[93750000];
	}

	public LongMap(int size) {
		longs = new long[size];
	}

	private long[] longs = null;

	public void add(long i) {
		int r = (int) (i / BitMap.MACHINE64);
		long c = i % BitMap.MACHINE64;
		longs[r] = longs[r] | (1 << c);
	}

	public boolean contains(long i) {
		int r = (int) (i / BitMap.MACHINE64);
		long c = i % BitMap.MACHINE64;
		if (((longs[r] >>> c) & 1) == 1) {
			return true;
		}
		return false;
	}

	public void remove(long i) {
		int r = (int) (i / BitMap.MACHINE64);
		long c =i % BitMap.MACHINE64;
		longs[r] = longs[r] & (((1 << (c + 1)) - 1) ^ MAX);
	}

}