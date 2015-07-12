package fr.xebia.tondeuse;

/**
 * The mowing area
 *
 * @author merradi
 */
public class Surface implements MoveValidator {

	/**
	 * Maximum value of the X and Y coordinates
	 */
	private int limitX;
	private int limitY;

	/**
	 * Constructor with the limit of X and Y coordinates
	 *
	 * @param limitX Maximum value of the X coordinate
	 * @param limitY Maximum value of the Y coordinate
	 */
	public Surface(int limitX, int limitY) {
		this.limitX = limitX;
		this.limitY = limitY;
	}

	/**
	 * Checks whether the position is in the area
	 *
	 * @param position The position to be tested
	 * @return True if the position is in the area otherwise false
	 */
	public boolean isValidPosition(Position position) {
		return (position.getX() >= 0) && (position.getX() <= limitX)
				&& (position.getY() >= 0) && (position.getY() <= limitY);
	}

	public int getLimitX() {
		return limitX;
	}

	public int getLimitY() {
		return limitY;
	}
}
