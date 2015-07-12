package fr.xebia.tondeuse;

import java.util.ArrayList;
import java.util.List;

/**
 * Holder for both Surface and list o mowers presents in surface
 *
 * @author merradi
 */
public class MowingContext implements MoveValidator {

	/**
	 * Surface to mow
	 */
	private Surface surface;

	/**
	 * List of mowers present in surface
	 */
	private List<Mower> mowers = new ArrayList<Mower>();

	/**
	 * @see MoveValidator#isValidPosition(Position)
	 */
	public boolean isValidPosition(Position position) {
		return surface.isValidPosition(position) && isEmpty(position);
	}

	/**
	 * Checks whether the position is empty
	 *
	 * @param position The position to be tested
	 * @return True if the position is empty
	 */
	private boolean isEmpty(Position position) {
		for (Mower mower : mowers) {
			if (mower.getPosition().equals(position)) {
				return false;
			}
		}
		return true;
	}

	public void addMower(Mower mower) {
		mowers.add(mower);
	}

	public Surface getSurface() {
		return surface;
	}

	public void setSurface(Surface surface) {
		this.surface = surface;
	}
}