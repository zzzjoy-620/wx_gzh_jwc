package zzzjoy.controller;



import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.scheduling.annotation.EnableAsync;
import zzzjoy.bean.User;
import zzzjoy.bean.message.ToTextMessage;
import zzzjoy.constant.WxConstant;
import zzzjoy.service.DuplicateMessageService;
import zzzjoy.service.TextMessageService;
import zzzjoy.service.TextService;
import zzzjoy.service.impl.TextMessageServiceImpl;
import zzzjoy.service.impl.UserServiceImpl;
import zzzjoy.util.XmlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@EnableAsync
@RestController
@RequestMapping("/wxabc")
public class MainController {

    @Autowired
    private TextMessageServiceImpl textMessageService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private DuplicateMessageService duplicateMessage;
    @Autowired
    private TextService textService;

    @PostMapping
    public String getMessage(@RequestBody String message) throws Exception {
        Map<String, String> fromMap = XmlUtils.xmlStrToMap(message);
        assert fromMap != null;
        System.out.println("接受消息:"+fromMap);

        // 判断消息是否为重复的消息
        if (duplicateMessage.checkDuplicateMsg(fromMap)){
            return textMessageService.sendMessage(new ToTextMessage(fromMap,"消息处理中，请稍后再试。"));
        }
        // 判断消息是否为恶意发消息的用户
        else if (duplicateMessage.checkDuplicateUser(fromMap)){
            return textMessageService.sendMessage(new ToTextMessage(fromMap,"您的请求过快，请歇会再试。"));
        }

        // 文字消息处理
        else if (Objects.equals(fromMap.get(WxConstant.MSG_TYPE), "text")){
            /*
             * 这里写业务逻辑
             */
//            Thread.sleep(11000);

            return textService.handleService(fromMap);
            }
//        else if (fromMap.get(WxConstant.MSG_TYPE).equals("event") && fromMap.get(WxConstant.EVENT).equals("subscribe")){
//            userService.addUser(fromMap.get(WxConstant.FROM_USER_NAME));
//            return "";
////            return textMessageService.sendMessage(new ToTextMessage(fromMap,"欢迎关注！"));
//        }
        else
            return "";

    }
}
