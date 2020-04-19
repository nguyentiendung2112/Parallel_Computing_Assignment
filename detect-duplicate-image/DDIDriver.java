package DDI ; 
import java.io.* ;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class DDIDriver extends Configured implements Tool{
	@Override
	public int run(String[] args) throws Exception{
		Configuration conf=new Configuration();
		Job job=Job.getInstance(conf);
		job.setJarByClass(DDIDriver.class);
		job.setJobName("DDI");

		job.setInputFormatClass(SequenceFileInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		FileInputFormat.setInputPaths(job,new Path(args[0]));
		FileOutputFormat.setOutputPath(job,new Path(args[1]));

		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(Text.class);

		job.setMapperClass(DDIMapper.class);
		job.setReducerClass(DDIReducer.class);
		return job.waitForCompletion(true)?0:1;
	}
	public static void main(String[] args) throws Exception{
		int exitCode=ToolRunner.run(new DDIDriver(),args);
		System.exit(exitCode);
	}
}
