package zzzjoy.dao;

import org.apache.ibatis.annotations.Mapper;
import org.omg.CORBA.WStringSeqHelper;
import org.springframework.stereotype.Repository;
import zzzjoy.bean.User;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    Integer insertUser(User user);
    List<User> selectUserByOpenId(String openId);
}
