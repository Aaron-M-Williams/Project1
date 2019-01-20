package main.course.oop.tictactoe.util;
import java.lang.StringBuilder;
import java.util.Stack;

/**
 * You must implement the following methods to accept the expected 
 * parameters and return accurate results.
 * You are allowed and expected to add any class attributes and methods 
 * needed to complete this assignment. 
 * 
 *
 */
public class TwoDArray {
	
	private int defaultValue;
	private int arrayColumns;
	private int arrayRows;
	private int[][] array;
	
	
	public TwoDArray(int rows, int cols, int defaultVal){
		/*TODO - Create a 2D integer array consisting of 
		 * the number of rows and columns given. Initialize 
		 * the array by setting each int to be the defaulVal. 
		 * */
		
		defaultValue = defaultVal;
		arrayColumns = cols;
		arrayRows = rows;
		
		array = new int[rows][cols];
		for (int i=0; i<rows; i++) 
		{
			for(int j=0; j<cols; j++) 
			{
				array[i][j] = defaultVal;
			}
		}
		
		
		
	}
	
	public void initArray(int defaultVal) {
		/*TODO - (Re)Initialize the array by 
		 * setting each int to be the defaulVal 
		 */
		defaultValue = defaultVal;
		for (int i=0; i<arrayRows; i++) 
		{
			for(int j=0; j<arrayColumns; j++) 
			{
				array[i][j] = defaultVal;
			}
		}
		
	}
	
	public String insertInt(int row, int col, int val) {
		/*TODO - "Insert" based on the following conditions:
		 * 1. The location [row][col] is still set to the default value
		 * 		-return "Success! (val) was inserted.
		 * 
		 * 2. The location [row][col] is no longer the default value
		 * 		-return "Failure: (row), (col) is not empty.
		 * 
		 * 3. val is not the default value; 
		 * 		-return "Failure: (val) is not allowed."
		 * 
		 * Note: Print the int value in place of (). 
		 * e.g., replace (val) with val.
		 */
		
		if (val ==defaultValue) 
		{
			return "Failure: " + val+ " is not allowed.";
		}
		
		if (array[row][col] == defaultValue) 
		{
			array[row][col] = val;
			return "Success! " + val +" was inserted.";
		}
		
		if (array[row][col] != defaultValue) 
		{
			return "Failure: " + row + ", " + col + " is not empty.";
		}
		
		return "Not implemented";
	}
	
	public int getInt(int row, int col) {
		/*TODO - Return the value at the specified row, col
		 * 
		 */
		return array[row][col];
		
	}
	
	public String getArrayDisplay() {
		/*TODO - Create a 2D display of the Array
		 * e.g. 
		 * 	1	0	1
		 *  0	1	0
		 *  0	1	1
		 * 
		 */
		StringBuilder toReturn = new StringBuilder();
		toReturn.append("\n");
		for (int i =0; i<arrayRows; i++) {
			for (int j=0; j<arrayColumns; j++) {
				toReturn = toReturn.append(array[i][j]);
				toReturn = toReturn.append(' ');
			}
			toReturn = toReturn.append("\n");
		}
		
		return toReturn.toString();
	}
	
	public String getArrayDetails() {
		/*TODO - List the following:
		 * # rows
		 * # columns
		 * How many unique values (in the above example, this would be 2
		 * Value and count of each (e.g. 
		 * 			value:1 count:5
		 * 			value:0 count:4
		 * 
		 * 			)
		 * 
		 */
		
		StringBuilder toReturn = new StringBuilder();
		
		toReturn.append(arrayRows);
		toReturn.append("\n");
		toReturn.append(arrayColumns);
		toReturn.append("\n");
		
		Stack<Integer> temp = new Stack<Integer>();
		
		for (int i=0; i<arrayRows; i++) 
		{
			for(int j=0; j<arrayColumns; j++) 
			{
				if(!temp.contains(array[i][j])) {
					temp.push(array[i][j]);
				}
			}
		}
		toReturn.append(temp.size());
		toReturn.append("\n");
		
		
		while(!temp.isEmpty()) {
			
			int count = 0;
			int compare= temp.pop();
			
			for(int i =0; i< arrayRows; i++) {
				for (int j=0; j<arrayColumns; j++) {
					if (array[i][j] == compare) {
						count++;
					}
				}
			}
			
			toReturn.append("value: "+ compare + " count: " + count + "\n");
			
			
		}
		
		
		return toReturn.toString();
	}		

}
