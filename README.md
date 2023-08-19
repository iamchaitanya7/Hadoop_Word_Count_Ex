# - Mastering Hadoop: A Beginner's Guide to Big Data Processing

Welcome to the world of Hadoop! In this guide, we'll embark on a journey to understand the fundamentals of Hadoop, its key components, and walk through engaging examples to solidify your knowledge.

## - Hadoop: Taming Big Data

Hadoop is a game-changer in the world of big data. It enables the processing of enormous datasets by distributing the workload across clusters of computers.

## - Hadoop Distributed File System (HDFS)

HDFS is Hadoop's storage backbone, designed for fault tolerance and scalability.

## - Uploading Files to HDFS

To upload your local files to the HDFS:

```bash
hdfs dfs -put local_file_path hdfs_path
```
## - Listing Files in HDFS
List the files in a directory within HDFS:
```bash
hdfs dfs -ls hdfs_directory_path
```
## - Unleashing MapReduce Power
MapReduce is Hadoop's processing paradigm, breaking down complex tasks into simpler components.

## - The Word Count Example
Let's demystify MapReduce with the classic word count example:
<br>

### 1. Map Phase: Tokenize input text and emit (word, 1) pairs. <br>
### 2. Shuffle and Sort: Group and sort pairs by word.<br>
### 3. Reduce Phase: Sum up the counts for each word.

```java
// Mapper
void map(Text key, Text value, Context context) {
    for (String word : value.toString().split("\\s+")) {
        context.write(new Text(word), new IntWritable(1));
    }
}

// Reducer
void reduce(Text key, Iterable<IntWritable> values, Context context) {
    int sum = 0;
    for (IntWritable value : values) {
        sum += value.get();
    }
    context.write(key, new IntWritable(sum));
}
```
## - Executing a MapReduce Job
Assuming you've compiled a Java MapReduce program (WordCount.class):

```bash
hadoop jar path/to/hadoop-streaming.jar \
    -input hdfs_input_path -output hdfs_output_path \
    -mapper "java WordCount" -reducer "java WordCount"
```

## - Embrace the Hadoop Ecosystem
Hadoop is part of a broader ecosystem with complementary tools like Hive, Pig, and Spark.
