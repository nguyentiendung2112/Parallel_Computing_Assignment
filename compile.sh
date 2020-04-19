#compile 

javac -cp `hadoop classpath` -d ./convertToSequence/ ./convertToSequence/*.java

jar cfm MySequenceFile.jar ./convertToSequence/Manifest.txt ./convertToSequence/Convertsequence/*.class

echo "done compile !"

javac -cp `hadoop classpath` -d ./detect-duplicate-image ./detect-duplicate-image/*.java

jar cfm DDI.jar ./detect-duplicate-image/Manifest.txt ./detect-duplicate-image/DDI/*.class

echo "done compile !"
