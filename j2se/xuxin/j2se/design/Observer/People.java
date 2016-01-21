package xuxin.j2se.design.Observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 老百姓关注新闻
 * @author xuxin
 * @date 2013-8-6
 */
public class People implements Observer{

	private String name;
	
	public People(String name) {
		this.name = name;
	}
	
	public void update(Observable o, Object arg) {
		String news = (String) arg;
		this.speak(news);
	}
	
	// 看到新闻后的反应
	public void speak(String news) {
		System.out.println("网友 '" + this.name + "'说：看到[" + news + "]这个新闻，我和我的小伙伴都惊呆了！！");
	}

}
