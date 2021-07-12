package zzzjoy.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zzzjoy.bean.User;
import zzzjoy.dao.UserMapper;
import zzzjoy.service.AccessTokenService;
import zzzjoy.service.UserService;
import zzzjoy.util.HttpClientUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AccessTokenService accessTokenService;

    public User getUserByURL(String openId) throws IOException {
        // get数据准备
        HashMap<String, String> map = new HashMap<>();
        map.put("access_token", accessTokenService.getAccessToken());
        map.put("openid", openId);
        map.put("lang", "zh_CN");
        String userBaseInfo_URL = "https://api.weixin.qq.com/cgi-bin/user/info";
        String respond = HttpClientUtils.get(userBaseInfo_URL, map);
        JSONObject jsonObject = JSONObject.parseObject(respond);

        // 封装对象
        User user = new User();
        user.setSubscribe(jsonObject.getString("subscribe"));
        user.setOpenid(jsonObject.getString("openid"));
        user.setNickname(jsonObject.getString("nickname"));
        user.setSex(jsonObject.getInteger("sex"));
        user.setLanguage(jsonObject.getString("language"));
        user.setCity(jsonObject.getString("city"));
        user.setProvince(jsonObject.getString("province"));
        user.setCountry(jsonObject.getString("country"));
        user.setHeadimgurl(jsonObject.getString("headimgurl"));
        user.setSubscribe_time(jsonObject.getLong("subscribe_time"));
        user.setRemark(jsonObject.getString("remark"));
        user.setGroupid(jsonObject.getInteger("groupid"));
        user.setTagid_list(jsonObject.getString("tagid_list"));
        user.setSubscribe_scene(jsonObject.getString("subscribe_scene"));
        return user;
    }



    // 两种方式添加用户
    public int addUser(String openId) throws IOException {
        if (this.findUserByOpenId(openId).size() != 0)
            return 0;
        return addUser(getUserByURL(openId));
    }

    @Override
    public int addUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public List<User> findUserByOpenId(String openId) {
        return userMapper.selectUserByOpenId(openId);
    }
}
