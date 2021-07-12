package zzzjoy.service;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import zzzjoy.bean.message.ToTextMessage;

import java.util.Map;
import java.util.concurrent.Future;

//return textMessageService.sendMessage(new ToTextMessage(fromMap,"你好！"));
//AsyncMessageService.returnTimeoutMessage(fromMap)

@Async
@Service
public class AsyncMessageService {

    private ToTextMessage toTextMessage;

    public void returnTimeoutMessage(Map<String, String> fromMap){




    }
}
