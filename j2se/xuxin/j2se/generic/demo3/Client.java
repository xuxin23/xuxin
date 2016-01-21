/**
 * 
 */
package xuxin.j2se.generic.demo3;

import org.junit.Test;

/**
 * 通配符的使用
 * 主要用来解决固定类型泛型的子类型、超类型不足
 * @version 1.0
 * @author xuxin 
 * @data 2013-6-24
 */
public class Client {

    @Test
    public void test() {
        Pair<Employee> em = new Pair<Employee>(new Employee("小明",3000),new Employee("小红",2800));
        Pair<Manager> ma = new Pair<Manager>(new Manager("老王",6000),new Manager("老李",7000));
        
        printInfo(em);
        
        // 下面的语句编译错误,Pair<Manager>不能作为参数传入printInfo(Pair<Employee>)中。
        // [理解泛型的子类型和超类型关系]
//        printInfo(ma);
        
        printInfo2(em);
        
        printInfo2(ma);
        
        Manager[] m = {
                new Manager("老徐",12000),
                new Manager("老孙",11000),
                new Manager("老张",10000),
                new Manager("老余",13000),
                new Manager("老金",8000)
        };
        Pair<Manager> p = new Pair<Manager>();
        minMaxPrice(m, p);
    }
    
    /**
     * 打印雇员信息
     */
    public static void printInfo(Pair<Employee> p) {
        System.out.println(p.getFirst().getName() + " - " + p.getSecond().getName());
    }
    
    /**
     * 打印雇员信息[使用子类限定通配符]
     */
    public static void printInfo2(Pair<? extends Employee> p) {
        System.out.println(p.getFirst().getName() + " - " + p.getSecond().getName());
    }
    
    /**
     * 获取最高工资最低工资组合[使用超类限定通配符]
     */
    public static void minMaxPrice(Manager[] ms, Pair<? super Manager> p) {
        Manager small = ms[0];
        Manager max = ms[0];
        for (int i=1; i<ms.length; i++) {
            if (small.getPrice() > ms[i].getPrice()) {
                small = ms[i];
            }
            if (max.getPrice() < ms[i].getPrice()) {
                max = ms[i];
            }
        }
        p.setFirst(small);
        p.setSecond(max);
        System.out.println(small + " || " + max);
    }
}
