package xuxin.j2se.base;

/**
 * 面试题
 */
import org.junit.Test;

public class Base {

	// 【 最有效率计算2 * 8 等于多少? 】
	// 因为将一个数左移n位，就相当于乘以了2的n次方
	@Test
	public void test01() {
		System.out.println(2 << 3);
	}
	
	// 【 跳出多重循环 】
	@Test
	public void test02() {
		action:
			for(int i=0; i<20; i++) {
				System.out.println("i:\t" + i);
				for (int j=0; j<20; j++) {
					System.out.println("j:\t" + j);
					if (i == 15 && j == 15) {
						break action;
					}
				}
			}
	}
	
	// 【 &&与&的区别 】
	// 共同点：都是与运算
	// 不同点：&& 当第1个表达式为false则不会计算后面其他的表达式
	//			& 当&两边表达式不是boolean类型时，表示位与操作，通常用0x0f与一个整数进行
	//			  &运算，来获取该整数的最低4个bit位
	@Test
	public void test03() {
		String str = null;
		
		// &&:第1个表达式为false，不会执行第2个表达式
		if (str != null && !str.equals("")) {
			
		}
		
		// &:会计算所有的表达式，而第2个表达式会报NullPointerException
		if (str != null & !str.equals("")) {
			
		}
	}
	
	// 【类型转换】
	@Test
	public void test04() {
		short s1 = 1;
		// 编译不通过，提示强制转型;s1 + 1,s1会自动提升为int与1相加，再强制转换为short赋值给s1
//		s1 = s1 + 1;
		
		short s2 = 1;
		// +=是java的一种特殊运算符,会作特殊处理..尼玛..
		s2 += 1;
	}
	
	// 【char int byte】
	@Test
	public void test05() {
		String str = "hello,上海";
		
		byte[] b = str.getBytes();
		for (byte e:b) {
			System.out.print(e + " ");
		}
		System.out.println();
		
		char[] c = str.toCharArray();
		for (char e:c) {
			System.out.print(e + "[" + (int)e + "] ");
		}
	}
	
	// 额，有点意思
	@Test
	public void test06() {
		System.out.println(finallyTest());
	}
	
	private int finallyTest() {
		int i = 1;
		try {
			System.out.println("try:" + i);
			return i;
		}
		finally {
			++i;
			System.out.println("finally:" + i);
			System.out.println("执行finally..");
		}
	}
}
