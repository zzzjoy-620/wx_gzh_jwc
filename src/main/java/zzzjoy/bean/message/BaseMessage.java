package zzzjoy.bean.message;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import zzzjoy.constant.WxConstant;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class BaseMessage implements Serializable {

    // 开发者微信号
    @XStreamAlias("ToUserName")
    public String toUserName;

    // 发送方帐号（一个OpenID）
    @XStreamAlias("FromUserName")
    public String fromUserName;

    //消息创建时间 （整型）
    @XStreamAlias("CreateTime")
    public String createTime;

    // 消息类型，文本为text
    @XStreamAlias("MsgType")
    public String msgType;

    public BaseMessage(String toUserName, String fromUserName, String createTime, String msgType) {
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.msgType = msgType;
    }

    public BaseMessage(Map<String, String> map) {
        this.toUserName = map.get((WxConstant.TO_USER_NAME));
        this.fromUserName = map.get((WxConstant.FROM_USER_NAME));
        this.createTime = map.get((WxConstant.CREATE_TIME));
        this.msgType = map.get((WxConstant.MSG_TYPE));
    }
}
