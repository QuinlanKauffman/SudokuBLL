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
				if (myLatinSquare[iRow][iCol] == 0)
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
		
		for (int i = 0; i < myLatinSquare.length; i++)
		{
			intColumn[i] = myLatinSquare[i][iCol];
		}
		return intColumn;		
	}
	
	
	
	public int[] getRow(int iRow)
	{
		int[] intRow = new int[myLatinSquare.length];
		
		for (int i = 0; i < myLatinSquare.length; i++)
		{
			intRow[i] = myLatinSquare[iRow][i];
		}
		return intRow;		
	}
	
	public boolean hasAllValues(int[] arr1, int[] arr2) 
	{
		return true;
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
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
		//return false by default
		
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
		//don't actually need the doesElementExist method
		//already covered
		//don't need ContainsZero method
		
		
		return true; //return true by default
		
		/*
		if (ContainsZero == true)
		{
			return false;
			break;
		}
		*/
		
		private int[] arr = new int[myLatinSquare.length]; //used in the hasAllValues method
		for (int i = 0; i < arr.length;i++)
		{
			arr[i] = i+1;
			//'arr' is an array of 1,2,3,...,n
		}
		
		
		for (int iRow = 0;iRow<myLatinSquare.length;iRow++)
		{
			if (hasAllValues(getRow(iRow), arr) == false)
			//checks all rows of 'myLatinSquare' 
			{
				return false;
				break;
		
			}
			
			if (hasDuplicates(getRow(iRow))==true)
			{
				return false;
				break;
			}
		}
		
		for (int iCol = 0; iCol < myLatinSquare.length;iCol++)
		{
			if (hasAllValues(getColumn(iCol),arr)==false)
			{
				return false;
				break;
			}
			
			if (hasDuplicates(getColumn(iCol))==true)
			{
				return false;
				break;
			}
		}
		
		
		
		/*
		 * arr = myLatinSquare
		use the methods already created, like getColumn, hasAllValues, hasDuplicates
		
		Check 
			hasDuplicates(1 array)
			hasAllValues(2 different arrays)
			doesElementExist(1 array and 1 array of i=1:n)
		Need
			getColumn(iCol)
			getRow(iRow)
 			array of i=1:myLatinSquare.length
		 */
	}
	
	
	
	//public LatinSquare() {
		
	//}
	
	public LatinSquare(int[][] myLatinSquare) 
	{
		super();
		//myLatinSquare = myLatinSquare;
	}
	
	public int[][] getLatinSquare() 
	{
		//just need to return 'myLatinSquare'
		return myLatinSquare;
	}
	
	public void setLatinSquare(int[][] latinSquare) 
	{
		//setting 'myLatinSquare'
		myLatinSquare = latinSquare ;
	}
}
