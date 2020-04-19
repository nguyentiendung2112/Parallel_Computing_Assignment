package DDI ; 
import java.io.* ;

import org.apache.hadoop.io.BytesWritable ;
import org.apache.hadoop.io.Text ; 
import org.apache.hadoop.mapreduce.Mapper ; 

public class DDIMapper extends Mapper <Text, BytesWritable , Text , Text> {
		public void map(Text key , BytesWritable value , Context context)
		throws IOException , InterruptedException {
				Text hash = new Text(Skein512.hash(value.getBytes() , value.getLength()));
				context.write(hash, key );
			}
	}
