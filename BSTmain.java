/* Name: Krupali dedhia
 * Class: CS 3345
 * Section: 003
 * Professor: Anjum Chida
 */

// Main function that takes the input of the inputfile
// and outputfile and reads commands from inputfile and executes it from the LazyBinarySearchTree class

import java.util.*;
import java.io.*;

public class BSTmain {
	// main function
	public static void main(String[] args) {
		
		// check if the # of arguments is 2
		if(args.length == 2) {
			Scanner inputFile = null;
			PrintWriter outFile = null;
            File outputFile = new File(args[1]);
            
			LazyBinarySearchTree tree = new LazyBinarySearchTree();
			String line = "";
				
				// try to open input and output file
				try {
					inputFile = new Scanner(new File(args[0]));
					
					// create output file if the file doesnot exist
					if (!outputFile.exists())
		                   outputFile.createNewFile();
		                outFile = new PrintWriter(outputFile);
		            while(inputFile.hasNextLine()) {
		            	
		            	line = inputFile.nextLine().trim();
		            	String[] input = new String[line.length()];
		            	
		            		// divide the command into two parts
		            		if(line.contains(":")) {
		            			input = line.split(":");
		            		} else {
		            			input[0] = line;
		            		}
		            		
		            		// use the switch case to know the command 
		                switch(input[0]) {
		                		// calls the insert command of LazyBST class
		                		case "Insert": 
		                			if(input[1] == null) {
		                				outFile.println("Error in Line: Insert");
		                			} else {
			                			try {
			                				boolean insert = tree.insert(Integer.parseInt(input[1]));
				                			outFile.println(insert);
			                			} catch (IllegalArgumentException ex){
			                				outFile.println("Error in insert: IllegalArgumentException raised");
			                			}
		                			}
		                			
		                			break;
		                			
			                	// calls the delete command of LazyBST class
		                		case "Delete": 
		                			try {
		                				boolean delete = tree.delete(Integer.parseInt(input[1]));
			                			outFile.println(delete);
		                			} catch (IllegalArgumentException ex){
		                				outFile.println("Error in insert: IllegalArgumentException raised");
		                			}
		                		    break;
		                		    
			                	// calls the FindMax command of LazyBST class
		                		case "FindMax": 
		                			int max = tree.findMax();
		                			outFile.println(max);
		                			break;
		                			
			                // calls the FindMin command of LazyBST class
		                		case "FindMin": 
		                			int min = tree.findMin();
		                			outFile.println(min);
		                			break;
		                			
			                	// calls the contains command of LazyBST class	
		                		case "Contains": 
		                			try {
		                				boolean con = tree.contains(Integer.parseInt(input[1]));
			                			outFile.println(con);
		                			} catch (Exception ex){
		                				outFile.println("Invalid input");
		                			}
		                			
		                			break;
		                			
			                 // calls the PrintTree command of LazyBST class
		                		case "PrintTree": 
		                			String str = tree.toString();
		                			outFile.println(str);
		                			break;
		                			
		                		// calls the height command of LazyBST class
		                		case "Height":
		                			int height = tree.height();
		                			outFile.println(height);
		                			break;
		                			
			                	// calls the size command of LazyBST class
		                		case "Size":
		                			int size = tree.size();
		                			outFile.println(size);
		                			break;
		                			
			                	// exits the program if 
		                		case "":
		                		    break;
		                		    
		                		 default:
		                			 outFile.println("Error in Line: " + input[0]);
		                			
		                }
		                
		            }   
		            // close the input and output files 
		            inputFile.close();
	                outFile.close();
				} catch(FileNotFoundException ex) {
		            System.out.println( "Unable to open file '" + inputFile + "'"); 
		            
		        } catch(IOException ex) {
		            System.out.println("Error reading file '" + inputFile + "'");                 
		        }
		} else {
		        System.out.println("Please Input Valid Arguments in Command Line");
		}
		
	}

}
