package zzzjoy.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
//    "subscribe": 1,
//    "openid": "o6_bmjrPTlm6_2sgVt7hMZOPfL2M",
//    "nickname": "Band",
//    "sex": 1,
//    "language": "zh_CN",
//    "city": "广州",
//    "province": "广东",
//    "country": "中国",
//    "headimgurl":"http://thirdwx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/0",
//    "subscribe_time": 1382694957,
//    "unionid": " o6_bmasdasdsad6_2sgVt7hMZOPfL"
//    "remark": "",
//    "groupid": 0,
//    "tagid_list":[128,2],
//    "subscribe_scene": "ADD_SCENE_QR_CODE",
//    "qr_scene": 98765,
//    "qr_scene_str": ""

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
