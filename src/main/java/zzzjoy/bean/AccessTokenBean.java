package zzzjoy.bean;


import java.io.Serializable;


public class AccessTokenBean implements Serializable {
    private String accessToken;
    // 过期时间 ，非获取到的expires_in
    private Long expiresTime;

    public AccessTokenBean(String accessToken, Long expiresIn) {
        this.accessToken = accessToken;
        this.expiresTime = System.currentTimeMillis() + expiresIn * 1000;
    }


    public String getAccessToken() {
        return accessToken;
    }

    // 判断是否过期
    public boolean expired(){
        return System.currentTimeMillis() > this.expiresTime;
    }
}
