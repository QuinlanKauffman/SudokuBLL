package pkgHelper;

import static org.junit.Assert.*;

import org.junit.Test;

public class LatinSquareTest {

	@Test
	public void hasDuplicates_test() {
		
		int [] arr = {1,2,3,4,5};
		LatinSquare lq = new LatinSquare();
		assertFalse(lq.hasDuplicates(arr));
		
	}

}
