package zzzjoy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zzzjoy.bean.JwcUser;
import zzzjoy.config.JwcConfig;
import zzzjoy.dao.BindUserMapper;
import zzzjoy.service.BindUserService;
import zzzjoy.util.AesEncodeUtils;
import zzzjoy.util.AesUtils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class BindUserServiceImpl implements BindUserService {

    @Autowired
    private BindUserMapper bindUserMapper;
    @Autowired
    private JwcConfig jwcConfig;


    @Override
    public Integer addJwcUser(JwcUser jwcUser) {
        String basePassword = jwcUser.getPassword();
        String encryptPassword = AesUtils.encrypt(basePassword, jwcConfig.getAeskey());
        jwcUser.setPassword(encryptPassword);
        return bindUserMapper.insertJwcUser(jwcUser);
    }


    @Override
    public List<JwcUser> findJwcUserByOpenId(String openId) {
        List<JwcUser> jwcUserList = bindUserMapper.selectJwcUserByOpenId(openId);
        for (JwcUser jwcUser : jwcUserList) {
            String basePassword = jwcUser.getPassword();
            String decryptPassword = AesUtils.decrypt(basePassword, jwcConfig.getAeskey());
            jwcUser.setPassword(decryptPassword);
        }
        return jwcUserList;
    }


    @Override
    public Integer updateJwcUser(JwcUser jwcUser) {
        String basePassword = jwcUser.getPassword();
        String encryptPassword = AesUtils.encrypt(basePassword, jwcConfig.getAeskey());
        jwcUser.setPassword(encryptPassword);
        return bindUserMapper.updateJwcUser(jwcUser);
    }


    // 查询是否存在这个openId
    public boolean existOpenId(String openId){
        List<JwcUser> jwcUserList = this.findJwcUserByOpenId(openId);
        return jwcUserList.size() > 0;
    }

    // 查询是否存在这个用户
    public boolean existJwcUser(JwcUser jwcUser){
        List<JwcUser> jwcUserList = this.findJwcUserByOpenId(jwcUser.getOpenId());
        return (jwcUserList.size() == 1 && jwcUserList.get(0).getUsername().equals(jwcUser.getUsername()));
    }

    // 查询这个用户的创建时间是不是三天内的
    public boolean freezeJwcUser(JwcUser jwcUser){
        List<JwcUser> jwcUserList = this.findJwcUserByOpenId(jwcUser.getOpenId());
        Long creatTime = jwcUserList.get(0).getCreatTime().getTime();
        Long curTime = System.currentTimeMillis();
        // 冻结时间为三天
        return ((curTime-creatTime)/1000/60/60/24 < 3);
    }
}
