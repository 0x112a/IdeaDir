package com.intoan.mapreduce.combineTextInputFormat;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * KEYIN, reduce阶段输入的key的类型 Text
 * VALUEIN,... IntWritable
 * KEYOUT，... 输出...Text
 * VALUEOUT, ...IntWritable
 */
public class WordCountReduce extends Reducer<Text, IntWritable, Text,IntWritable> {

    private IntWritable outValue = new IntWritable();

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

        int sum = 0;
        for (IntWritable value : values) {
            sum += value.get();
        }

        outValue.set(sum);
        context.write(key,outValue);
    }
}
