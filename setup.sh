#initialize 
$HADOOP_HOME/sbin/start-all.sh

#remove old file 

hdfs dfs -rm -r -f /assignment/*

#make new input dir 
hdfs dfs -mkdir /assignment
hdfs dfs -mkdir /assignment/input 
hdfs dfs -put dataset/* /assignment/input

