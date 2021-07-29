package com.intoan.mapreduce.partitioner;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class FlowReducer extends Reducer<Text, FlowBean,Text, FlowBean> {

    private FlowBean outV = new FlowBean();
    @Override
    protected void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {

        long upFlow = 0;
        long downFlow = 0;


        for (FlowBean value : values) {
//            outV.setUpFlow(outV.getUpFlow()+value.getUpFlow());
//            outV.setDownFlow(outV.getDownFlow()+value.getDownFlow());
            upFlow+=value.getUpFlow();
            downFlow = value.getDownFlow();
        }
        outV.setUpFlow(upFlow);
        outV.setDownFlow(downFlow);
        outV.setSumFlow();

        context.write(key,outV);
    }
}
