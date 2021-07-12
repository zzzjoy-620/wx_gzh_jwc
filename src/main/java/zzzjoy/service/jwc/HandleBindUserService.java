package zzzjoy.service.jwc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zzzjoy.bean.JwcUser;
import zzzjoy.service.impl.BindUserServiceImpl;
import zzzjoy.util.RegexUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class HandleBindUserService {

    @Autowired
    private BindUserServiceImpl bindUserService;

    public String handleBindUser(String content, String openId){
        String username = RegexUtils.getUserList(content).get(0).get(0);
        String password = RegexUtils.getUserList(content).get(0).get(1);
        String returnMsg = null;

        Date now = new Date( );
        String ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now);
        Timestamp timestamp = Timestamp.valueOf(ft);//把时间转换

        JwcUser jwcUser = new JwcUser(openId, username, password, timestamp);

        // 数据库不存在相同openId
        if (!bindUserService.existOpenId(jwcUser.getOpenId())){
            if (bindUserService.addJwcUser(jwcUser) == 1){
                returnMsg = "绑定用户成功!";
            }
            else {
                returnMsg = "操作失败:01，请联系开发者。";
            }
        }
        else {
            // 数据库存在相同openId和username
            if (bindUserService.existJwcUser(jwcUser)){
                if (bindUserService.updateJwcUser(jwcUser) == 1){
                    returnMsg = "更新密码成功!";
                }
            }
            // 数据库存在相同openId但username不同
            else {
                if (bindUserService.freezeJwcUser(jwcUser)){
                    returnMsg = "换绑失败，请三天后再试。";
                }
                else {
                    if (bindUserService.updateJwcUser(jwcUser) == 1){
                        returnMsg = "换绑成功!";
                    }
                    else {
                        returnMsg = "操作失败:02，请联系开发者。";
                    }
                }

            }
        }
        return returnMsg;
    }

}
