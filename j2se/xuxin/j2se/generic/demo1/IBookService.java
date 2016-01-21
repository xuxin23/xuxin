/**
 * 
 */
package xuxin.j2se.generic.demo1;

import java.util.ArrayList;

import xuxin.j2se.domain.Book;

/**
 * 书籍服务接口
 * @version 1.0
 * @author xuxin 
 * @data 2013-6-21
 */
public interface IBookService extends IBaseService<Book> {

    // 获取热书榜
    public ArrayList<Book> findHotBooks();
}
