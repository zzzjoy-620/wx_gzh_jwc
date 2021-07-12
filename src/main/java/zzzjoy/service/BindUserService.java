package zzzjoy.service;

import zzzjoy.bean.JwcUser;

import java.util.List;

public interface BindUserService {
    Integer addJwcUser(JwcUser jwcUser);
    List<JwcUser> findJwcUserByOpenId(String openId);
    Integer updateJwcUser(JwcUser jwcUser);
}
