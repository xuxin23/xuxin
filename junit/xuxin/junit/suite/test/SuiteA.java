package xuxin.junit.suite.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 测试套件
 * @author xuxin
 * @version 1.0 xuxin 2013-8-14 create
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({xuxin.junit.base.test.ProUtilTest.class,xuxin.junit.exception.test.FileUtilTest.class})
public class SuiteA {

}
