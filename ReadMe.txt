Name: Krupali Dedhia

IDE used: Eclipse
Run the program on: Command line

1. Create an input file with commands of the format-
    Command_name:value

2. Save the input file in the folder which has the source code

3. On the command line first make project 3 your present working directory

4. Then compile the two classes BSTmain.java and LazyBinarySearchTree.java using the following commands:

javac BSTmain.java
javac LazyBinarySearchTree.java

5. Run the program using the command:
java BSTmain inputfile.txt outputfile.txt

6. The outputfile.txt has the generated result

My program executes completely, it throws and catches errors where required. 

Example input:

Insert:98
Insert:67
Insert:55
Insert:45
PrintTree
Delete:84
Delete:45
Contains:45
FindMin
FindMax
PrintTree
Height
Size
Insert:84
Insert:32
Insert:132
Page 3 of 5
PrintTree
Insert:980
Insert
hih

Example output:

true
true
true
true
98 67 55 45 
false
true
false
55
98
98 67 55 *45 
3
4
true
true
Error in insert: IllegalArgumentException raised
Error in Line: Page 3 of 5
98 67 55 *45 32 84 
Error in insert: IllegalArgumentException raised
Error in Line: Insert
Error in Line: hih

