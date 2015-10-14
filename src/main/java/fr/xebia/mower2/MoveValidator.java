package fr.xebia.mower2;

/**
 * The Move validator class
 *
 * @author merradi
 */
public interface MoveValidator {

	/**
	 * Checks whether the position is valid an can be used by the mower
	 *
	 * @param position The position to be tested
	 * @return True if the position is valid an can be used by the mower
	 */
	boolean isValidPosition(Position position);
}