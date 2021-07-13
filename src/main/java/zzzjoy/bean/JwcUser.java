package zzzjoy.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwcUser {

    private String openId;
    private String username;
    private String password;
    private Timestamp creatTime;

}
