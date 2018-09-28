package pkgGame;

import pkgEnum.ePuzzleViolation;
import pkgHelper.LatinSquare;
import pkgHelper.PuzzleViolation;
import java.security.SecureRandom;
import java.util.*;

import pkgHelper.LatinSquare;

public class Sudoku extends LatinSquare {

	/**
	 * 
	 * iSize - the length of the width/height of the Sudoku puzzle.
	 * 
	 * @version 1.2
	 * @since Lab #2
	 */
	private int iSize;

	/**
	 * iSqrtSize - SquareRoot of the iSize. If the iSize is 9, iSqrtSize will be
	 * calculated as 3
	 * 
	 * @version 1.2
	 * @since Lab #2
	 */

	private int iSqrtSize;

	/**
	 * Sudoku - for Lab #2... do the following:
	 * 
	 * set iSize If SquareRoot(iSize) is an integer, set iSqrtSize, otherwise throw
	 * exception
	 * 
	 * @version 1.2
	 * @since Lab #2
	 * @param iSize-
	 *            length of the width/height of the puzzle
	 * @throws Exception
	 *             if the iSize given doesn't have a whole number square root
	 */
	public Sudoku(int iSize) throws Exception {
		this.iSize = iSize;

		double SQRT = Math.sqrt(iSize);
		if ((SQRT == Math.floor(SQRT)) && !Double.isInfinite(SQRT)) {
			this.iSqrtSize = (int) SQRT;
		} else {
			throw new Exception("Invalid size");
		}
	}

	/**
	 * Sudoku - pass in a given two-dimensional array puzzle, create an instance.
	 * Set iSize and iSqrtSize
	 * 
	 * @version 1.2
	 * @since Lab #2
	 * @param puzzle
	 *            - given (working) Sudoku puzzle. Use for testing
	 * @throws Exception will be thrown if the length of the puzzle do not have a whole number square root
	 */
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

	/**
	 * getPuzzle - return the Sudoku puzzle
	 * 
	 * @version 1.2
	 * @since Lab #2
	 * @return - returns the LatinSquare instance
	 */
	public int[][] getPuzzle() {
		return super.getLatinSquare();
	}

	/**
	 * getRegion - figure out what region you're in based on iCol and iRow and call
	 * getRegion(int)<br>
	 * 
	 * Example, the following Puzzle:
	 * 
	 * 0 1 2 3 <br>
	 * 1 2 3 4 <br>
	 * 3 4 1 2 <br>
	 * 4 1 3 2 <br>
	 * 
	 * getRegion(0,3) would call getRegion(1) and return [2],[3],[3],[4]
	 * 
	 * @version 1.2
	 * @since Lab #2
	 * @param iCol
	 *            given column
	 * @param iRow
	 *            given row
	 * @return - returns a one-dimensional array from a given region of the puzzle
	 */
	public int[] getRegion(int iCol, int iRow) {

		int i = (iCol / iSqrtSize) + ((iRow / iSqrtSize) * iSqrtSize);

		return getRegion(i);
	}

	/**
	 * getRegion - pass in a given region, get back a one-dimensional array of the
	 * region's content<br>
	 * 
	 * Example, the following Puzzle:
	 * 
	 * 0 1 2 3 <br>
	 * 1 2 3 4 <br>
	 * 3 4 1 2 <br>
	 * 4 1 3 2 <br>
	 * 
	 * getRegion(2) and return [3],[4],[4],[1]
	 * 
	 * @version 1.2
	 * @since Lab #2
	 * @param r
	 *            given region
	 * @return - returns a one-dimensional array from a given region of the puzzle
	 */

	public int[] getRegion(int r) {

		int[] reg = new int[super.getLatinSquare().length];


		int i = (r / iSqrtSize) * iSqrtSize;
		int j = (r % iSqrtSize) * iSqrtSize;		
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
	
 
	
	@Override
	public boolean hasDuplicates()
	{
		if (super.hasDuplicates())
			return true;
		
		for (int k = 0; k < this.getPuzzle().length; k++) {
			if (super.hasDuplicates(getRegion(k))) {
				super.AddPuzzleViolation(new PuzzleViolation(ePuzzleViolation.DupRegion,k));
			}
		}
	
		return (super.getPV().size() > 0);
	}

	/**
	 * isPartialSudoku - return 'true' if...
	 * 
	 * It's a LatinSquare If each region doesn't have duplicates If each element in
	 * the first row of the puzzle is in each region of the puzzle At least one of
	 * the elemnts is a zero
	 * 
	 * 
	 * @version 1.2
	 * @since Lab #2
	 * @return true if the given puzzle is a partial sudoku
	 */
	public boolean isPartialSudoku() {

		super.setbIgnoreZero(true);
		
		super.ClearPuzzleViolation();
		
		if (hasDuplicates())
			return false;

		if (!ContainsZero()) {
			super.AddPuzzleViolation(new PuzzleViolation(ePuzzleViolation.MissingZero, -1));
			return false;
		}
		return true;

	}

	/**
	 * isSudoku - return 'true' if...
	 * 
	 * Is a partialSudoku Each element doesn't a zero
	 * 
	 * @version 1.2
	 * @since Lab #2
	 * @return - returns 'true' if it's a partialSudoku, element match (row versus column) and no zeros
	 */
	public boolean isSudoku() {

		this.setbIgnoreZero(false);
		
		super.ClearPuzzleViolation();
		
		if (hasDuplicates())
			return false;
		
		if (!super.isLatinSquare())
			return false;
		
		for (int i = 1; i < super.getLatinSquare().length; i++) {

			if (!hasAllValues(getRow(0), getRegion(i))) {
				return false;
			}
		}

		if (ContainsZero()) {
			return false;
		}

		return true;
	}

	/**
	 * isValidValue - test to see if a given value would 'work' for a given column /
	 * row
	 * 
	 * @version 1.2
	 * @since Lab #2
	 * @param iCol
	 *            puzzle column
	 * @param iRow
	 *            puzzle row
	 * @param iValue
	 *            given value
	 * @return - returns 'true' if the proposed value is valid for the row and column
	 */
	public boolean isValidValue(int iCol, int iRow, int iValue) {
		
		if (doesElementExist(super.getRow(iRow),iValue))
		{
			return false;
		}
		if (doesElementExist(super.getColumn(iCol),iValue))
		{
			return false;
		}
		if (doesElementExist(this.getRegion(iCol, iRow),iValue))
		{
			return false;
		}
		
		return true;
	}

	public int[][] createSudoku()
	{
		FillDiagonalRegions();
		System.out.println("");
		for (int y = 0;y<iSize;y++)
		{
			System.out.println(Arrays.toString(super.getLatinSquare()[y]));
		}
		System.out.println("");

		int[][] temporarySudoku;
		
		
		for (int iRow = 0; iRow<iSize;iRow++)
		{
			//Loop over the rows
			for (int iCol=0;iCol<iSize;iCol++)
			{
				//Loop over the columns
				
				//Add a condition statement to only loop at non-diagonal regions
				//if(getRegionNmr(iCol,iRow) == )
				int r = getRegionNbr(iCol, iRow);
				
				int rowIndex = (r/iSqrtSize);
				int colIndex = (r%iSqrtSize);
				
				if(rowIndex != colIndex)
				{
				
					//Assuming the diagonal regions have already been set
					//Change this
				
					int[] possibilitiesArray = new int[iSize];
					//Creates a blank 1-D array
					//Will fill the array with the valid values from 1 to iSize
					int count = 0;
					//Keeps count of how many values are valid 
					for (int k=1;k<=iSize;k++)
					{
						if(isValueValid(iCol,iRow,k) == true)
						{
							possibilitiesArray[count] = k;
							count++;
							
						}
						else
							continue;
					}
					
					Random rand = new SecureRandom();
					int pickedNumber = rand.nextInt(count);
					System.out.println(pickedNumber);
					//nextInt is non-inclusive
					//Picking a random index of c
					//Will only pick the indices that correspond to valid values
					temporarySudoku = super.getLatinSquare();
					System.out.println("The possible value selected: ");
					System.out.println(possibilitiesArray[pickedNumber]);
					temporarySudoku[iRow][iCol] = possibilitiesArray[pickedNumber];
					super.setLatinSquare(temporarySudoku);
				}
			}
		}
		
		return (super.getLatinSquare());
	}
	
	public int getRegionNbr(int iCol, int iRow)
	{
		int r = (iCol / iSqrtSize) + ((iRow / iSqrtSize) * iSqrtSize);
		return r;
	}
	
	private void setRegion(int r)
	{
		
		
		int[][] temporarySudoku;
		//int[] a = getRegion(r);
		int[] a = new int[iSize];
		for (int k=0;k<a.length;k++)
		{
			a[k] = k+1;
		}
		
		int count = 0;
		
		int i = (r / iSqrtSize) * iSqrtSize;
		int j = (r % iSqrtSize) * iSqrtSize;
		int iMax = i + iSqrtSize;
		int jMax = j + iSqrtSize;

		for (;i<iMax;i++)
		{
			for (;j<jMax;j++)
			{
				
				temporarySudoku = super.getLatinSquare();
				temporarySudoku[i][j] = a[count];
				super.setLatinSquare(temporarySudoku);
				count++;
			}
		}
		
		
	}
	
	private void FillDiagonalRegions()
	{
		//After the puzzle is created, set the diagonal regions with random values
		
		//Need to create formula that checks if a region is on the diagonal
		
		for(int r=0;r<iSqrtSize;r++)
		{
			if (r == 0)
			{
				setRegion(r);
			}
			else
			{
				setRegion(r*iSqrtSize+1);
			}
			
		}
	}
	
	private void shuffleArray(int[] ar)
	{
		
		int pickedIndex;
		int holder1;
		int holder2;
		for (int i=0;i<ar.length;i++)
			
		{
			Random rand = new SecureRandom();
			pickedIndex = rand.nextInt(ar.length-i);
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
		int[][] temporarySudoku;
		
		int[] ar = getRegion(r);
		shuffleArray(ar);
		
		//int[][] mySud = super.getLatinSquare();
		//Setting the region
		int count = 0;
		int i = (r / iSqrtSize) * iSqrtSize;
		int j = (r % iSqrtSize) * iSqrtSize;
		int iMax = i + iSqrtSize;
		int jMax = j + iSqrtSize;

		for (;i<iMax;i++)
		{
			for (;j<jMax;j++)
			{
				temporarySudoku = super.getLatinSquare();
				temporarySudoku[i][j] = ar[count];
				super.setLatinSquare(temporarySudoku);
				count++;
			}
		}
		
		
	}
}
