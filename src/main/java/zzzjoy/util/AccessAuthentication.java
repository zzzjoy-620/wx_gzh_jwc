package zzzjoy.util;



import org.apache.commons.codec.digest.DigestUtils;


import java.util.Arrays;


public class AccessAuthentication {

    /**
     * @Author zzzjoy
     * @Description 将token、timestamp、nonce三个参数进行字典序排序后进行sha1加密，与signature对比
     * @Param token	微信公众号的token
     * @Param timestamp	nonce signature get中携带的参数
     * @Return 是否是微信的请求
    */
    public static boolean checkSignature(String token, String timestamp, String nonce, String signature){
        // 1、将token、timestamp、nonce三个参数进行字典序排序
        String[] strs = new String[]{token, timestamp, nonce};
        Arrays.sort(strs);
        // 将三个参数字符串拼接成一个字符串进行sha1加密
        String str = strs[0] + strs[1] + strs[2];
        // sha1加密
        String sha1Hex = DigestUtils.sha1Hex(str);
        // 比较签名值是否一致
        return sha1Hex.equals(signature);
    }
    
}
