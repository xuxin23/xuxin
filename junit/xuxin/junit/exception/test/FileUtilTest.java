package xuxin.junit.exception.test;

import org.junit.Ignore;
import org.junit.Test;

import xuxin.junit.exception.FileUtil;

public class FileUtilTest {

	// 测试正常情况
	@Test
	public void readFile() {
		try {
			FileUtil.readFile("d:\\批次检查2.sql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 测试异常情况
	@Ignore("not success")
	@Test(expected=java.lang.Exception.class)
	public void readFileException() {
		try {
			FileUtil.readFile("exception");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
