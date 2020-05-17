#execute convertToSequence
hadoop jar ./convertToSequence/MySequenceFile.jar /assignment/input/ /assignment/seq/

hdfs dfs -rm /assignment/seq/_SUCCESS 

