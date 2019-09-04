## Simple tool for scoring [Decathlon](https://en.wikipedia.org/wiki/Decathlon#Benchmarks) results of athletes

Used Java 1.8 and JUnit 5

Prerequisites to run: JRE version 1.8

How to check:
```
java - version
```
#### Build (before usage if no `````jar````` file exists in `````"target"````` subfolder):
```
mvn package assembly:single
```

### Usage:
```
java -classpath ./target/izam-test-1.0-jar-with-dependencies.jar com.izamtest.decatlon.Application <input_filename.csv>

```
or 
```
under Windows: run.bat <input_filename.csv>
```

### Input file requirements:
should be text CSV file with comma ```';'``` separators.
Decimal separator for number values  ```'.' (dot)```,
time in formats:
```
mm.ss.SS - with minutes (mm),
ss.SS - secounds (ss) and fractions (SS
```

### Output: xml file with pointed scores of athletes sorted by descending with grouping by place ordering
So first position is the best.
Athletes with same results shares the one place in order.

Output xml file has the same name than input but uses ```".xml"``` extension instead of input ```".csv"```   


##### Contacts
```
@author Igor Zamyatin, email: capra.lanigera@gmail.com
````


