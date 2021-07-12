package zzzjoy.service;

import zzzjoy.bean.message.ToTextMessage;

public interface TextMessageService {
    String sendMessage(ToTextMessage toTextMessage);
}
