package zzzjoy.controller;


import zzzjoy.util.AccessAuthentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wxabc")
public class CheckSignatureController {


    private String token = "weixin";
    @GetMapping
    public String getSignature(@RequestParam("signature") String signature,
                               @RequestParam("timestamp") String timestamp,
                               @RequestParam("nonce") String nonce,
                               @RequestParam("echostr") String echostr){
        if (AccessAuthentication.checkSignature(token,timestamp,nonce,signature)) {
            return echostr;
        }
        return null;
    }

    @GetMapping("1")
    public String s(){
        return "ssss";
    }

}
