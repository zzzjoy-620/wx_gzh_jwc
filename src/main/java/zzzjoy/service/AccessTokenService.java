package zzzjoy.service;

import zzzjoy.bean.AccessTokenBean;
import zzzjoy.config.WxBaseConfig;
import zzzjoy.util.HttpClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.HashMap;

@Service
public class AccessTokenService {
    @Autowired
    private WxBaseConfig wxBaseConfig;

    private AccessTokenBean accessTokenBean;

    /**
     * @Author zzzjoy
     * @Description 刷新accessToken
     * @Param appId	微信的appid
     * @Param appSecret	微信的secret
     * @Return
    */
    private void refreshAccessToken(String appId, String appSecret) throws IOException {
        // get数据准备
        HashMap<String, String> map = new HashMap<>();
        map.put("appid", appId);
        map.put("secret", appSecret);
        map.put("grant_type", "client_credential");
        String accessToken_URL = "https://api.weixin.qq.com/cgi-bin/token";

        // 获取返回值并处理
        String respond = HttpClientUtils.get(accessToken_URL, map);
        JSONObject jsonObject = JSONObject.parseObject(respond);
        String accessToken = jsonObject.getString("access_token");
        Long expiresIn = jsonObject.getLong("expires_in");

        this.accessTokenBean = new AccessTokenBean(accessToken, expiresIn);
    }

    /**
     * @Author zzzjoy
     * @Description 获取accessToken
     * @Param
     * @Return accessToken
    */
    public String getAccessToken() throws IOException {
        // 不存在就刷新
        if (this.accessTokenBean == null || this.accessTokenBean.expired()){
            this.refreshAccessToken(wxBaseConfig.getAppId(), wxBaseConfig.getSecret());
        }
        // 存在就直接返回
        return this.accessTokenBean.getAccessToken();
    }


}
