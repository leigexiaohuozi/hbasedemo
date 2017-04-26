package com.hbase.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hbase.repository.HostInfoRepository;
import com.hbase.service.IHostInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangcan on 2017/4/26.
 */
@Service
public class HostInfoService implements IHostInfoService{

    @Autowired
    private HostInfoRepository hostInfoRepository;

    @Override
    public List<JSONObject> getHostInfo() throws Exception {
        //return hostInfoRepository.getInfo();
        return null;
    }

    @Override
    public List<JSONObject> getHostBaseInfo() throws Exception {

        return hostInfoRepository.getHostBaseInfo();
    }

    @Override
    public List<JSONObject> getConnectionInfo() throws Exception {
        return hostInfoRepository.getConnectionInfo();
    }

    @Override
    public List<JSONObject> getProcessInfo() throws Exception {
        return hostInfoRepository.getProcessInfo();
    }
}
