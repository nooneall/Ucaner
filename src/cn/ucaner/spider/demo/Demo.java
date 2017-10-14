package cn.ucaner.spider.demo;

import cn.ucaner.spider.utils.MyCrawler;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.url.WebURL;

public class Demo {
	
	public static void main(String[] args) {
		WebURL webURL = new WebURL();
		webURL.setURL("http://sk.ucaner.cn");
		Page page = new Page(webURL);
		MyCrawler myCrawler = new MyCrawler();
		myCrawler.visit(page);
	}
}
