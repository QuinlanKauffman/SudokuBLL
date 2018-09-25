package pkgGame;
import java.util.Random;
import java.util.*;

import pkgHelper.LatinSquare;
public class Sudoku extends LatinSquare {

		
		private int iSize;
		private int iSqrtSize;

		
		public Sudoku(int iSize) throws Exception {
			this.iSize = iSize;

			double SQRT = Math.sqrt(iSize);
			if ((SQRT == Math.floor(SQRT)) && !Double.isInfinite(SQRT)) {
				this.iSqrtSize = (int) SQRT;
			} else {
				throw new Exception("Invalid size");
			}
		}

		
		public Sudoku(int[][] puzzle) throws Exception {
			super(puzzle);
			this.iSize = puzzle.length;
			double SQRT = Math.sqrt(iSize);
			if ((SQRT == Math.floor(SQRT)) && !Double.isInfinite(SQRT)) {
				this.iSqrtSize = (int) SQRT;
			} else {
				throw new Exception("Invalid size");
			}

		}

		public int[][] getPuzzle() {
			return super.getLatinSquare();
		}

		
		public int[] getRegion(int iCol, int iRow) {

			int i = (iCol / iSqrtSize) + ((iRow / iSqrtSize) * iSqrtSize);

			return getRegion(i);
		}

		

		public int[] getRegion(int r) {

			int[] reg = new int[super.getLatinSquare().length];

			int j = (r % iSqrtSize) * iSqrtSize;
			int i = (r / iSqrtSize) * iSqrtSize;
			int jMax = j + iSqrtSize;
			int iMax = i + iSqrtSize;
			int iCnt = 0;

			for (; i < iMax; i++) {
				for (j = (r % iSqrtSize) * iSqrtSize; j < jMax; j++) {
					reg[iCnt++] = super.getLatinSquare()[i][j];
				}
			}

			return reg;
		}
	
		
	public boolean isValueValid(int iCol, int iRow, int iValue)
	{
		boolean a = true;
		if (super.doesElementExist(super.getRow(iRow),iValue) == true)
		{
			a = false;
		}
		if (super.doesElementExist(super.getColumn(iCol),iValue) == true)
		{
			a = false;	
		}
		if (super.doesElementExist(getRegion(iCol,iRow),iValue) == true)
		{
			a = false;
		}
		return a;
		
	}
	
	
	
	public boolean isSudoku() {
		boolean a = true;
		boolean b;
		int c;
		int[][] mySud = super.getLatinSquare();
		int zeroCheck = 0;
		
		if (super.isLatinSquare() == false)
		{
			//Checking if actually a latin square
			a = false;
		}
		
		if (super.ContainsZero() == true)
		{
			a = false;
		}
		
		
		for(int i=0;i<iSize;i++)
		{
			for(int j=0;j<iSize;j++)
			{
				c = mySud[i][j];
				mySud[i][j] = 0;
				if(c!= zeroCheck)
				{
					b = isValueValid(j,i,c);
					if(b == false)
					{
						a = false;
						break;
					}
				}
				mySud[i][j] = c;
				//Reset back
			}
			
		}
		return a;
	}
	
	public boolean isPartialSudoku() {

		boolean a = true;
		boolean b;
		int c;
		int zeroCheck = 0;
		int[][] mySud = super.getLatinSquare();
		
		if(super.ContainsZero() == false)
		{
			a = false;
		}
		
		for(int i=0;i<iSize;i++)
		{
			for(int j=0;j<iSize;j++)
			{
				c = mySud[i][j];
				mySud[i][j] = 0;
				if(c!= zeroCheck)
				{
					b = isValueValid(j,i,c);
					if(b == false)
					{
						a = false;
						break;
					}
				}
				mySud[i][j] = c;
				//Reset back
			}
		}
	
		return a;
	}
	
	public void createSudoku()
	{
		int[][] mySud = super.getLatinSquare();
		int r;
		
		
		for (int iRow = 0; iRow<iSize;iRow++)
		{
			//Loop over the rows
			for (int iCol=0;iCol<iSize;iCol++)
			{
				//Loop over the columns
				
				//Add a condition statement to only loop at non-diagonal regions
				//if(getRegionNmr(iCol,iRow) == )
				r = (iCol / iSqrtSize) + ((iRow / iSqrtSize) * iSqrtSize);
				
				int i = (r/iSqrtSize);
				int j = (r%iSqrtSize);
				
				if(i != j)
					//Assuming the diagonal regions have already been set
				{
					int[] c = new int[iSize];
					//Creates a blank 1-D array
					//Will fill the array with the valid values from 1 to iSize
					int a = 0;
					//Keeps count of how many values are valid 
					for (int k=1;k<=iSize;k++)
					{
						if(isValueValid(iCol,iRow,k) == true)
						{
							c[a] = k;
							a++;
							
						}
					}
					
					Random rand = new Random();
					int pickedNumber = rand.nextInt(a);
					//nextInt is non-inclusive
					//Picking a random index of c
					//Will only pick the indices that correspond to valid values
					mySud[iRow][iCol] = c[pickedNumber];
				}
			}
		}
		
		super.setLatinSquare(mySud);
	}
	
	private int getRegionNbr(int iCol, int iRow)
	{
		int r = (iCol / iSqrtSize) + ((iRow / iSqrtSize) * iSqrtSize);
		return r;
	}
	
	private void setRegion(int r)
	{
		int [][] mySud = super.getLatinSquare();
		int[] a = getRegion(r);
		for (int k=0;k<a.length;k++)
		{
			a[k] = k+1;
		}
		
		int count = 0;
		int j = (r % iSqrtSize) * iSqrtSize;
		int i = (r / iSqrtSize) * iSqrtSize;
		int jMax = j + iSqrtSize;
		int iMax = i + iSqrtSize;
		for (;i<iMax;i++)
		{
			for (;j<jMax;j++)
			{
				mySud[i][j] = a[count];
				count++;
			}
		}
		
		super.setLatinSquare(mySud);
		//Setting the latin square for a given region
	}
	
	private void FillDiagonalRegions()
	{
		//After the puzzle is created, set the diagonal regions with random values
		
		//Need to create formula that checks if a region is on the diagonal
		
		for(int r=0;r<iSize;r++)
		{
			//Loop over the regionNumbers
			int indexRow = (r/iSqrtSize);
			int indexCol = (r%iSqrtSize);
			
			if(indexRow == indexCol)
				//Need a condition statement to check if region is on the diagonal
				{
					setRegion(r);
					//SetRegion should shuffle the array inside the region
				}
		}
		
	}
	
	private void shuffleArray(int[] ar)
	{
		
		int holder1;
		int holder2;
		for (int i=0;i<ar.length;i++)
		{
			Random rand = new Random();
			int pickedIndex = rand.nextInt(ar.length-i);
			pickedIndex = pickedIndex - i;
			//Picking a random index from current i to length
			
			holder1 = ar[pickedIndex];
			holder2 = ar[i];
			ar[i] = holder1;
			ar[pickedIndex] = holder2;
		}
	}
	
	void printPuzzle()
	{
		for (int i=0;i<iSize;i++)
		{
			System.out.println(Arrays.toString(super.getRow(i)));
		}
	}
	
	
	private void shuffleRegion(int r)
	{
		int[] ar = getRegion(r);
		shuffleArray(ar);
	
		
		
	}
}
