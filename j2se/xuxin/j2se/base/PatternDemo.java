package xuxin.j2se.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * 正则表达式
 * @author xuxin
 *
 */
public class PatternDemo {
	
	@Test
	public void test1() {
		String str = "Hello Java , and java is popular..";
		//将制定的正则表达式编译到模式中,用于多次比较
		//如果一次比较的话，可以直接调用Pattern.matches(String regx,String in)
		Pattern pattern = Pattern.compile("[jJ]ava");
		Matcher matcher = pattern.matcher(str);
		
		System.out.println("完全匹配结果：" + matcher.matches());
		System.out.println("前段匹配结果：" + matcher.lookingAt());
		int i = 1;
		while (matcher.find()) {
			System.out.println("第" + i + "个匹配的" + matcher.group() +
					"的开始位置是：" + matcher.start() + ",结束位置是：" + 
					matcher.end());
			i++;
		}
		
	}
	
	/**
	 * 测试appendReplacement和appendTail方法，主要用于find()循环。
	 */
	@Test
	public void test2() {
		String str = "a cat two cat in the house";
		Pattern p = Pattern.compile("cat");
		Matcher matcher = p.matcher(str);
		StringBuffer sb = new StringBuffer();
		
		while (matcher.find()) {
			matcher.appendReplacement(sb, "dog");
		}
		// 复制剩余的输入序列
		matcher.appendTail(sb);
		
		System.out.println(sb.toString());
	}
}
