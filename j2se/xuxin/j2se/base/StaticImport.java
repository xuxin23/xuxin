/**
 * 
 */
package xuxin.j2se.base;

import org.junit.Test;
import static java.lang.Math.*;

/**
 * 静态导入
 * @version 1.0
 * @author xuxin 
 * @data 2013-6-26
 */
public class StaticImport {

    @Test
    public void test() {
        System.out.println(sqrt(random() * 1000 + sqrt(1314)));
    }
}
