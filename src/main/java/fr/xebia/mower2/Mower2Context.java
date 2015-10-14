package fr.xebia.mower2;

import java.util.ArrayList;
import java.util.List;

/**
 * The Mower2Context class
 * Holder for both Surface and list o mowers presents in surface
 *
 * @author merradi
 */
public class Mower2Context implements MoveValidator {

	/**
	 * Surface to mow
	 */
	private Surface surface;

	/**
	 * List of mowers present in surface
	 */
	private List<Mower2> mowers = new ArrayList<Mower2>();

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
		for (Mower2 mower : mowers) {
			if (mower.getPosition().equals(position)) {
				return false;
			}
		}
		return true;
	}

	public void addMower(Mower2 mower) {
		mowers.add(mower);
	}

	public Surface getSurface() {
		return surface;
	}

	public void setSurface(Surface surface) {
		this.surface = surface;
	}
}