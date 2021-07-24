package com.intoan.mapreduce.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * KEYIN, map阶段输入的key的类型 LongWritable
 * VALUEIN,...Text
 * KEYOUT，... Text
 * VALUEOUT, ...IntWritable
 */
public class WordCountMapper extends Mapper<LongWritable, Text,Text,IntWritable> {

    private Text outText = new Text();

    private IntWritable outValue = new IntWritable(1);

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String line = value.toString();

        String[] words = line.split(" ");

        for (String word : words) {

            outText.set(word);

            context.write(outText,outValue);
        }

    }
}
