package zzzjoy.bean.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import zzzjoy.constant.WxConstant;
import zzzjoy.util.XmlUtils;

import java.util.Map;


@XStreamAlias("xml")
public class ToTextMessage extends BaseMessage{

    @XStreamAlias("Content")
    public String content;

    public ToTextMessage(Map<String, String> fromMap, String content){
        super(fromMap.get(WxConstant.FROM_USER_NAME),fromMap.get(WxConstant.TO_USER_NAME),String.valueOf(System.currentTimeMillis()/1000),"text");
        this.content = content;
    }


    public String toXml(){
        return XmlUtils.beanToXml(this, this.getClass());
    }

    @Override
    public String toString() {
        return "ToTextMessage{" +
                "content='" + content + '\'' +
                ", toUserName='" + toUserName + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", msgType='" + msgType + '\'' +
                '}';
    }
}
