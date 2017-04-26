package com.hbase.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created by wangcan on 2017/4/26.
 */
public interface IHostInfoService {

    List<JSONObject> getHostInfo() throws Exception;

    List<JSONObject> getHostBaseInfo() throws Exception;

    List<JSONObject> getConnectionInfo() throws Exception;

    List<JSONObject> getProcessInfo() throws Exception;
}
