find classes -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java classes/Simulator scenario.txt
