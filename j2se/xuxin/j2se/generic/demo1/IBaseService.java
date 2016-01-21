/**
 * 
 */
package xuxin.j2se.generic.demo1;

import java.util.ArrayList;

/**
 * 泛型接口 - Service层的接口模版
 * @version 1.0
 * @author xuxin 
 * @data 2013-6-21
 */
public interface IBaseService <T>{

    public ArrayList<T> findAll();
    public T findOne(T t);
    public int doUpdate(T t);
    public int doCreate(T t);
    public int doDelete(T t);
}
