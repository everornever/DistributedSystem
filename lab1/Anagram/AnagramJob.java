import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.fs.Path;
public class AnagramJob{
	public static void main(String...args) throws Exception{
		Configuration conf=new Configuration();
		Job job=Job.getInstance(conf,"anagram group");
		job.setJarByClass(AnagramJob.class);
		job.setMapperClass(AnagramMapper.class);
		job.setReducerClass(AnagramReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		FileInputFormat.addInputPath(job,new Path(args[0]));
		FileOutputFormat.setOutputPath(job,new Path(args[1]));
		System.exit(job.waitForCompletion(true)?0:1);
	}
}

