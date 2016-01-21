package xuxin.junit.parameterized.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import xuxin.junit.parameterized.ProUtil;

/**
 * 使用参数运行器，与pro.junit.base.ProUtilTest比较一下
 * @author xuxin
 * @version 1.0 xuxin 2013-8-14 create
 */
@RunWith(Parameterized.class)
public class ProUtilTest {
	
	private String expected;
	private String target;
	
	@Parameters
	public static Collection params() {
		return Arrays.asList(new Object[][] {
				{"user_info", "userInfo"},
				{null, null},
				{"", ""},
				{"user_info", "UserInfo"},
				{"user_info_a", "userInfoA"},
				{"user_a_info", "userAInfo"}
		});
	}
	
	public ProUtilTest(String expected, String target) {
		this.expected = expected;
		this.target = target;
	}
	
	@Test
	public void ClassToTable() {
		assertEquals(expected, ProUtil.ClassToTable(target));
	}
	
}
