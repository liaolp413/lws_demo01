package cn.com.java.lws.service;

import cn.com.java.lws.model.User;
import java.util.Map;

/**
 * 
 * @author djin
 *   用户业务层接口
 */
public interface UserService extends BaseService<User> {

    //初始化好友信息
    Map<String,Object> initFriend(User user) throws Exception;

}
