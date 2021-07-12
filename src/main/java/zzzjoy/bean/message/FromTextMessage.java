package zzzjoy.bean.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import zzzjoy.constant.WxConstant;

import java.util.Map;

public class FromTextMessage extends BaseMessage {

    @XStreamAlias("Content")
    public String content;

    @XStreamAlias("MsgId")
    public String msgId;

    public FromTextMessage(Map<String, String> map) {
        super(map);
        this.content = map.get(WxConstant.CONTENT);
        this.msgId = map.get(WxConstant.MSG_ID);
    }


}
