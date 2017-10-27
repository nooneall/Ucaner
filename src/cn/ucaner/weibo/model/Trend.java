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

import cn.ucaner.weibo.org.json.JSONException;
import cn.ucaner.weibo.org.json.JSONObject;


/**
 * A data class representing Treand.
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @since Weibo4J 1.2.1
 */
public class Trend implements java.io.Serializable{
    private String name;
    private String query = null;
    private long amount;
    private long delta;
    private static final long serialVersionUID = 1925956704460743946L;

    public Trend(JSONObject json) throws JSONException {
        this.name = json.getString("name");
        if (!json.isNull("query")) {
            this.query = json.getString("query");
        }
        this.amount =json.getLong("amount");
        this.delta = json.getLong("delta");
    }

    public String getName() {
        return name;
    }


    public String getQuery() {
        return query;
    }

    public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public long getDelta() {
		return delta;
	}

	public void setDelta(long delta) {
		this.delta = delta;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trend)) return false;

        Trend trend = (Trend) o;

        if (!name.equals(trend.name)) return false;
        if (query != null ? !query.equals(trend.query) : trend.query != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (query != null ? query.hashCode() : 0);
        return result;
    }

	@Override
	public String toString() {
		return "Trend [name=" + name + ", query=" + query + ", amount="
				+ amount + ", delta=" + delta + "]";
	}
    
}
