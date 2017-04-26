package com.hbase.api;

import com.hbase.service.IHostInfoService;
import com.hbase.utils.AjaxJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangcan on 2017/4/26.
 */
@RestController
@RequestMapping(value = "/hostInfo")
@Api(value = "主机信息相关rest接口")
public class HostInfoController {

    private Logger logger = LoggerFactory.getLogger(HostInfoController.class);

    @Autowired
    private IHostInfoService hostInfoService;

    @RequestMapping(value = "/hostInfo",method = RequestMethod.GET)
    @ApiOperation("获取主机信息")
    public AjaxJson getHostInfo(){
        AjaxJson ret = new AjaxJson();
       try {
            ret.setMsg(hostInfoService.getHostInfo());
        } catch (Exception e) {
            logger.error("获取主机信息失败！",e);
            e.printStackTrace();
            ret.setSuccess(false).setMsg("获取主机信息失败");
        }
        return ret;
    }

    @RequestMapping(value = "/hostBaseInfo",method = RequestMethod.GET)
    @ApiOperation("获取主机基础信息")
    public AjaxJson getHostBaseInfo(){
        AjaxJson ajaxJson = new AjaxJson();

        try {
            ajaxJson.setMsg(hostInfoService.getHostBaseInfo());
        } catch (Exception e) {
            logger.error("获取主机基础信息失败！",e);
            e.printStackTrace();
            ajaxJson.setMsg("获取主机基础信息失败！").setSuccess(false);
        }

        return ajaxJson;
    }

    @RequestMapping(value = "/connectInfo",method = RequestMethod.GET)
    @ApiOperation("获取连接信息")
    public AjaxJson getConnectInfo(){
        AjaxJson ajaxJson = new AjaxJson();
        try {
            ajaxJson.setMsg(hostInfoService.getConnectionInfo());
        } catch (Exception e) {
            logger.error("获取连接信息失败！",e);
            e.printStackTrace();
            ajaxJson.setMsg("获取连接信息失败！").setSuccess(false);
        }

        return ajaxJson;
    }

    @RequestMapping(value = "/processInfo",method = RequestMethod.GET)
    @ApiOperation("获取进程信息")
    public AjaxJson getProcessInfo(){
        AjaxJson ajaxJson = new AjaxJson();

        try {
            ajaxJson.setMsg(hostInfoService.getProcessInfo());
        } catch (Exception e) {
            logger.error("获取进程信息失败！",e);
            e.printStackTrace();
            ajaxJson.setMsg("获取进程信息失败！").setSuccess(false);
        }

        return ajaxJson;
    }

}
