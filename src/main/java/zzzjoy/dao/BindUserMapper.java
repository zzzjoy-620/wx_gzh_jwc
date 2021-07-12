package zzzjoy.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import zzzjoy.bean.JwcUser;

import java.util.List;

@Repository
@Mapper
public interface BindUserMapper {
    Integer insertJwcUser(JwcUser jwcUser);
    List<JwcUser> selectJwcUserByOpenId(String openId);
    Integer updateJwcUser(JwcUser jwcUser) ;
}
