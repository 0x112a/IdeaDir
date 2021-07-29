package com.intoan.mapreduce.partitioner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.CombineTextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class FlowDriver {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        job.setJarByClass(FlowDriver.class);

        job.setMapperClass(FlowMapper.class);
        job.setReducerClass(FlowReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowBean.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);

        FileInputFormat.setInputPaths(job,new Path("/home/monica/IdeaProjects/MapReduceDemo/input"));
        FileOutputFormat.setOutputPath(job,new Path("/home/monica/IdeaProjects/MapReduceDemo/output"));

        // 指定自定义分区
        job.setPartitionerClass(CustomPartitioner.class);

        //同时制定相应的ReduceTask
        job.setNumReduceTasks(2);

        //设置联合小文件输入
        job.setInputFormatClass(CombineTextInputFormat.class);

        //设置虚拟存储器大小
        CombineTextInputFormat.setMaxInputSplitSize(job,4096);

        boolean b = job.waitForCompletion(true);

        System.exit(b ? 0 : 1);
    }
}
