package zzzjoy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Map;


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
