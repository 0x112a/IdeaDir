package com.intoan.mapreduce.partitionercompable;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class ProvincePartitioner2 extends Partitioner<FlowBean, Text> {
    @Override
    public int getPartition(FlowBean flowBean, Text text, int numPartitions) {

        String phone = text.toString();
        String prePhone = phone.substring(0, 3);

        int partition;

        if ("123".equals(prePhone)){
            partition = 0;
        }else {
            partition = 1;
        }

        return partition;

    }
}
