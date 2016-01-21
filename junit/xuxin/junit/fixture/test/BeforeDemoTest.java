package xuxin.junit.fixture.test;

import org.junit.Before;
import org.junit.Test;

import xuxin.junit.fixture.BeforeDemo;

public class BeforeDemoTest {

	private static int a;
	
	// 方法级别的Fixture
	@Before
	public void init() {
		System.out.println("-----初始化------");
		a = 25;
	}
	
	@Test
	public void quartA() {
		a = BeforeDemo.quart(a);
		System.out.println("A:" + a);
	}
	
	@Test
	public void quartB() {
		a = BeforeDemo.quart(a);
		System.out.println("B:" + a);
	}
}
