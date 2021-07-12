package zzzjoy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zzzjoy.bean.ReceiveData;
import zzzjoy.dao.ReceiveDataMapper;
import zzzjoy.service.ReceiveDataService;
@Service
public class ReceiveDataServiceImpl implements ReceiveDataService {

    @Autowired
    private ReceiveDataMapper receiveDataMapper;

    @Override
    public Integer addReceiveData(ReceiveData receiveData) {
        return receiveDataMapper.insertReceiveData(receiveData);
    }
}
