package xuxin.j2se.base;

/**
 * 测试String.format()
 * @version 1.0
 * @author xuxin 
 * @data 2013-2-1
 */
public class StringDemo_format {

    public static void main(String[] args) {
        int status = 202;
        Results results = new Results();
        
        // %d:结果被格式化为十进制整数（第一个参数）
        // %s:如果arg为null,返回null;如果arg实现了Formattable,则调用arg.formatTo(),否则调用
        // arg.toString()得到结果
        System.out.println(
                String.format("{\"status\":%d,\"response\":%s}", status,results)
        );
    }
}

class Results {
    public String toString() {
        return "{{id=1,name='xu'},{id=2,name='li'}}";
    }
}