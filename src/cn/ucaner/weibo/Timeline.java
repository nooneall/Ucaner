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
package cn.ucaner.weibo;

import java.util.List;
import java.util.Map;

import cn.ucaner.weibo.http.ImageItem;
import cn.ucaner.weibo.http.Response;
import cn.ucaner.weibo.model.Emotion;
import cn.ucaner.weibo.model.FriendsTimelineIds;
import cn.ucaner.weibo.model.MentionsIds;
import cn.ucaner.weibo.model.Paging;
import cn.ucaner.weibo.model.PostParameter;
import cn.ucaner.weibo.model.RepostTimelineIds;
import cn.ucaner.weibo.model.Status;
import cn.ucaner.weibo.model.StatusWapper;
import cn.ucaner.weibo.model.UserTimelineIds;
import cn.ucaner.weibo.model.WeiboException;
import cn.ucaner.weibo.org.json.JSONArray;
import cn.ucaner.weibo.org.json.JSONObject;
import cn.ucaner.weibo.util.ArrayUtils;
import cn.ucaner.weibo.util.WeiboConfig;

public class Timeline extends Weibo {

	private static final long serialVersionUID = 6235150828015082132L;

	public Timeline(String access_token) {
		this.access_token = access_token;
	}

	/*----------------------------璇诲彇鎺ュ彛----------------------------------------*/

	/**
	 * 杩斿洖鏈�鏂扮殑鍏叡寰崥
	 * 
	 * @return list of statuses of the Public Timeline
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see http://open.weibo.com/wiki/2/statuses/public_timeline
	 * @since JDK 1.5
	 */
	public StatusWapper getPublicTimeline() throws WeiboException {
		return Status.constructWapperStatus(client.get(
				WeiboConfig.getValue("baseURL")
						+ "statuses/public_timeline.json", access_token));
	}

	/**
	 * 杩斿洖鏈�鏂扮殑鍏叡寰崥
	 * 
	 * @param count
	 *            鍗曢〉杩斿洖鐨勮褰曟潯鏁帮紝榛樿涓�20銆�
	 * @param baseApp
	 *            鏄惁浠呰幏鍙栧綋鍓嶅簲鐢ㄥ彂甯冪殑淇℃伅銆�0涓烘墍鏈夛紝1涓轰粎鏈簲鐢ㄣ��
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see http://open.weibo.com/wiki/2/statuses/public_timeline
	 * @since JDK 1.5
	 */
	public StatusWapper getPublicTimeline(int count, int baseApp)
			throws WeiboException {
		return Status
				.constructWapperStatus(client.get(
						WeiboConfig.getValue("baseURL")
								+ "statuses/public_timeline.json",
						new PostParameter[] {
								new PostParameter("count", count),
								new PostParameter("base_app", baseApp) },
						access_token));
	}

	/**
	 * 鑾峰彇褰撳墠鐧诲綍鐢ㄦ埛鍙婂叾鎵�鍏虫敞鐢ㄦ埛鐨勬渶鏂�20鏉″井鍗氭秷鎭�� 鍜岀敤鎴风櫥褰� http://weibo.com 鍚庡湪鈥滄垜鐨勯椤碘�濅腑鐪嬪埌鐨勫唴瀹圭浉鍚屻�� This
	 * method calls http://api.t.sina.com.cn/statuses/friends_timeline.format
	 * 
	 * @return list of the Friends Timeline
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see http://open.weibo.com/wiki/2/statuses/friends_timeline
	 * @since JDK 1.5
	 */
	public StatusWapper getFriendsTimeline() throws WeiboException {
		return Status.constructWapperStatus(client.get(
				WeiboConfig.getValue("baseURL")
						+ "statuses/friends_timeline.json", access_token));

	}

	/**
	 * 鑾峰彇褰撳墠鐧诲綍鐢ㄦ埛鍙婂叾鎵�鍏虫敞鐢ㄦ埛鐨勬渶鏂板井鍗氭秷鎭��<br/>
	 * 鍜岀敤鎴风櫥褰� http://weibo.com 鍚庡湪鈥滄垜鐨勯椤碘�濅腑鐪嬪埌鐨勫唴瀹圭浉鍚屻��
	 * 
	 * @param paging
	 *            鐩稿叧鍒嗛〉鍙傛暟
	 * @param 杩囨护绫诲瀷ID
	 *            锛�0锛氬叏閮ㄣ��1锛氬師鍒涖��2锛氬浘鐗囥��3锛氳棰戙��4锛氶煶涔愶紝榛樿涓�0銆�
	 * @return list of the Friends Timeline
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see http://open.weibo.com/wiki/2/statuses/friends_timeline
	 * @since JDK 1.5
	 */
	public StatusWapper getFriendsTimeline(Integer baseAPP, Integer feature,
			Paging paging) throws WeiboException {
		return Status.constructWapperStatus(client.get(
				WeiboConfig.getValue("baseURL")
						+ "statuses/friends_timeline.json",
				new PostParameter[] {
						new PostParameter("base_app", baseAPP.toString()),
						new PostParameter("feature", feature.toString()) },
				paging, access_token));
	}

	/**
	 * 鑾峰彇褰撳墠鐧诲綍鐢ㄦ埛鍙婂叾鎵�鍏虫敞鐢ㄦ埛鐨勬渶鏂板井鍗�
	 * 
	 * @param map
	 *            鍙傛暟鍒楄〃
	 * @return
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/statuses/friends_timeline
	 * @since JDK 1.5
	 */
	public StatusWapper getFriendsTimeline(Map<String, String> map)
			throws WeiboException {
		PostParameter[] parList = ArrayUtils.mapToArray(map);
		return Status.constructWapperStatus(client.get(
				WeiboConfig.getValue("baseURL")
						+ "statuses/friends_timeline.json", parList, access_token));
	}

	/**
	 * 鸡哥写的方法，哈哈哈~~
	 */
	public Response getFriendTimeline(Map<String, String> map)
			throws WeiboException {
		PostParameter[] parList = ArrayUtils.mapToArray(map);
		return client.get(WeiboConfig.getValue("baseURL")+ "statuses/friends_timeline.json", parList, access_token);
	}
	/**
	 * 鑾峰彇褰撳墠鐧诲綍鐢ㄦ埛鍙婂叾鎵�鍏虫敞鐢ㄦ埛鐨勬渶鏂板井鍗氱殑ID銆� This method calls
	 * http://api.t.sina.com.cn/statuses/friends_timeline.format
	 * 
	 * @return list of the Friends Timeline
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see http://open.weibo.com/wiki/2/statuses/friends_timeline/ids
	 * @since JDK 1.5
	 */
	public FriendsTimelineIds getFriendsTimelineIds() throws WeiboException {
		return new FriendsTimelineIds(client.get(
				WeiboConfig.getValue("baseURL")
						+ "statuses/friends_timeline/ids.json", access_token));

	}

	public JSONObject getFriendsTimelineIds(Integer baseAPP, Integer feature,
			Paging paging) throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL")
						+ "statuses/friends_timeline/ids.json",
				new PostParameter[] {
						new PostParameter("base_app", baseAPP.toString()),
						new PostParameter("feature", feature.toString()) },
				paging, access_token).asJSONObject();
	}

	/**
	 * 鑾峰彇褰撳墠鐧诲綍鐢ㄦ埛鍙婂叾鎵�鍏虫敞鐢ㄦ埛鐨勬渶鏂板井鍗氱殑ID
	 * 
	 * @param map
	 *            鍙傛暟鍒楄〃
	 * @return
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/statuses/friends_timeline/ids
	 * @since JDK 1.5
	 */
	public JSONObject getFriendsTimelineIds(Map<String, String> map)
			throws WeiboException {
		PostParameter[] parList = ArrayUtils.mapToArray(map);
		return client.get(
				WeiboConfig.getValue("baseURL")
						+ "statuses/friends_timeline/ids.json", parList,
				access_token).asJSONObject();
	}

	/**
	 * 鑾峰彇褰撳墠鐧诲綍鐢ㄦ埛鍙婂叾鎵�鍏虫敞鐢ㄦ埛鐨勬渶鏂板井鍗氭秷鎭��<br/>
	 * 鍜岀敤鎴风櫥褰� http://weibo.com 鍚庡湪鈥滄垜鐨勯椤碘�濅腑鐪嬪埌鐨勫唴瀹圭浉鍚屻��
	 * 
	 * @return list of status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see http://open.weibo.com/wiki/2/statuses/home_timeline
	 * @since JDK 1.5
	 */
	public StatusWapper getHomeTimeline() throws WeiboException {
		return Status
				.constructWapperStatus(client.get(
						WeiboConfig.getValue("baseURL")
								+ "statuses/home_timeline.json", access_token));

	}

	/**
	 * 鑾峰彇褰撳墠鐧诲綍鐢ㄦ埛鍙婂叾鎵�鍏虫敞鐢ㄦ埛鐨勬渶鏂板井鍗氭秷鎭��<br/>
	 * 鍜岀敤鎴风櫥褰� http://weibo.com 鍚庡湪鈥滄垜鐨勯椤碘�濅腑鐪嬪埌鐨勫唴瀹圭浉鍚屻��
	 * 
	 * @param paging
	 *            鐩稿叧鍒嗛〉鍙傛暟
	 * @param 杩囨护绫诲瀷ID
	 *            锛�0锛氬叏閮ㄣ��1锛氬師鍒涖��2锛氬浘鐗囥��3锛氳棰戙��4锛氶煶涔愶紝榛樿涓�0銆�
	 * @return list of the Friends Timeline
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see http://open.weibo.com/wiki/2/statuses/home_timeline
	 * @since JDK 1.5
	 */
	public StatusWapper getHomeTimeline(Integer baseAPP, Integer feature,
			Paging paging) throws WeiboException {
		return Status
				.constructWapperStatus(client.get(
						WeiboConfig.getValue("baseURL")
								+ "statuses/home_timeline.json",
						new PostParameter[] {
								new PostParameter("base_app", baseAPP
										.toString()),
								new PostParameter("feature", feature.toString()) },
						paging, access_token));
	}

	/**
	 * 鑾峰彇褰撳墠鐧诲綍鐢ㄦ埛鍙婂叾鎵�鍏虫敞鐢ㄦ埛鐨勬渶鏂板井鍗�
	 * 
	 * @param map
	 *            鍙傛暟鍒楄〃
	 * @return
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/statuses/home_timeline
	 * @since JDK 1.5
	 */
	public StatusWapper getHomeTimeline(Map<String, String> map)
			throws WeiboException {
		PostParameter[] parList = ArrayUtils.mapToArray(map);
		return Status
				.constructWapperStatus(client.get(
						WeiboConfig.getValue("baseURL")
								+ "statuses/home_timeline.json", parList,
						access_token));
	}

	/**
	 * 鑾峰彇鏌愪釜鐢ㄦ埛鏈�鏂板彂琛ㄧ殑寰崥鍒楄〃
	 * 
	 * @return list of the user_timeline
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see http://open.weibo.com/wiki/2/statuses/user_timeline
	 * @since JDK 1.5
	 */
	public StatusWapper getUserTimeline() throws WeiboException {
		return Status
				.constructWapperStatus(client.get(
						WeiboConfig.getValue("baseURL")
								+ "statuses/user_timeline.json", access_token));
	}

	public StatusWapper getUserTimelineByUid(String uid) throws WeiboException {
		return Status
				.constructWapperStatus(client.get(
						WeiboConfig.getValue("baseURL")
								+ "statuses/user_timeline.json",
						new PostParameter[] { new PostParameter("uid", uid) },
						access_token));
	}

	public StatusWapper getUserTimelineByName(String screen_name)
			throws WeiboException {
		return Status
				.constructWapperStatus(client.get(
						WeiboConfig.getValue("baseURL")
								+ "statuses/user_timeline.json",
						new PostParameter[] { new PostParameter("screen_name",
								screen_name) }, access_token));
	}

	/**
	 * 鑾峰彇鏌愪釜鐢ㄦ埛鏈�鏂板彂琛ㄧ殑寰崥鍒楄〃
	 * 
	 * @param uid
	 *            闇�瑕佹煡璇㈢殑鐢ㄦ埛ID銆�
	 * @param screen_name
	 *            闇�瑕佹煡璇㈢殑鐢ㄦ埛鏄电О銆�
	 * @param count
	 *            鍗曢〉杩斿洖鐨勮褰曟潯鏁帮紝榛樿涓�50銆�
	 * @param page
	 *            杩斿洖缁撴灉鐨勯〉鐮侊紝榛樿涓�1銆�
	 * @param base_app
	 *            鏄惁鍙幏鍙栧綋鍓嶅簲鐢ㄧ殑鏁版嵁銆�0涓哄惁锛堟墍鏈夋暟鎹級锛�1涓烘槸锛堜粎褰撳墠搴旂敤锛夛紝榛樿涓�0銆�
	 * @param feature
	 *            杩囨护绫诲瀷ID锛�0锛氬叏閮ㄣ��1锛氬師鍒涖��2锛氬浘鐗囥��3锛氳棰戙��4锛氶煶涔愶紝榛樿涓�0銆�
	 * @return list of the user_timeline
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see http://open.weibo.com/wiki/2/statuses/user_timeline
	 * @since JDK 1.5
	 */
	public StatusWapper getUserTimelineByUid(String uid, Paging page,
			Integer base_app, Integer feature) throws WeiboException {
		return Status
				.constructWapperStatus(client.get(
						WeiboConfig.getValue("baseURL")
								+ "statuses/user_timeline.json",
						new PostParameter[] {
								new PostParameter("uid", uid),
								new PostParameter("base_app", base_app
										.toString()),
								new PostParameter("feature", feature.toString()) },
						page, access_token));
	}

	public StatusWapper getUserTimelineByName(String screen_name, Paging page,
			Integer base_app, Integer feature) throws WeiboException {
		return Status
				.constructWapperStatus(client.get(
						WeiboConfig.getValue("baseURL")
								+ "statuses/user_timeline.json",
						new PostParameter[] {
								new PostParameter("screen_name", screen_name),
								new PostParameter("base_app", base_app
										.toString()),
								new PostParameter("feature", feature.toString()) },
						page, access_token));
	}

	/**
	 * 鑾峰彇鏌愪釜鐢ㄦ埛鏈�鏂板彂琛ㄧ殑寰崥鍒楄〃
	 * 
	 * @param map
	 *            鍙傛暟鍒楄〃
	 * @return
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/statuses/user_timeline
	 * @since JDK 1.5
	 */
	public StatusWapper getUserTimeline(Map<String, String> map)
			throws WeiboException {
		PostParameter[] parList = ArrayUtils.mapToArray(map);
		return Status
				.constructWapperStatus(client.get(
						WeiboConfig.getValue("baseURL")
								+ "statuses/user_timeline.json", parList,
						access_token));
	}

	/**
	 * 鑾峰彇鏌愪釜鐢ㄦ埛鏈�鏂板彂琛ㄧ殑寰崥鍒楄〃ID
	 * 
	 * @return user_timeline IDS
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see http://open.weibo.com/wiki/2/statuses/user_timeline
	 * @since JDK 1.5
	 */
	public UserTimelineIds getUserTimelineIdsByUid(String uid)
			throws WeiboException {
		return new UserTimelineIds(client.get(WeiboConfig.getValue("baseURL")
				+ "statuses/user_timeline/ids.json",
				new PostParameter[] { new PostParameter("uid", uid) },
				access_token));
	}

	public JSONObject getUserTimelineIdsByName(String screen_name)
			throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL")
						+ "statuses/user_timeline/ids.json",
				new PostParameter[] { new PostParameter("screen_name",
						screen_name) }, access_token).asJSONObject();
	}

	/**
	 * 鑾峰彇鐢ㄦ埛鍙戝竷鐨勫井鍗氱殑ID
	 * 
	 * @param map
	 *            鍙傛暟鍒楄〃
	 * @return
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see http://open.weibo.com/wiki/2/statuses/user_timeline/ids
	 * @since JDK 1.5
	 */
	public JSONObject getUserTimelineIds(Map<String, String> map)
			throws WeiboException {
		PostParameter[] parList = ArrayUtils.mapToArray(map);
		return client.get(
				WeiboConfig.getValue("baseURL")
						+ "statuses/user_timeline/ids.json", parList,
				access_token).asJSONObject();
	}

	/**
	 * 鑾峰彇鎸囧畾寰崥鐨勮浆鍙戝井鍗氬垪琛�
	 * 
	 * @param id
	 *            闇�瑕佹煡璇㈢殑寰崥ID
	 * @return list of Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see http://open.weibo.com/wiki/2/statuses/repost_timeline
	 * @since JDK 1.5
	 */
	public StatusWapper getRepostTimeline(String id) throws WeiboException {
		return Status.constructWapperStatus(client.get(
				WeiboConfig.getValue("baseURL")
						+ "statuses/repost_timeline.json",
				new PostParameter[] { new PostParameter("id", id) },
				access_token));
	}

	/**
	 * 鑾峰彇鎸囧畾寰崥鐨勮浆鍙戝井鍗氬垪琛�
	 * 
	 * @param id
	 *            闇�瑕佹煡璇㈢殑寰崥ID
	 * @param count
	 *            鍗曢〉杩斿洖鐨勮褰曟潯鏁帮紝榛樿涓�50
	 * @param page
	 *            杩斿洖缁撴灉鐨勯〉鐮侊紝榛樿涓�1
	 * @return list of Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see http://open.weibo.com/wiki/2/statuses/repost_timeline
	 * @since JDK 1.5
	 */
	public StatusWapper getRepostTimeline(String id, Paging page)
			throws WeiboException {
		return Status.constructWapperStatus(client.get(
				WeiboConfig.getValue("baseURL")
						+ "statuses/repost_timeline.json",
				new PostParameter[] { new PostParameter("id", id) }, page,
				access_token));
	}

	/**
	 * 鑾峰彇鎸囧畾寰崥鐨勮浆鍙戝井鍗氬垪琛�
	 * 
	 * @param map
	 *            鍙傛暟鍒楄〃
	 * @return
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/statuses/repost_timeline
	 * @since JDK 1.5
	 */
	public StatusWapper getRepostTimeline(Map<String, String> map)
			throws WeiboException {
		PostParameter[] parList = ArrayUtils.mapToArray(map);
		return Status.constructWapperStatus(client.get(
				WeiboConfig.getValue("baseURL")
						+ "statuses/repost_timeline.json", parList, access_token));
	}

	/**
	 * 鑾峰彇涓�鏉″師鍒涘井鍗氱殑鏈�鏂拌浆鍙戝井鍗氱殑ID
	 * 
	 * @param id
	 *            闇�瑕佹煡璇㈢殑寰崥ID
	 * @return ids
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see http://open.weibo.com/wiki/2/statuses/repost_timeline/ids
	 * @since JDK 1.5
	 */
	public RepostTimelineIds getRepostTimelineIds(String id)
			throws WeiboException {
		return new RepostTimelineIds(client.get(WeiboConfig.getValue("baseURL")
				+ "statuses/repost_timeline/ids.json",
				new PostParameter[] { new PostParameter("id", id) },
				access_token));
	}

	/**
	 * 鑾峰彇涓�鏉″師鍒涘井鍗氱殑鏈�鏂拌浆鍙戝井鍗氱殑ID
	 * 
	 * @param map
	 *            鍙傛暟鍒楄〃
	 * @return
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/statuses/repost_timeline/ids
	 * @since JDK 1.5
	 */
	public RepostTimelineIds getRepostTimelineIds(Map<String, String> map)
			throws WeiboException {
		PostParameter[] parList = ArrayUtils.mapToArray(map);
		return new RepostTimelineIds(client.get(WeiboConfig.getValue("baseURL")
				+ "statuses/repost_timeline/ids.json", parList, access_token));
	}

	/**
	 * 鑾峰彇褰撳墠鐢ㄦ埛鏈�鏂拌浆鍙戠殑寰崥鍒楄〃
	 * 
	 * @return list of Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see http://open.weibo.com/wiki/2/statuses/repost_by_me
	 * @since JDK 1.5
	 */
	public StatusWapper getRepostByMe() throws WeiboException {
		return Status.constructWapperStatus(client.get(
				WeiboConfig.getValue("baseURL") + "statuses/repost_by_me.json",
				access_token));
	}

	/**
	 * 鑾峰彇褰撳墠鐢ㄦ埛鏈�鏂拌浆鍙戠殑寰崥鍒楄〃
	 * 
	 * @param page
	 *            杩斿洖缁撴灉鐨勯〉鐮侊紝榛樿涓�1
	 * @return list of Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see http://open.weibo.com/wiki/2/statuses/repost_by_me
	 * @since JDK 1.5
	 */
	public StatusWapper getRepostByMe(Paging page) throws WeiboException {
		return Status.constructWapperStatus(client.get(
				WeiboConfig.getValue("baseURL") + "statuses/repost_by_me.json",
				null, page, access_token));
	}

	/**
	 * 鑾峰彇鏈�鏂扮殑鎻愬埌鐧诲綍鐢ㄦ埛鐨勫井鍗氬垪琛紝鍗矦鎴戠殑寰崥
	 * 
	 * @return list of Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see http://open.weibo.com/wiki/2/statuses/mentions
	 * @since JDK 1.5
	 */
	public StatusWapper getMentions() throws WeiboException {
		return Status.constructWapperStatus(client.get(
				WeiboConfig.getValue("baseURL") + "statuses/mentions.json",
				access_token));
	}

	/**
	 * 鑾峰彇鏈�鏂扮殑鎻愬埌鐧诲綍鐢ㄦ埛鐨勫井鍗氬垪琛紝鍗矦鎴戠殑寰崥
	 * 
	 * @param count
	 *            鍗曢〉杩斿洖鐨勮褰曟潯鏁帮紝榛樿涓�50銆�
	 * @param page
	 *            杩斿洖缁撴灉鐨勯〉鐮侊紝榛樿涓�1銆�
	 * @param filter_by_author
	 *            浣滆�呯瓫閫夌被鍨嬶紝0锛氬叏閮ㄣ��1锛氭垜鍏虫敞鐨勪汉銆�2锛氶檶鐢熶汉锛岄粯璁や负0銆�
	 * @param filter_by_source
	 *            鏉ユ簮绛涢�夌被鍨嬶紝0锛氬叏閮ㄣ��1锛氭潵鑷井鍗氥��2锛氭潵鑷井缇わ紝榛樿涓�0銆�
	 * @param filter_by_type
	 *            鍘熷垱绛涢�夌被鍨嬶紝0锛氬叏閮ㄥ井鍗氥��1锛氬師鍒涚殑寰崥锛岄粯璁や负0銆�
	 * @return list of Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see http://open.weibo.com/wiki/2/statuses/mentions
	 * @since JDK 1.5
	 */
	public StatusWapper getMentions(Paging page, Integer filter_by_author,
			Integer filter_by_source, Integer filter_by_type)
			throws WeiboException {
		return Status.constructWapperStatus(client.get(
				WeiboConfig.getValue("baseURL") + "statuses/mentions.json",
				new PostParameter[] {
						new PostParameter("filter_by_author", filter_by_author
								.toString()),
						new PostParameter("filter_by_source", filter_by_source
								.toString()),
						new PostParameter("filter_by_type", filter_by_type
								.toString()) }, page, access_token));
	}

	/**
	 * 鑾峰彇鏈�鏂扮殑鎻愬埌鐧诲綍鐢ㄦ埛鐨勫井鍗氬垪琛紝鍗矦鎴戠殑寰崥
	 * 
	 * @param map
	 *            鍙傛暟鍒楄〃
	 * @return
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/statuses/mentions
	 * @since JDK 1.5
	 */
	public StatusWapper getMentions(Map<String, String> map)
			throws WeiboException {
		PostParameter[] parList = ArrayUtils.mapToArray(map);
		return Status.constructWapperStatus(client.get(
				WeiboConfig.getValue("baseURL") + "statuses/mentions.json", parList,
				access_token));
	}

	/**
	 * 鑾峰彇鏈�鏂扮殑鎻愬埌鐧诲綍鐢ㄦ埛鐨勫井鍗欼D鍒楄〃锛屽嵆@鎴戠殑寰崥
	 * 
	 * @return list of Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see http://open.weibo.com/wiki/2/statuses/mentions/ids
	 * @since JDK 1.5
	 */
	public MentionsIds getMentionsIds() throws WeiboException {
		return new MentionsIds(client.get(WeiboConfig.getValue("baseURL")
				+ "statuses/mentions/ids.json", access_token));
	}

	public JSONObject getMentionsIds(Paging page, Integer filter_by_author,
			Integer filter_by_source, Integer filter_by_type)
			throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL") + "statuses/mentions/ids.json",
				new PostParameter[] {
						new PostParameter("filter_by_author", filter_by_author
								.toString()),
						new PostParameter("filter_by_source", filter_by_source
								.toString()),
						new PostParameter("filter_by_type", filter_by_type
								.toString()) }, page, access_token)
				.asJSONObject();
	}

	/**
	 * 鑾峰彇鏈�鏂扮殑鎻愬埌鐧诲綍鐢ㄦ埛鐨勫井鍗欼D鍒楄〃锛屽嵆@鎴戠殑寰崥
	 * 
	 * @param map
	 *            鍙傛暟鍒楄〃
	 * @return
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/statuses/mentions/ids
	 * @since JDK 1.5
	 */
	public JSONObject getMentionsIds(Map<String, String> map)
			throws WeiboException {
		PostParameter[] parList = ArrayUtils.mapToArray(map);
		return client.get(
				WeiboConfig.getValue("baseURL") + "statuses/mentions/ids.json",
				parList, access_token).asJSONObject();
	}

	/**
	 * 鑾峰彇鍙屽悜鍏虫敞鐢ㄦ埛鐨勬渶鏂板井鍗�
	 * 
	 * @return list of Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see http://open.weibo.com/wiki/2/statuses/bilateral_timeline
	 * @since JDK 1.5
	 */
	public StatusWapper getBilateralTimeline() throws WeiboException {
		return Status.constructWapperStatus(client.get(
				WeiboConfig.getValue("baseURL")
						+ "statuses/bilateral_timeline.json", access_token));
	}

	public StatusWapper getBilateralTimeline(Integer base_app, Integer feature)
			throws WeiboException {
		return Status.constructWapperStatus(client.get(
				WeiboConfig.getValue("baseURL")
						+ "statuses/bilateral_timeline.json",
				new PostParameter[] { new PostParameter("base_app", base_app),
						new PostParameter("feature", feature) }, access_token));
	}

	/**
	 * 鑾峰彇鍙屽悜鍏虫敞鐢ㄦ埛鐨勬渶鏂板井鍗�
	 * 
	 * @param map
	 *            鍙傛暟鍒楄〃
	 * @return
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/statuses/bilateral_timeline
	 * @since JDK 1.5
	 */
	public StatusWapper getBilateralTimeline(Map<String, String> map)
			throws WeiboException {
		PostParameter[] parList = ArrayUtils.mapToArray(map);
		return Status
				.constructWapperStatus(client.get(
						WeiboConfig.getValue("baseURL")
								+ "statuses/bilateral_timeline.json", parList,
						access_token));
	}

	/**
	 * 鏍规嵁寰崥ID鑾峰彇鍗曟潯寰崥鍐呭
	 * 
	 * @param id
	 *            闇�瑕佽幏鍙栫殑寰崥ID銆�
	 * @return Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see http://open.weibo.com/wiki/2/statuses/show
	 * @since JDK 1.5
	 */
	public Status showStatus(String id) throws WeiboException {
		return new Status(client.get(WeiboConfig.getValue("baseURL")
				+ "statuses/show.json",
				new PostParameter[] { new PostParameter("id", id) },
				access_token));
	}

	/**
	 * 閫氳繃寰崥ID鑾峰彇鍏禡ID
	 * 
	 * @param id
	 *            闇�瑕佹煡璇㈢殑寰崥ID锛屾壒閲忔ā寮忎笅锛岀敤鍗婅閫楀彿鍒嗛殧锛屾渶澶氫笉瓒呰繃20涓��
	 * @param type
	 *            鑾峰彇绫诲瀷锛�1锛氬井鍗氥��2锛氳瘎璁恒��3锛氱淇★紝榛樿涓�1銆�
	 * @return Status's mid
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see http://open.weibo.com/wiki/2/statuses/querymid
	 * @since JDK 1.5
	 */
	public JSONObject queryMid(Integer type, String id) throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL") + "statuses/querymid.json",
				new PostParameter[] { new PostParameter("id", id),
						new PostParameter("type", type.toString()) },
				access_token).asJSONObject();
	}

	/**
	 * 閫氳繃寰崥ID鑾峰彇鍏禡ID
	 * 
	 * @param id
	 *            闇�瑕佹煡璇㈢殑寰崥ID锛屾壒閲忔ā寮忎笅锛岀敤鍗婅閫楀彿鍒嗛殧锛屾渶澶氫笉瓒呰繃20涓��
	 * @param type
	 *            鑾峰彇绫诲瀷锛�1锛氬井鍗氥��2锛氳瘎璁恒��3锛氱淇★紝榛樿涓�1銆�
	 * @param is_batch
	 *            鏄惁浣跨敤鎵归噺妯″紡锛�0锛氬惁銆�1锛氭槸锛岄粯璁や负0銆�
	 * @return Status's mid
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see http://open.weibo.com/wiki/2/statuses/querymid
	 * @since JDK 1.5
	 */
	public JSONObject queryMid(Integer type, String id, int is_batch)
			throws WeiboException {
		return client
				.get(WeiboConfig.getValue("baseURL") + "statuses/querymid.json",
						new PostParameter[] { new PostParameter("id", id),
								new PostParameter("type", type.toString()),
								new PostParameter("is_batch", is_batch) },
						access_token).asJSONObject();
	}

	/**
	 * 閫氳繃寰崥MID鑾峰彇鍏禝D
	 * 
	 * @param mid
	 *            true string 闇�瑕佹煡璇㈢殑寰崥MID锛屾壒閲忔ā寮忎笅锛岀敤鍗婅閫楀彿鍒嗛殧锛屾渶澶氫笉瓒呰繃20涓�
	 * @param type
	 *            鑾峰彇绫诲瀷锛�1锛氬井鍗氥��2锛氳瘎璁恒��3锛氱淇★紝榛樿涓�1銆�
	 * @return Status's id
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see http://open.weibo.com/wiki/2/statuses/queryid
	 * @since JDK 1.5
	 */
	public JSONObject queryId(String mid, Integer type, int isBase62)
			throws WeiboException {
		return client
				.get(WeiboConfig.getValue("baseURL") + "statuses/queryid.json",
						new PostParameter[] { new PostParameter("mid", mid),
								new PostParameter("type", type.toString()),
								new PostParameter("isBase62", isBase62) },
						access_token).asJSONObject();
	}

	/**
	 * 閫氳繃寰崥MID鑾峰彇鍏禝D
	 * 
	 * @param mid
	 *            true string 闇�瑕佹煡璇㈢殑寰崥MID锛屾壒閲忔ā寮忎笅锛岀敤鍗婅閫楀彿鍒嗛殧锛屾渶澶氫笉瓒呰繃20涓�
	 * @param type
	 *            鑾峰彇绫诲瀷锛�1锛氬井鍗氥��2锛氳瘎璁恒��3锛氱淇★紝榛樿涓�1銆�
	 * @param is_batch
	 *            鏄惁浣跨敤鎵归噺妯″紡锛�0锛氬惁銆�1锛氭槸锛岄粯璁や负0銆�
	 * @param inbox
	 *            浠呭绉佷俊鏈夋晥锛屽綋MID绫诲瀷涓虹淇℃椂鐢ㄦ鍙傛暟锛�0锛氬彂浠剁銆�1锛氭敹浠剁锛岄粯璁や负0 銆�
	 * @param isBase62
	 *            MID鏄惁鏄痓ase62缂栫爜锛�0锛氬惁銆�1锛氭槸锛岄粯璁や负0銆�
	 * @return Status's id
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see http://open.weibo.com/wiki/2/statuses/queryid
	 * @since JDK 1.5
	 */
	public JSONObject queryId(String mid, Integer type, Integer isBatch,
			Integer isBase62) throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL") + "statuses/queryid.json",
				new PostParameter[] { new PostParameter("mid", mid),
						new PostParameter("type", type.toString()),
						new PostParameter("is_batch", isBatch.toString()),
						new PostParameter("isBase62", isBase62.toString()) },
				access_token).asJSONObject();
	}

	/**
	 * 閫氳繃寰崥MID鑾峰彇鍏禝D
	 * 
	 * @param map
	 *            鍙傛暟鍒楄〃
	 * @return
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/statuses/queryid
	 * @since JDK 1.5
	 */
	public JSONObject queryId(Map<String, String> map) throws WeiboException {
		PostParameter[] parList = ArrayUtils.mapToArray(map);
		return client.get(
				WeiboConfig.getValue("baseURL") + "statuses/queryid.json",
				parList, access_token).asJSONObject();
	}

	/**
	 * 杞彂涓�鏉℃柊寰崥
	 * 
	 * @param id
	 *            瑕佽浆鍙戠殑寰崥ID
	 * @return Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see http://open.weibo.com/wiki/2/statuses/repost
	 * @since JDK 1.5
	 */
	public Status repost(String id) throws WeiboException {
		return new Status(client.post(WeiboConfig.getValue("baseURL")
				+ "statuses/repost.json",
				new PostParameter[] { new PostParameter("id", id) },
				access_token));
	}

	/**
	 * 杞彂涓�鏉″井鍗�
	 * 
	 * @param id
	 *            瑕佽浆鍙戠殑寰崥ID
	 * @param status
	 *            娣诲姞鐨勮浆鍙戞枃鏈紝蹇呴』鍋歎RLencode锛屽唴瀹逛笉瓒呰繃140涓眽瀛楋紝涓嶅～鍒欓粯璁や负鈥滆浆鍙戝井鍗氣��
	 * @param is_comment
	 *            鏄惁鍦ㄨ浆鍙戠殑鍚屾椂鍙戣〃璇勮锛�0锛氬惁銆�1锛氳瘎璁虹粰褰撳墠寰崥銆�2锛氳瘎璁虹粰鍘熷井鍗氥��3锛氶兘璇勮锛岄粯璁や负0
	 * @return Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see http://open.weibo.com/wiki/2/statuses/repost
	 * @since JDK 1.5
	 */
	public Status repost(String id, String status, Integer is_comment)
			throws WeiboException {
		return new Status(client.post(WeiboConfig.getValue("baseURL")
				+ "statuses/repost.json", new PostParameter[] {
				new PostParameter("id", id),
				new PostParameter("status", status),
				new PostParameter("is_comment", is_comment.toString()) },
				access_token));
	}

	/**
	 * 杞彂涓�鏉″井鍗�
	 * 
	 * @param map
	 *            鍙傛暟鍒楄〃
	 * @return
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/statuses/repost
	 * @since JDK 1.5
	 */
	public Status repost(Map<String, String> map) throws WeiboException {
		PostParameter[] parList = ArrayUtils.mapToArray(map);
		return new Status(client.post(WeiboConfig.getValue("baseURL")
				+ "statuses/repost.json", parList, access_token));
	}

	/**
	 * 鏍规嵁寰崥ID鍒犻櫎鎸囧畾寰崥
	 * 
	 * @param id
	 *            闇�瑕佸垹闄ょ殑寰崥ID
	 * @return Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see http://open.weibo.com/wiki/2/statuses/destroy
	 * @since JDK 1.5
	 */
	public Status destroy(String id) throws WeiboException {
		return new Status(client.post(WeiboConfig.getValue("baseURL")
				+ "statuses/destroy.json",
				new PostParameter[] { new PostParameter("id", id) },
				access_token));
	}

	/**
	 * 鍙戝竷涓�鏉℃柊寰崥
	 * 
	 * @param status
	 *            瑕佸彂甯冪殑寰崥鏂囨湰鍐呭锛屽繀椤诲仛URLencode锛屽唴瀹逛笉瓒呰繃140涓眽瀛�
	 * @return Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see http://open.weibo.com/wiki/2/statuses/update
	 * @since JDK 1.5
	 */
	public Status updateStatus(String status) throws WeiboException {
		return new Status(client.post(WeiboConfig.getValue("baseURL")
				+ "statuses/update.json",
				new PostParameter[] { new PostParameter("status", status) },
				access_token));
	}

	/**
	 * 鍙戝竷涓�鏉℃柊寰崥
	 * 
	 * @param status
	 *            瑕佸彂甯冪殑寰崥鏂囨湰鍐呭锛屽繀椤诲仛URLencode锛屽唴瀹逛笉瓒呰繃140涓眽瀛�
	 * @param lat
	 *            绾害锛屾湁鏁堣寖鍥达細-90.0鍒�+90.0锛�+琛ㄧず鍖楃含锛岄粯璁や负0.0銆�
	 * @param long 缁忓害锛屾湁鏁堣寖鍥达細-180.0鍒�+180.0锛�+琛ㄧず涓滅粡锛岄粯璁や负0.0銆�
	 * @param annotations
	 *            鍏冩暟鎹紝涓昏鏄负浜嗘柟渚跨涓夋柟搴旂敤璁板綍涓�浜涢�傚悎浜庤嚜宸变娇鐢ㄧ殑淇℃伅锛屾瘡鏉″井鍗氬彲浠ュ寘鍚竴涓垨鑰呭涓厓鏁版嵁锛�
	 *            蹇呴』浠son瀛椾覆鐨勫舰寮忔彁浜わ紝瀛椾覆闀垮害涓嶈秴杩�512涓瓧绗︼紝鍏蜂綋鍐呭鍙互鑷畾
	 * @return Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see http://open.weibo.com/wiki/2/statuses/update
	 * @since JDK 1.5
	 */
	public Status updateStatus(String status, Float lat, Float longs,
			String annotations) throws WeiboException {
		return new Status(client.post(WeiboConfig.getValue("baseURL")
				+ "statuses/update.json", new PostParameter[] {
				new PostParameter("status", status),
				new PostParameter("lat", lat.toString()),
				new PostParameter("long", longs.toString()),
				new PostParameter("annotations", annotations) }, access_token));
	}

	/**
	 * 鍙戝竷涓�鏉℃柊寰崥
	 * 
	 * @param map
	 *            鍙傛暟鍒楄〃
	 * @return
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/statuses/update
	 * @since JDK 1.5
	 */
	public Status updateStatus(Map<String, String> map) throws WeiboException {
		PostParameter[] parList = ArrayUtils.mapToArray(map);
		return new Status(client.post(WeiboConfig.getValue("baseURL")
				+ "statuses/update.json", parList, access_token));
	}

	/**
	 * 涓婁紶鍥剧墖骞跺彂甯冧竴鏉℃柊寰崥
	 * 
	 * @param status
	 *            瑕佸彂甯冪殑寰崥鏂囨湰鍐呭锛屽繀椤诲仛URLencode锛屽唴瀹逛笉瓒呰繃140涓眽瀛�
	 * @param pic
	 *            瑕佷笂浼犵殑鍥剧墖锛屼粎鏀寔JPEG銆丟IF銆丳NG鏍煎紡锛屽浘鐗囧ぇ灏忓皬浜�5M銆�
	 * @return Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see http://open.weibo.com/wiki/2/statuses/upload
	 * @since JDK 1.5
	 */
	public Status uploadStatus(String status, ImageItem item)
			throws WeiboException {
		return new Status(client.multPartURL(WeiboConfig.getValue("baseURL")
				+ "statuses/upload.json",
				new PostParameter[] { new PostParameter("status", status) },
				item, access_token));
	}

	/**
	 * 涓婁紶鍥剧墖骞跺彂甯冧竴鏉℃柊寰崥
	 * 
	 * @param status
	 *            瑕佸彂甯冪殑寰崥鏂囨湰鍐呭锛屽繀椤诲仛URLencode锛屽唴瀹逛笉瓒呰繃140涓眽瀛�
	 * @param pic
	 *            瑕佷笂浼犵殑鍥剧墖锛屼粎鏀寔JPEG銆丟IF銆丳NG鏍煎紡锛屽浘鐗囧ぇ灏忓皬浜�5M銆�
	 * @param lat
	 *            绾害锛屾湁鏁堣寖鍥达細-90.0鍒�+90.0锛�+琛ㄧず鍖楃含锛岄粯璁や负0.0銆�
	 * @param long 缁忓害锛屾湁鏁堣寖鍥达細-180.0鍒�+180.0锛�+琛ㄧず涓滅粡锛岄粯璁や负0.0銆�
	 * @return Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see http://open.weibo.com/wiki/2/statuses/upload
	 * @since JDK 1.5
	 */
	public Status uploadStatus(String status, ImageItem item, Float lat,
			Float longs) throws WeiboException {
		return new Status(client.multPartURL(WeiboConfig.getValue("baseURL")
				+ "statuses/upload.json", new PostParameter[] {
				new PostParameter("status", status),
				new PostParameter("lat", lat.toString()),
				new PostParameter("long", longs.toString()) }, item,
				access_token));
	}

	/**
	 * 涓婁紶鍥剧墖骞跺彂甯冧竴鏉℃柊寰崥
	 * 
	 * @param map
	 * @param item
	 * @return
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/statuses/upload
	 * @since JDK 1.5
	 */
	public Status uploadStatus(Map<String, String> map, ImageItem item)
			throws WeiboException {
		PostParameter[] parList = ArrayUtils.mapToArray(map);
		return new Status(client.multPartURL(WeiboConfig.getValue("baseURL")
				+ "statuses/upload.json", parList, item, access_token));
	}

	/**
	 * 鑾峰彇寰崥瀹樻柟琛ㄦ儏鐨勮缁嗕俊鎭�
	 * 
	 * @return Emotion
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see http://open.weibo.com/wiki/2/emotions
	 * @since JDK 1.5
	 */
	public List<Emotion> getEmotions() throws WeiboException {
		return Emotion
				.constructEmotions(client.get(WeiboConfig.getValue("baseURL")
						+ "emotions.json", access_token));
	}

	/**
	 * 鑾峰彇寰崥瀹樻柟琛ㄦ儏鐨勮缁嗕俊鎭�
	 * 
	 * @param type
	 *            琛ㄦ儏绫诲埆锛宖ace锛氭櫘閫氳〃鎯呫�乤ni锛氶瓟娉曡〃鎯呫�乧artoon锛氬姩婕〃鎯咃紝榛樿涓篺ace
	 * @param language
	 *            璇█绫诲埆锛宑nname锛氱畝浣撱�乼wname锛氱箒浣擄紝榛樿涓篶nname
	 * @return Emotion
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see http://open.weibo.com/wiki/2/emotions
	 * @since JDK 1.5
	 */
	public List<Emotion> getEmotions(String type, String language)
			throws WeiboException {
		return Emotion
				.constructEmotions(client.get(WeiboConfig.getValue("baseURL")
						+ "emotions.json", new PostParameter[] {
						new PostParameter("type", type),
						new PostParameter("language", language) }, access_token));
	}

	/**
	 * 鎵归噺鑾峰彇鎸囧畾寰崥鐨勮浆鍙戞暟璇勮鏁�
	 * 
	 * @param ids
	 *            闇�瑕佽幏鍙栨暟鎹殑寰崥ID锛屽涓箣闂寸敤閫楀彿鍒嗛殧锛屾渶澶氫笉瓒呰繃100涓�
	 * @return
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see http://open.weibo.com/wiki/2/emotions
	 * @since JDK 1.5
	 */
	public JSONArray getStatusesCount(String ids) throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL") + "statuses/count.json",
				new PostParameter[] { new PostParameter("ids", ids) },
				access_token).asJSONArray();
	}

}
