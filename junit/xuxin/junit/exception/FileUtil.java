package xuxin.junit.exception;

/**
 * 文件处理工具
 * @author xuxin
 * @version 1.0 xuxin 2013-8-14 create
 */
public class FileUtil {

	public static void readFile(String filePath) throws Exception{
		
		if ("exception".equals(filePath)) {
			throw new Exception("错误");
		} else {
			System.out.println("-----------------------");
		}
	}
}
