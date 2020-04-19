package DDI ; 
import java.io.*;

import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class DDIReducer extends Reducer <Text, Text,IntWritable, Text>{
		public void reduce (Text key , Iterable<Text> values , Context context) 
		throws IOException , InterruptedException {
				String list = "" ; 
				int count =0 ;
				for (Text t : values){
						list += t.toString() + '\t' ;
						count ++ ; 
					}
			context.write(new IntWritable(count), new Text(list)); 
			} 

	}
