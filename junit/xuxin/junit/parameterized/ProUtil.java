package xuxin.junit.parameterized;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProUtil {

	// 将类名转换为表名格式，如UserInfo -> user_info
	public static String ClassToTable(String className) {
		Pattern pattern = Pattern.compile("[A-Z]");
		if (className != null) {
			Matcher matcher = pattern.matcher(className);
			StringBuffer sb = new StringBuffer();
			
			while (matcher.find()) {
				if (matcher.start() != 0) {
					matcher.appendReplacement(sb, "_" + matcher.group());
				}
			}
			
			return matcher.appendTail(sb).toString().toLowerCase();
		} else {
			return null;
		}
	}
	
}
