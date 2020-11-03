package com.opstty.mapper;

        import org.apache.hadoop.io.LongWritable;
        import org.apache.hadoop.io.NullWritable;
        import org.apache.hadoop.io.Text;
        import org.apache.hadoop.mapreduce.Mapper;
        import java.io.IOException;

public class DisWTreesMapper extends Mapper<LongWritable, Text, Text, NullWritable> {


    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //only the first line of out csv contains GEOPOINT and it is useless so we remove values containing geopoint
        if(!value.toString().contains("GEOPOINT")){
            Text district = new Text(value.toString().split(";")[1]);
            context.write(district,NullWritable.get());
        }
    }
}
