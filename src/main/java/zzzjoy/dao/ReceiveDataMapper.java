package zzzjoy.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import zzzjoy.bean.ReceiveData;

@Repository
@Mapper
public interface ReceiveDataMapper {
    Integer insertReceiveData(ReceiveData receiveData);
}
