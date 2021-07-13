package zzzjoy;


import com.alibaba.druid.sql.dialect.sqlserver.ast.SQLServerOutput;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import zzzjoy.bean.JwcUser;
import zzzjoy.bean.ReceiveData;
import zzzjoy.service.impl.BindUserServiceImpl;
import zzzjoy.util.AesEncodeUtils;
import zzzjoy.util.HttpClientUtils;

import javax.swing.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Mytest {

    public static void main(String[] args) {
        String a = AesEncodeUtils.encrypt("122439", "1234567890123456");
        System.out.println(AesEncodeUtils.encrypt("444439", "1234567890123456"));
        System.out.println(AesEncodeUtils.decrypt(a, "1234567890123456"));


    }



}





//        info_pattern1 = r'评教\@(\d{10,})\@(.*)'
//        info_pattern2 = r'(.*?)评教(.*?)'
//        info_pattern3 = r'成绩\@(\d{10,})\@(.*)'
//        info_pattern4 = r'(.*?)成绩(.*?)'
//        info_pattern5 = r'wps\@(\d{7,11})'
//        info_pattern6 = r'(.*?)wps(.*?)'
//        info1 = findall(info_pattern1, msg)
//        info2 = findall(info_pattern2, msg)
//        info3 = findall(info_pattern3, msg)
//        info4 = findall(info_pattern4, msg)
//        info5 = findall(info_pattern5, msg, re.I)
//        info6 = findall(info_pattern6, msg, re.I)
//
//        if len(info1) == 1:
//        return ['pj', info1[0][0], info1[0][1]]
//        elif len(info1) != 1 and len(info2) != 0:
//        return ['pj']
//        elif len(info3) == 1:
//        return ['cj', info3[0][0], info3[0][1]]
//        elif len(info3) != 1 and len(info4) != 0:
//        return ['cj']
//        elif len(info5) == 1:
//        return ['wps', info5[0]]
//        elif len(info5) != 1 and len(info6) != 0:
//        return ['wps']
//        else:
//        return ['']