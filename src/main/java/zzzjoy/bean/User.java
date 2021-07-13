package zzzjoy.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String subscribe;
    private String openid;
    private String nickname;
    private Integer sex;
    private String language;
    private String city;
    private String province;
    private String country;
    private String headimgurl;
    private Long subscribe_time;
    private String remark;
    private Integer groupid;
    private String tagid_list;
    private String subscribe_scene;

}
