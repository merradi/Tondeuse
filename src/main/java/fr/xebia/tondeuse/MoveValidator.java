package fr.xebia.tondeuse;

/**
 * Move validator
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