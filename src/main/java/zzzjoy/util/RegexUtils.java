package zzzjoy.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

    private static final String BIND = ".*绑定.*";

    private static final String QUERY_SCORE = ".*成绩.*";

    private static final String ACCESS_TEACHER = ".*评教.*";

    private static final String BIND_USER = "绑定@(\\d{10,})@(.*)";


    // 判断是否有绑定字样
    public static boolean matchBIND(String content){
        return Pattern.matches(BIND, content);
    }
    // 判断是否有成绩字样
    public static boolean matchQUERY_SCORE(String content){
        return Pattern.matches(QUERY_SCORE, content);
    }
    // 判断是否有评教字样
    public static boolean matchACCESS_TEACHER(String content){
        return Pattern.matches(ACCESS_TEACHER, content);
    }

    public static List<List<String>> getUserList(String content){
        List<List<String>> userList = new ArrayList<>();
        Pattern pattern = Pattern.compile(BIND_USER);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            // group=1对应(\d{10,}), 匹配的值即为学号
            // group=1对应(.*), 匹配的值即为密码
            List<String> user = new ArrayList<>();
            user.add(matcher.group(1));
            user.add(matcher.group(2));
            userList.add(user);
        }
        return userList;
    }



}
