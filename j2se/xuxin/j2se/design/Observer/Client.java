package xuxin.j2se.design.Observer;

import org.junit.Test;

/**
 * 观察者模式场景类
 * @author xuxin
 * @date 2013-8-6
 */
public class Client {

	@Test
	public void test() {
		News news = new News();
		news.addObserver(new Government());
		news.addObserver(new People("小明"));
		news.addObserver(new People("小红"));
		news.addObserver(new People("小刚"));
		
		news.publicNews("天一和他的4个小伙伴");
	}
	
}
