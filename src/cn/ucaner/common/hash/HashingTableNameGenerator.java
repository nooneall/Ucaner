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
package cn.ucaner.common.hash;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import redis.clients.util.Hashing;
import redis.clients.util.MurmurHash;

/**
* @Package：cn.ucaner.common.hash   
* @ClassName：HashingTableNameGenerator   
* @Description：   <p> 表明生成器 </p>
* @Author： - DaoDou 
* @CreatTime：2017年8月30日 下午2:24:13   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class HashingTableNameGenerator {
	
	/**
	 * 虚拟节点数
	 */
	public static final int DUMMY_NODE_NUM = 3000;

	/**
	 * MurmurHash算法
	 */
	public static final Hashing MURMUR_HASH = new MurmurHash();

	/**
	 * hash存储
	 */
	private static final Map<String, TreeMap<Long, String>> resources = new LinkedHashMap<String, TreeMap<Long, String>>();
	
	public static final int subTableCount = 10;

	public static String[] tableNames = new String[] {};

	static {
		TreeMap<Long, String> nodes = null;
		List<String> subTableNames = null;
		for (String tableName : tableNames) {
			subTableNames = new ArrayList<String>();
			for (int i = 1; i < subTableCount + 1; i++) {
				subTableNames.add(tableName.concat("_") + i);
			}
			nodes = new TreeMap<Long, String>();
			for (int i = 0; i != subTableNames.size(); ++i) {
				final String subTableName = subTableNames.get(i);
				for (int n = 0; n < DUMMY_NODE_NUM; n++) {
					nodes.put(MURMUR_HASH.hash("hashing" + i + "-table-" + n), subTableName);
				}
			}
			resources.put(tableName, nodes);
		}
	}

	public static String getHashTableName(String tableName, String openId) {
		String hashTableName = null;
		TreeMap<Long, String> nodes = resources.get(tableName);
		SortedMap<Long, String> tail = nodes.tailMap(MURMUR_HASH.hash(openId));
		if (tail.isEmpty()) {
			hashTableName = nodes.get(nodes.firstKey());
		} else {
			hashTableName = tail.get(tail.firstKey());
		}
		return hashTableName;
	}

}
