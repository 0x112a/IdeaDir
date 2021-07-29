package com.intoan.mapreduce.partitionercompable;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
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

        job.setMapOutputKeyClass(FlowBean.class);
        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);

        FileInputFormat.setInputPaths(job,new Path("/home/monica/IdeaProjects/MapReduceDemo/input1"));
        FileOutputFormat.setOutputPath(job,new Path("/home/monica/IdeaProjects/MapReduceDemo/output"));

        job.setPartitionerClass(ProvincePartitioner2.class);

        job.setNumReduceTasks(2);
        boolean b = job.waitForCompletion(true);

        System.exit(b ? 0 : 1);
    }
}
