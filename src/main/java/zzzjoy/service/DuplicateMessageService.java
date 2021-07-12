package zzzjoy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import zzzjoy.bean.DuplicateMessage;
import zzzjoy.config.WxBaseConfig;
import zzzjoy.constant.WxConstant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class DuplicateMessageService {
    public static final List<DuplicateMessage> MSGS = new ArrayList<>();
    public static final List<String> USERS = new ArrayList<>();


    @Autowired
    private WxBaseConfig wxBaseConfig;

    public boolean checkDuplicateMsg(Map<String, String> fromMap){
        String fromUserName = fromMap.get(WxConstant.FROM_USER_NAME);
        String createTime = fromMap.get(WxConstant.CREATE_TIME);
        DuplicateMessage duplicateMessage = new DuplicateMessage(fromUserName,createTime);

        if (MSGS.contains(duplicateMessage)){
            return true;
        }
        else {
            MSGS.add(duplicateMessage);
            return false;
        }
    }

    public boolean checkDuplicateUser(Map<String, String> fromMap){
        String user = fromMap.get(WxConstant.FROM_USER_NAME);
        int count = Collections.frequency(USERS, user);
        if (count > wxBaseConfig.getLimitTimes()){
            return true;
        }
        else {
            USERS.add(user);
            return false;
        }
    }


    @Scheduled(fixedRate = 180000)
    public void clearUSERS(){
        USERS.clear();
    }


    @Scheduled(fixedRate = 300000)
    public void clearMSGS(){
        DuplicateMessage duplicateMessage = null;
        for (int i = 0; i < MSGS.size(); i++) {
            duplicateMessage = MSGS.get(i);
            if (((System.currentTimeMillis()-duplicateMessage.getCurTime())/1000)>30){
                MSGS.remove(duplicateMessage);
            }
        }
    }
}
