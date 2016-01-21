/**
 * 
 */
package xuxin.j2se.generic.demo2;

import org.junit.Test;

import xuxin.j2se.domain.Book;

/**
 * 场景
 * @version 1.0
 * @author xuxin 
 * @data 2013-6-21
 */
public class Client {

    @Test
    public void test() {
        Book[] books = {new Book("Core Java",80),
                        new Book("Thinking In Java",100),
                        new Book("Effctive Java",50)
        };
        
        System.out.println(ArrayTool.min(books));
    }
}
