package pkgHelper;

import java.util.Arrays;

public class LatinSquare {
/*Rules for a Latin Square
	-No number is repeated in any column or row
	-Every element in the first row must match the elements in the first row
	-Every element in the first column must match the elements in the first column
	-For our case, every element is an int
	-1-D arrays of ints for rows and columns
	-Entire Latin Square is 2-D array of ints

Rules for java array
	-Index starts at 0
	-Once array is sized, it can't be changed
	-"int [] arr = new int[4]
		New array length is 4
	-Default value for int is 0
	-"System.out.println(Arrays.toString(arr));"

i++ 
i = i + 1
*/	
	private int[][] LatinSquare(){
		
	}

	public LatinSquare() {
		
	}
	public LatinSquare(int[][] latinSquare) {
		super();
		LatinSquare = latinSquare;
	}
	
	public int[][] getLatinSquare() {
		return LatinSquare;
	}
	public void setLatinSquare(int[][] latinSquare) {
		LatinSquare = latinSquare;
	}
	
	public boolean hasDuplicates(int [] arr) {
		boolean hasDuplicates = false;
		if (arr==null)
			return false;
		
		Arrays.sort(arr);
		
		for (int i=0;i<arr.length-1;i++) {
			if (arr[i]==arr[i+1]) {
				hasDuplicates = true;
				break;
			}
				
		}
		
		return hasDuplicates;
	}
	
	int[] arr = new int[9];
	
	for (int i = 0; i < arr.length;i++) {
		//Each part of for loop is optional
		//Can declare i before the for loop
		System.out.println(arr[i]);
		//Scope of 'i' is just this for loop
		//Can't call i outside the braces of this for loop
	}
}
