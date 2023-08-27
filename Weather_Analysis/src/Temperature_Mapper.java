import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Mapper;

public class Temperature_Mapper extends Mapper<LongWritable, Text, Text, IntWritable >
{
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        String line=value.toString();
        String year=line.substring(15,19);
        int airtemp;
        if(line.charAt(87)== '+')
        {
            airtemp=Integer.parseInt(line.substring(88,92));
        }
        else
            airtemp=Integer.parseInt(line.substring(87,92));
        String q=line.substring(92,93);
        if(airtemp!=9999&&q.matches("[01459]"))
        {
            context.write(new Text(year),new IntWritable(airtemp));
        }
    }
}
