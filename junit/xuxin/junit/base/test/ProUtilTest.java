package xuxin.junit.base.test;

import static org.junit.Assert.*;

import org.junit.Test;

import xuxin.junit.base.ProUtil;

public class ProUtilTest {
	
	@Test
	public void ClassToTable() {
		String target = "userInfo";
		String result = ProUtil.ClassToTable(target);
		
		assertEquals("user_info", result);
	}
	
	// 测试null
	@Test
	public void ClassToTableNull() {
		String target = null;
		String result = ProUtil.ClassToTable(target);
		
		assertNull(result);
	}
	
	// 测试空字符串
	@Test
	public void ClassToTableEmpty() {
		String target = "";
		String result = ProUtil.ClassToTable(target);
		
		assertEquals("", result);
	}
	
	// 测试首字母大写
	@Test
	public void ClassToTableBegin() {
		String target = "UserInfo";
		String result = ProUtil.ClassToTable(target);
		
		assertEquals("user_info", result);
	}
	
	// 测试尾字母大写
	@Test
	public void ClassToTableEnd() {
		String target = "userInfoA";
		String result = ProUtil.ClassToTable(target);
		
		assertEquals("user_info_a", result);
	}
	
	// 测试多个相连字母大写
	@Test
	public void ClassToTableTogether() {
		String target = "userAInfo";
		String result = ProUtil.ClassToTable(target);
		
		assertEquals("user_a_info", result);
	}
}
