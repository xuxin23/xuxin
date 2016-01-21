/**
 * 
 */
package xuxin.j2se.generic.demo3;

/**
 * @version 1.0
 * @author xuxin 
 * @data 2013-6-24
 */
public class Employee {

    private String name;
    private int price;
    
    public Employee() {}
    public Employee(String name, int price) {
        this.name = name;
        this.price = price;
    }
    
    public String toString() {
        return "{name=" + name + ", price=" + price + "}";
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    
    
    
}
