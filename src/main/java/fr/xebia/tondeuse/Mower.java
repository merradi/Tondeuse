package fr.xebia.tondeuse;

/**
 * The programmable mower
 *
 * @author merradi
 */
public class Mower {

	/**
	 * Move validator
	 */
	private MoveValidator moveValidator;

	/**
	 * The current position of the mower in the surface
	 */
	private Position position;

	/**
	 * Orientation of the mower
	 */
	private Orientation orientation;

	/**
	 * Constructor with the mowing area and the initial position of the mower in this area
	 *
	 * @param moveValidator Move validator
	 * @param position      Initial position of the mower on the surface
	 * @param orientation   The initial value of orientation
	 */
	public Mower(MoveValidator moveValidator, Position position, Orientation orientation) {
		this.moveValidator = moveValidator;
		this.position = position;
		this.orientation = orientation;
	}

	/**
	 * Perform a left rotation
	 */
	public void rotateLeft() {
		switch (orientation) {
			case N:
				orientation = Orientation.W;
				break;
			case E:
				orientation = Orientation.N;
				break;
			case S:
				orientation = Orientation.E;
				break;
			case W:
				orientation = Orientation.S;
				break;
		}
	}

	/**
	 * Perform a right rotation
	 */
	public void rotateRight() {
		switch (orientation) {
			case N:
				orientation = Orientation.E;
				break;
			case E:
				orientation = Orientation.S;
				break;
			case S:
				orientation = Orientation.W;
				break;
			case W:
				orientation = Orientation.N;
				break;
		}
	}

	/**
	 * Move one step forward if the next position is in the area
	 */
	public void moveForward() {
		Position newPosition = null;
		switch (orientation) {
			case N:
				newPosition = new Position(position.getX(), position.getY() + 1);
				break;
			case E:
				newPosition = new Position(position.getX() + 1, position.getY());
				break;
			case S:
				newPosition = new Position(position.getX(), position.getY() - 1);
				break;
			case W:
				newPosition = new Position(position.getX() - 1, position.getY());
				break;
		}

		// If it' a valid position ?
		if ((newPosition != null)
				&& (moveValidator != null) && moveValidator.isValidPosition(newPosition)) {
			position = newPosition;
		}
	}

	public MoveValidator getMoveValidator() {
		return moveValidator;
	}

	public void setMoveValidator(MoveValidator moveValidator) {
		this.moveValidator = moveValidator;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	@Override
	public String toString() {
		return String.format("%d %d %S", position.getX(), position.getY(), orientation);
	}
}
