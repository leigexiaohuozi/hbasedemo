package com.hbase.repository;

import com.alibaba.fastjson.JSONObject;
import com.hbase.utils.HbaseConnectUtil;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangcan on 2017/4/26.
 */
@Repository
public class HostInfoRepository {

    private String rowKey = "0012_4553_99359";

    public List<JSONObject> getInfo(String family) throws Exception{

        /*Connection connection = HbaseConnectUtil.getConn();
        Table table = connection.getTable(TableName.valueOf("host_info"));
        Scan scan = new Scan();
        ResultScanner rs = table.getScanner(scan);
        for(Result result:rs){
            System.out.println(result);
        }
        rs.close();*/
        Connection connection = HbaseConnectUtil.getConn();
        Table table = connection.getTable(TableName.valueOf("host_info"));
        Get query = new Get(rowKey.getBytes());
        query.addFamily(family.getBytes());
        if(table.exists(query)){
            Result result = table.get(query);
            System.out.format("ROW\t%s\n",new String(result.getRow()));
            List<JSONObject> list = new ArrayList<>();
            for(Cell cell : result.rawCells()){
                JSONObject jsonObject = new JSONObject();
                //原始数据
                JSONObject cellObj = (JSONObject) JSONObject.parse(Bytes.toString(CellUtil.cloneValue(cell)));
                System.out.println(cellObj);
                list.add(cellObj);
            }
            return list;
        }
        return null;
    }


    public List<JSONObject> getHostBaseInfo() throws Exception{
        return getInfo("host_base_info");
    }

    public List<JSONObject> getConnectionInfo() throws Exception{
        return getInfo("connection_info");
    }

    public List<JSONObject> getProcessInfo() throws Exception{
        return getInfo("process_info");
    }
}
