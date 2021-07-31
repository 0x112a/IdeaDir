package com.intoan.mapreduce.combineTextInputFormat;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.lib.CombineFileInputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.CombineTextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;


public class WordCountDriver {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

        //Todo 1 获取job
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        //Todo 2 设置jar包路径
        job.setJarByClass(WordCountDriver.class);

        //Todo 3 关联mapper 和reducer

        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReduce.class);

        //Todo 4 设置map输出的kv类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        //Todo 5 设置最终输出的kv类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        //如果不设置InputFormat，默认使用的是TextInputFormat.class
        job.setInputFormatClass(CombineTextInputFormat.class);

        //虚拟存储切片最大值设置单位为字节
        CombineTextInputFormat.setMaxInputSplitSize(job,8192);


        //Todo 6 设置输入路径和输出路径

        FileInputFormat.setInputPaths(job, new Path("/home/monica/IdeaProjects/MapReduceDemo/input"));
        FileOutputFormat.setOutputPath(job, new Path("/home/monica/IdeaProjects/MapReduceDemo/output"));

        // Todo 7 提交job
        boolean result = job.waitForCompletion(true);

        System.exit(result ? 0 : 1);
    }

}