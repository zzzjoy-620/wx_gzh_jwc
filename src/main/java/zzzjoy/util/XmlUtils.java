package zzzjoy.util;

import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class XmlUtils {

    /**
     * 将xml格式的字符串转换成Map对象
     * @param xmlStr xml格式的字符串
     * @return Map对象
     * @throws Exception 异常
     */


    public static Map<String, String> xmlStrToMap(String xmlStr) throws Exception {
        if (xmlStr.isEmpty()) {
            return null;
        }
        Map<String, String> map = new HashMap<>(16);

        //将xml格式的字符串转换成Document对象
        StringReader reader=new StringReader(xmlStr);
        InputSource source=new InputSource(reader);
        SAXReader sax = new SAXReader(); // 创建一个SAXReader对象
        Document doc =sax.read(source); // 获取document对象,如果文档无节点，则会抛出Exception提前结束


        Element root = doc.getRootElement();
        //获取根节点下的所有元素
        List children = root.elements();
        //循环所有子元素
        if (children != null && children.size() > 0) {
            for (Object o : children) {
                Element child = (Element) o;
                map.put(child.getName(), child.getTextTrim());
            }
        }
        return map;
    }

    public static String beanToXml(Object object, Class cls) {
        XStream stream = new XStream();
        stream.processAnnotations(cls);
        return stream.toXML(object);
    }

}
