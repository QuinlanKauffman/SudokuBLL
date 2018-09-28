package pkgHelper;

import pkgEnum.ePuzzleViolation;

public class PuzzleViolation {

	private ePuzzleViolation ePuzzleViolation;
	private int iValue;

	 
	public PuzzleViolation(pkgEnum.ePuzzleViolation ePuzzleViolation, int iValue) {
		super();
		this.ePuzzleViolation = ePuzzleViolation;
		this.iValue = iValue;
	}

	public ePuzzleViolation getePuzzleViolation() {
		return ePuzzleViolation;
	}

	public int getiValue() {
		return iValue;
	}

}