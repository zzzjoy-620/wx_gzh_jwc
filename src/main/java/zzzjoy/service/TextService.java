package zzzjoy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zzzjoy.bean.message.ToTextMessage;
import zzzjoy.constant.WxConstant;
import zzzjoy.service.jwc.HandleAccessTeacherService;
import zzzjoy.service.jwc.HandleBindUserService;
import zzzjoy.service.jwc.HandleQueryScoreService;
import zzzjoy.util.RegexUtils;

import java.util.Map;

@Service
public class TextService {
    @Autowired
    private TextMessageService textMessageService;
    @Autowired
    private HandleBindUserService handleBindUserService;
    @Autowired
    private HandleAccessTeacherService handleAccessTeacherService;
    @Autowired
    private HandleQueryScoreService handleQueryScoreService;

    /**
     * @Author zzzjoy
     * @Description 处理收到的文字map消息并返回xml消息
     * @Param fromMap 收到的map消息
     * @Return  回复的xml消息
    */
    public String handleService(Map<String, String> fromMap){
        String content = fromMap.get(WxConstant.CONTENT);
        String openId = fromMap.get(WxConstant.FROM_USER_NAME);
        String msg = null;

        // 用户只回复绑定
        if (RegexUtils.matchBIND(content) && RegexUtils.getUserList(content).size() != 1){
            msg = "欢迎使用CTGU教务处自助查询业务\n使用之前请先绑定教务处信息，回复格式为”绑定@学号@密码“，例如”绑定@2020123456@password“。\n"
                    +"\n绑定之后方可进行以下业务：\n"
                    +"\n1. 回复”成绩“可查询本学期成绩\n"
                    +"2. 回复“评教“可自动评教本学期课程\n"
                    +"\n注意：如您更改了教务处密码，请在此重新回复绑定信息以更新信息。";
            return textMessageService.sendMessage(new ToTextMessage(fromMap,msg));
        }

        // 用户查成绩
        else if (RegexUtils.matchQUERY_SCORE(content)){
            // 这里写查成绩的业务逻辑
            msg = handleQueryScoreService.handleQueryScore(openId);
            return textMessageService.sendMessage(new ToTextMessage(fromMap,msg));
        }

        // 用户评教
        else if (RegexUtils.matchACCESS_TEACHER(content)){
            // 这里写评教的业务逻辑
            msg = handleAccessTeacherService.handleAccessTeacher(openId);
            return textMessageService.sendMessage(new ToTextMessage(fromMap,msg));
        }

        //用户绑定信息
        else if (RegexUtils.getUserList(content).size() == 1){
            // 这里写绑定的业务逻辑
            msg = handleBindUserService.handleBindUser(content,openId);
            return textMessageService.sendMessage(new ToTextMessage(fromMap,msg));
        }
        else {
            return "";
        }
    }
}
