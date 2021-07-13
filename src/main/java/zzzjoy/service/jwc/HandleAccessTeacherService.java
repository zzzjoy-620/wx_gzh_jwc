package zzzjoy.service.jwc;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;
import zzzjoy.bean.JwcUser;
import zzzjoy.bean.ReceiveData;
import zzzjoy.config.JwcConfig;
import zzzjoy.service.impl.BindUserServiceImpl;
import zzzjoy.service.impl.ReceiveDataServiceImpl;
import zzzjoy.util.HttpClientUtils;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class HandleAccessTeacherService {

    @Autowired
    private BindUserServiceImpl bindUserService;
    @Autowired
    private ReceiveDataServiceImpl receiveDataService;
    @Autowired
    private JwcConfig jwcConfig;

    /**
     * @Author zzzjoy
     * @Description 处理评教信息
     * @Param openId 用户的openId
     * @Return  要发送给微信消息的content
    */
    public String handleAccessTeacher(String openId){
        String returnMsg = null;
        String jwcService = jwcConfig.getJwcService();
        if (bindUserService.existOpenId(openId)) {
            List<JwcUser> jwcUserList = bindUserService.findJwcUserByOpenId(openId);
            if (jwcUserList.size() == 1) {
                // get数据准备
                HashMap<String, String> map = new HashMap<>();
                map.put("username", jwcUserList.get(0).getUsername());
                map.put("password", jwcUserList.get(0).getPassword());
                map.put("type", "access_teacher");
                System.out.println("查询信息："+map);

                // 获取返回值并处理
                try {
                    String respond = HttpClientUtils.get(jwcService,map);
                    JSONObject jsonObject = JSONObject.parseObject(respond);
                    String code = jsonObject.getString("code");
                    String msg = jsonObject.getString("msg");
                    String service = jsonObject.getString("service");
                    String service_ip = jsonObject.getString("service_ip");
                    String data = jsonObject.getString("data");

                    //把时间转换
                    Date now = new Date( );
                    String ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now);
                    Timestamp timestamp = Timestamp.valueOf(ft);
                    ReceiveData receiveData = new ReceiveData(code, msg, service, service_ip, data, timestamp);

                    if (code == null){
                        returnMsg = "评教失败:02，请联系开发者。";
                    }
                    else if (code.equals("200")){
                        returnMsg = data;
                        // 存入数据
                        receiveDataService.addReceiveData(receiveData);
                    }
                    else if (code.equals("404")){
                        returnMsg = "评教失败，教务处访问失败。";
                    }
                    else if (code.equals("403")){
                        returnMsg = "评教失败，验证码自动识别失败或是密码错误，请重试。";
                    }
                    else {
                        returnMsg = "评教失败:05，请联系开发者。";
                    }

                } catch (IOException e) {
                    returnMsg = "评教失败:03，请联系开发者。";
                }
            }
            else {
                returnMsg = "评教失败:04，请联系开发者。";
            }

        }
        // 不存在openID
        else {
            returnMsg = "您未绑定，请回复”绑定“以绑定教务处信息。";
        }
        return returnMsg;
    }

}
