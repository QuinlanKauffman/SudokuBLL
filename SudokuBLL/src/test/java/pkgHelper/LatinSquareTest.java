package pkgHelper;

import static org.junit.Assert.*;

import org.junit.Test;

public class LatinSquareTest 
{

	@Test
	public void ContainsZeroTest() 
	{
		
		int [][] mySquare = {{1,2,3},{3,1,2},{2,3,1}};
		mySquare[0][1] = 0;
		LatinSquare ls = new LatinSquare(mySquare);
		//Referencing the ...
		
		//"new" signals looking for the conductor
		assertFalse(ls.ContainsZero());
		//assertFalse only passes (i.e. returns true) 
		//if the boolean one of the test cases is false
		//are ~12 assert____ tests
		
		
	}

}
