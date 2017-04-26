package com.hbase.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangcan on 2017/4/26.
 */
public class HbaseConnectUtil {

    private static final Logger logger = LoggerFactory.getLogger(HbaseConnectUtil.class);

    private static Configuration conf = null;

    private static Connection conn = null;

    /**
     * 初始化hbase configuration
     */

    static{

        try {
            conf = HBaseConfiguration.create();
            conf.set("hbase.zookeeper.property.clientPort", PropertiesUtil.getInstance().getProperty("zookeeper.clientPort"));
            conf.set("hbase.zookeeper.quorum", PropertiesUtil.getInstance().getProperty("zookeeper.quorum"));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("创建hbase configuration出错",e);
        }

    }

    /**
     * 获取hbase配置对象
     * @return
     */
    public static Configuration getConfig() {
        return conf;
    }


    /**
     * 获取Admin对象
     * @return
     */
    public static Connection getConn() {
        try {
            conn = ConnectionFactory.createConnection(conf);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

}
