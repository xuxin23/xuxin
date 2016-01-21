package xuxin.j2se.design.Observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 政府也表示关注新闻
 * @author xuxin
 * @date 2013-8-6
 */
public class Government implements Observer{

	public void update(Observable o, Object arg) {
		String news = (String) arg;
		this.order(news);
	}

	public void order(String news) {
		System.out.println("官方：对于[" + news + "]这件事，我们表示强烈的谴责！希望有关部门能履行职责！");
	}
}
