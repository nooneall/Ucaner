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
package cn.ucaner.weibo.model;

import java.util.ArrayList;
import java.util.List;

import cn.ucaner.weibo.http.Response;
import cn.ucaner.weibo.org.json.JSONArray;
import cn.ucaner.weibo.org.json.JSONException;
import cn.ucaner.weibo.org.json.JSONObject;

public class RateLimitStatus extends WeiboResponse {

	private static final long serialVersionUID = -3153374766679996576L;

	private int ipLimit;
	private int remainingIpHits;
	private long remainingUserHits;
	private String resetTime;
	private int resetTimeInSeconds;
	private long userLimit;
	private List<ApiRateLimits> apiRateLimit;

	public RateLimitStatus(Response res) throws WeiboException {
		super(res);
		JSONObject json = res.asJSONObject();
		try {
			JSONArray list = json.getJSONArray("api_rate_limits");
			int size = list.length();
			apiRateLimit = new ArrayList<ApiRateLimits>(size);
			for (int i = 0; i < size; i++) {
				apiRateLimit.add(new ApiRateLimits(list.getJSONObject(i)));
			}
			ipLimit = json.getInt("ip_limit");
			remainingIpHits = json.getInt("remaining_ip_hits");
			remainingUserHits = json.getLong("remaining_user_hits");
			resetTime = json.getString("reset_time");
			resetTimeInSeconds = json.getInt("reset_time_in_seconds");
			userLimit = json.getLong("user_limit");
		} catch (JSONException jsone) {
			throw new WeiboException(
					jsone.getMessage() + ":" + json.toString(), jsone);
		}
	}

	public int getIpLimit() {
		return ipLimit;
	}

	public void setIpLimit(int ipLimit) {
		this.ipLimit = ipLimit;
	}

	public int getRemainingIpHits() {
		return remainingIpHits;
	}

	public void setRemainingIpHits(int remainingIpHits) {
		this.remainingIpHits = remainingIpHits;
	}

	public long getRemainingUserHits() {
		return remainingUserHits;
	}

	public void setRemainingUserHits(long remainingUserHits) {
		this.remainingUserHits = remainingUserHits;
	}

	public String getResetTime() {
		return resetTime;
	}

	public void setResetTime(String resetTime) {
		this.resetTime = resetTime;
	}

	public int getResetTimeInSeconds() {
		return resetTimeInSeconds;
	}

	public void setResetTimeInSeconds(int resetTimeInSeconds) {
		this.resetTimeInSeconds = resetTimeInSeconds;
	}

	public long getUserLimit() {
		return userLimit;
	}

	public void setUserLimit(long userLimit) {
		this.userLimit = userLimit;
	}

	public List<ApiRateLimits> getApiRateLimit() {
		return apiRateLimit;
	}

	public void setApiRateLimit(List<ApiRateLimits> apiRateLimit) {
		this.apiRateLimit = apiRateLimit;
	}

	@Override
	public String toString() {
		return "RateLimitStatus [ipLimit=" + ipLimit + ", remainingIpHits="
				+ remainingIpHits + ", remainingUserHits=" + remainingUserHits
				+ ", resetTime=" + resetTime + ", resetTimeInSeconds="
				+ resetTimeInSeconds + ", userLimit=" + userLimit
				+ ", apiRateLimit=" + apiRateLimit + "]";
	}

}
