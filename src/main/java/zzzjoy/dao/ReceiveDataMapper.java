package zzzjoy.dao;

import org.apache.ibatis.annotations.Mapper;
import zzzjoy.bean.ReceiveData;

@Mapper
public interface ReceiveDataMapper {
    Integer insertReceiveData(ReceiveData receiveData);
}
