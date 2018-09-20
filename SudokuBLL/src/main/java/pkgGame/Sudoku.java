package pkgGame;

public class Sudoku {
	private int[][] puzzle;
	
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
}
