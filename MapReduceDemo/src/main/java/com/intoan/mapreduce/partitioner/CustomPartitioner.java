package com.intoan.mapreduce.partitioner;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class CustomPartitioner extends Partitioner<Text,FlowBean> {
    @Override
    public int getPartition(Text text, FlowBean flowBean, int numPartitions) {

        //获取手机号前三位
        String phone = text.toString();
        String prePhone = phone.substring(0, 3);

        int partition;
        if ("123".equals(prePhone)){
            partition =0;
        }else {
            partition =1;
        }

        return partition;

    }
}
