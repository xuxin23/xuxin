/**
 * 
 */
package xuxin.j2se.domain;

/**
 * @version 1.0
 * @author xuxin 
 * @data 2013-6-21
 */
public class Book implements Comparable<Book>{

    private String name;
    private int price;
    
    public Book(String name, int price) {
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
    
    public int compareTo(Book book) {
        return this.getPrice() - book.getPrice();
    }
    
    
}
