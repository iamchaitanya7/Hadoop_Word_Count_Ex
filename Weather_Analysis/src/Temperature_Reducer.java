import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class Temperature_Reducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    public void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {
        int maxvalue=Integer.MIN_VALUE;
        for (IntWritable value : values) {
            maxvalue=Math.max(maxvalue, value.get());
        }
        context.write(key, new IntWritable(maxvalue));
    }
}