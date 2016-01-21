package xuxin.junit.fixture.test;

import org.junit.BeforeClass;
import org.junit.Test;

import xuxin.junit.fixture.BeforeDemo;

public class BeforeDemoTest2 {

	private static int a;
	
	@BeforeClass
	public static void init() {
		System.out.println("------初始化-------");
		a = 24;
	}
	
	@Test
	public void testA() {
		System.out.println(BeforeDemo.quart(a));
	}
	
	@Test
	public void testB() {
		System.out.println(BeforeDemo.quart(a));
	}
}
