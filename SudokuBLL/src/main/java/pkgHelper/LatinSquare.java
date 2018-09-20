package pkgHelper;

import java.util.Arrays;

public class LatinSquare 
{

	private int[][] myLatinSquare;
	
	public  boolean ContainsZero() 
	{
		boolean a = false;
		//Passing in nothing
		
		for (int iCol = 0; iCol < myLatinSquare.length;iCol++)
		{
			for (int iRow = 0; iRow< myLatinSquare.length;iRow++)
			{
				if (myLatinSquare[iRow][iCol] == 0)
				{
					a = true;
					break;
				}
			}
			
		}
		return a;
	}
	
	public boolean doesElementExist(int[] arr, int iValue)
	{
		boolean a = false;
		//Passes a 1-D array of integers
		
		
		for (int i = 0; i < arr.length;i++)
		{
			if (arr[i] == iValue)
			{
				a = true;
				break;
			}
		}
		return a;
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
		boolean a = true;
		
		
		Arrays.sort(arr1);
		
		Arrays.sort(arr2);
		
		for (int i = 0; i < arr1.length;i++)
		{
			if (arr1[i] != arr2[i])
			{
				a = false;
				break;
			}
		}
		return a;
	}
	
	
	public boolean hasDuplicates(int [] arr)
	{
		boolean a = false;
		//return false by default
		
		Arrays.sort(arr);
		
		if (arr!=null)
		{
			for (int i=0;i<arr.length-1;i++) 
			{
				if (arr[i]==arr[i+1]) 
				{
					a =  true;
					break;
				}	
			}
		
		}
			
		return a;
	}
	
	
	public boolean isLatinSquare()
	{
		//don't actually need the doesElementExist method
		//already covered
		//don't need ContainsZero method
		boolean a = true; //return true by default
		
		
		
		
		
		int[] arr = getRow(0);
		
		
		for (int iRow = 0;iRow<myLatinSquare.length;iRow++)
		{
			if (hasAllValues(getRow(iRow), arr) == false)
			//checks all rows of 'myLatinSquare' 
			{
				a = false;
				break;
		
			}
			
			if (hasDuplicates(getRow(iRow))==true)
			{
				a = false;
				break;
			}
		}
		
		for (int iCol = 0; iCol < myLatinSquare.length;iCol++)
		{
			if (hasAllValues(getColumn(iCol),arr)==false)
			{
				a = false;
				break;
			}
			
			if (hasDuplicates(getColumn(iCol))==true)
			{
				a = false;
				break;
			}
		}
		
		if (ContainsZero() == true)
		{
			a = false;
		}
		
		return a;
		
	}
	
	
	public LatinSquare()
	{
		
	}
	
	
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
