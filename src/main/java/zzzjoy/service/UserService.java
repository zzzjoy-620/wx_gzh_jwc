package zzzjoy.service;

import zzzjoy.bean.User;

import java.util.List;

public interface UserService {
    int addUser(User user);
    List<User> findUserByOpenId(String openId);
}
