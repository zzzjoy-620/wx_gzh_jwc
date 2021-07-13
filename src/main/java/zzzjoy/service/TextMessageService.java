package zzzjoy.service;

import org.springframework.stereotype.Service;
import zzzjoy.bean.message.ToTextMessage;

@Service
public class TextMessageService {

    /**
     * @Author zzzjoy
     * @Description 将toTextMessage对象转换为xml字符串
     * @Param toTextMessage	发送的toTextMessage对象
     * @Return 转换的xml字符串
    */
    public String sendMessage(ToTextMessage toTextMessage){
        System.out.println("发送消息:"+toTextMessage);
        return toTextMessage.toXml();
    }
}
