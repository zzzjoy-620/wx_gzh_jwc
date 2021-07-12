package zzzjoy.service.impl;

import zzzjoy.bean.message.ToTextMessage;
import org.springframework.stereotype.Service;
import zzzjoy.service.TextMessageService;


@Service
public class TextMessageServiceImpl implements TextMessageService {
    public String sendMessage(ToTextMessage toTextMessage){
         System.out.println("发送消息:"+toTextMessage);
        return toTextMessage.toXml();
    }
}
