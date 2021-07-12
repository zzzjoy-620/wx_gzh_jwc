package zzzjoy.bean.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import zzzjoy.constant.WxConstant;

import java.util.Map;

public class FromEventMessage extends BaseMessage{


    @XStreamAlias("Event")
    public String event;


    public FromEventMessage(Map<String, String> map) {
        super(map);
        this.event = map.get(WxConstant.EVENT);
    }
}
