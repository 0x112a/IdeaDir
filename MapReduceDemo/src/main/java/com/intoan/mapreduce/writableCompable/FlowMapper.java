package com.intoan.mapreduce.writableCompable;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlowMapper extends Mapper<LongWritable, Text,FlowBean, Text> {

    private Text outK = new Text();
    private FlowBean outV = new FlowBean();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {


        String line = value.toString();

        String[] split = line.split(" ");

        int n = split.length;


        String phone = split[1];
        String upFlow = split[n - 3];
        String downFlow = split[n-2];

        outK.set(phone);

        outV.setUpFlow(Long.parseLong(upFlow));
        outV.setDownFlow(Long.parseLong(downFlow));
        outV.setSumFlow();

        context.write(outV,outK);
    }
}
