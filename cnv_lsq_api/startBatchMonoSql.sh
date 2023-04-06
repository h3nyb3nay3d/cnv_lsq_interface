#!/bin/bash

################################################################
# Notice : 
# JAVA_HOME must be set
################################################################
set classpathsave=$CLASSPATH
set classpathtmp = ""

for i in `ls ./lib`
do
   classpathtmp=$classpathtmp:./lib/$i:
done

classpathtmp=./classes:$classpathsave:$classpathtmp


#echo "[SPRING-BATCH-SAMPLE] running with classpath : $CLASSPATH"

echo 
echo " ============   Debut =================="  >> ./logs/SPRING-BATCH-SAMPLE.log
date >> ./logs/SPRING-BATCH-SAMPLE.log
$JAVA_HOME/bin/java -Xms512M -Xmx1024M -cp $classpathtmp com.linedata.ekip.batch.autotransaction.launcher.AutoTransactionLauncher
date >>./logs/SPRING-BATCH-SAMPLE.log
echo " ============   Fin ===================="  >>./logs/SPRING-BATCH-SAMPLE.log
