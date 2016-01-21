package xuxin.j2se.generic.demo1;

import xuxin.j2se.domain.User;

/**
 * 用户服务接口
 * @version 1.0
 * @author xuxin 
 * @data 2013-6-21
 */
public interface IUserService extends IBaseService<User>{

    // 登录检查
    public boolean checkLogin(User user);
}
