package xuxin.j2se.design.Observer;

import java.util.Observable;

/**
 * 新闻 （嗯，很多人关注）
 * @author xuxin
 * @date 2013-8-6
 */
public class News extends Observable{

	// 发布新闻
	public void publicNews(String news) {
		super.setChanged();
		super.notifyObservers(news);
	}
}
