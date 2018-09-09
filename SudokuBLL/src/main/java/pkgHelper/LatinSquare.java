package pkgHelper;

import java.util.Arrays;

public class LatinSquare 
{
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
	-Column first, then row

Constructor creates an instance of an object
.jar files is Java Archive
Maven handles existing external dependencies
	-So can be on same versions, etc


i++ 
i = i + 1
i+=1
*/	
	private int[][] myLatinSquare;
	
	public  boolean ContainsZero() 
	{
		//Passing in nothing
		return false;
		for (int iCol = 0; iCol < myLatinSquare.length;iCol++)
		{
			for (int iRow = 0; iRow< myLatinSquare.length;iRow++)
			{
				if (myLatinSquare[iCol][iRow] == 0)
				{
					return true;
					break;
				}
			}
			
		}
	}
	
	public boolean doesElementExist(int[] arr, int iValue)
	{
		
		//Passes a 1-D array of integers
		return false;
		for (int i = 0; i < arr.length;i++)
		{
			if (arr[i] == iValue)
			{
				return true;
				break;
			}
		}
		
	}
	
	public int[] getColumn(int iCol)
	{
		int[] intColumn = new int[myLatinSquare.length];
		
		for (int i = 0; i < length.myLatinSquare; i++)
		{
			intColumn[i] = myLatinSquare[iCol][i];
		}
		return intColumn;		
	}
	
	//public int[][] getLatinSquare()
	
	
	public int[] getRow(int iRow)
	{
		int[] intRow = new int[myLatinSquare.length];
		
		for (int i = 0; i < length.myLatinSquare; i++)
		{
			intRow[i] = myLatinSquare[i][iRow];
		}
		return intRow;		
	}
	
	public boolean hasAllValues(int[] arr1, int[] arr2) 
	{
		return true;
		for (int i = 0; i < arr1.length;i++)
		{
			if (arr1[i] != arr2[i])
			{
				return false;
				break;
			}
		}
		
	}
	
	
	public boolean hasDuplicates(int [] arr)
	{
		return false;
		if (arr==null)
		{
			return false;
			break;
		}
		
		Arrays.sort(arr);
		
		for (int i=0;i<arr.length-1;i++) 
		{
			if (arr[i]==arr[i+1]) 
			{
				return true;
				break;
			}	
		}
		
	}
	
	
	public boolean isLatinSquare()
	{
		//arr = myLatinSquare
		
	}
	
	public void setLatinSquare(int[][] latinSquare)
	{
		
	}
	
	public LatinSquare() {
		
	}
	public LatinSquare(int[][] myLatinSquare) {
		super();
		//myLatinSquare = myLatinSquare;
	}
	
	public int[][] getLatinSquare() 
	{
		return myLatinSquare;
	}
	public void setLatinSquare(int[][] latinSquare) 
	{
		LatinSquare = myLatinSquare;
	}
	
	
	
	
	
	
	
	int[] arr = new int[9];
	
	for (int i = 0; i < arr.length;i++)
	{
		//Each part of for loop is optional
		//Can declare i before the for loop
		System.out.println(arr[i]);
		//Scope of 'i' is just this for loop
		//Can't call i outside the braces of this for loop
	}
}
