package zzzjoy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.ls.LSOutput;
import zzzjoy.config.JwcConfig;
import zzzjoy.config.WxBaseConfig;
import zzzjoy.util.AccessAuthentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zzzjoy.util.JsonUtil;

@RestController
@RequestMapping("/wxabc")
public class CheckSignatureController {

    @Autowired
    private WxBaseConfig wxBaseConfig;


    @GetMapping
    public String getSignature(@RequestParam("signature") String signature,
                               @RequestParam("timestamp") String timestamp,
                               @RequestParam("nonce") String nonce,
                               @RequestParam("echostr") String echostr){
        String token = wxBaseConfig.getToken();
        if (AccessAuthentication.checkSignature(token,timestamp,nonce,signature)) {
            return echostr;
        }
        return null;
    }


}
