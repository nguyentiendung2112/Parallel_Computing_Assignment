#run main

hadoop jar ./detect-duplicate-image/DDI.jar /assignment/seq /assignment/output

hdfs dfs -copyToLocal /assignment/output/ ~/assignment/result/
