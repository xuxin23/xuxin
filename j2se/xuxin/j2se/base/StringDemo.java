package xuxin.j2se.base;

import java.util.Arrays;

public class StringDemo {
	
	public static void main(String[] args) {
		
	    String s = "hello.java.to.to";
	    String[] s22 = s.split("\\.");
	    System.out.println(Arrays.toString(s22));
	    s22[0] = "hello2";
	    String newStr = "";
	    for (String str:s22) {
	        newStr += str + ".";
	    }
	    System.out.println(newStr);
	    
		//===============字符串与数值、数组的转换=====================
		String stringNum = "123456";
		String stringDemo = "1,3,4,5,2";
		//字符串-数值
		int intNum = Integer.parseInt(stringNum); 
		intNum = Integer.valueOf(stringNum);
		//数值-字符串
		String stringNum2 = String.valueOf(intNum);
		//字符串-数组
		char[] charNum = stringNum.toCharArray();
		//数组-字符串valueOf()/copyValueOf()
		String s1 = String.valueOf(charNum);//字符数组整个转为字符串
		String s2 = String.copyValueOf(charNum,1,4);//选择特定的起始转为字符串
		System.out.println("s1:"+ s1);
		System.out.println("s2:" + s2);
		
		//=================字符串的查找拼接=============================
		String stringDemo2 = "hello";
		//charAt()
		System.out.println("charAt():" + stringDemo2.charAt(1));
		//indexOf()/lastIndexOf()
		System.out.println("indexOf():" + stringDemo2.indexOf('o'));
		System.out.println("lastIndexOf():" + stringDemo2.lastIndexOf('o'));
		//compareTo()
		System.out.println("compareTo():" + stringDemo2.compareTo("hezlo"));
		//concat
		System.out.println("concat():" + stringDemo2.concat("java"));
		//contains
		System.out.println("contains():" + stringDemo2.contains("ll"));
		//endsWith
		System.out.println("endsWith():" + stringDemo2.endsWith("llo"));
		//replace
		System.out.println("replace():" + stringDemo2.replace("he", "He"));
		//subString
		System.out.println("subString:" + stringDemo2.substring(1,4));
	}
}
