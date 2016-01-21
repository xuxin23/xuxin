package xuxin.j2se.generic.demo2;

/**
 * 类型变量限定
 * @version 1.0
 * @author xuxin 
 * @data 2013-6-21
 */
public class ArrayTool {

    /**
     * 返回数组中最小的对象
     * -> 对象必须实现Comparable接口
     * -> 即泛型T必须是Comparable的接口实现类，对T的类型有限定！！
     */
    public static <T extends Comparable<T>> T min(T[] a) {
        if (a == null || a.length == 0) return null;
        T small = a[0];
        for (int i=1; i<a.length; i++) {
            if (small.compareTo(a[i]) > 0) small = a[i];
        }
        return small;
    }
}
