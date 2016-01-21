/**
 * 
 */
package xuxin.j2se.base;

import java.util.UUID;

import org.junit.Test;

/**
 * 用于测试UUID
 * @version 1.0
 * @author xuxin 
 * @data 2013-2-19
 */
public class UUIDDemo {

    @Test
    public void test01() {
        for (int i=0; i<4; i++) {
            // 获取类型4(伪随机生成的) UUID 的静态工厂
            UUID uuid = UUID.randomUUID();
            // 返回表示此 UUID 的String 对象
            System.out.println("uuid.toString - " + uuid.toString());
            System.out.println("uuid.variant - " + uuid.variant());
            System.out.println("uuid.version - " + uuid.version());
//            System.out.println("uuid.timestamp - " + uuid.timestamp());
//            System.out.println("uuid.node - " + uuid.node());
//            System.out.println("uuid.clockSequence - " + uuid.clockSequence());
            System.out.println("uuid.getLeastSignificantBits - " + uuid.getLeastSignificantBits());
            System.out.println("uuid.getMostSignificantBits - " + uuid.getMostSignificantBits());
            System.out.println("uuid.hashCode - " + uuid.hashCode());
            System.out.println("-------------------------------------");
        }
    }
    
}
