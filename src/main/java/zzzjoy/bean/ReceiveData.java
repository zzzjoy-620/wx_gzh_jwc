package zzzjoy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Map;

//{
//        "code": "200",
//        "msg": "查询成功！",
//        "service": "01",
//        "service_ip": "49.234.211.60",
//        "data": {
//        "password": "91K9TcdUJVv6M7lprpaOMA==",
//        "type": "query_score",
//        "username": "2018137120"
//        }
//}

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiveData {
    private String code;
    private String msg;
    private String service;
    private String serviceIp;
    private String data;
    private Timestamp creatTime;

}
