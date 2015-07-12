package fr.xebia.tondeuse;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class of MowerContext
 *
 * @author merradi
 */
public class MowerContextTest {

	/**
	 * Limit area to test
	 */
	private final static int LIMIT_X = 5;

	private final static int LIMIT_Y = 5;

	/**
	 * Mowing context to test
	 */
	private MowingContext mowingContext = new MowingContext();

	@Before
	public void before() {
		mowingContext.setSurface(new Surface(LIMIT_X, LIMIT_Y));

		// Add some mowers
		mowingContext.addMower(new Mower(mowingContext, new Position(0, 0), Orientation.N));
	}

	/**
	 * Test of Surface.isValidPosition method when no collision
	 */
	@Test
	public void testIsValidPosition() {
		Assertions.assertThat(mowingContext.isValidPosition(new Position(1, 1))).isTrue();
	}

	/**
	 * Test of Surface.isValidPosition method when collision
	 */
	@Test
	public void testIsValidPositionWhenCollision() {
		Assertions.assertThat(mowingContext.isValidPosition(new Position(0, 0))).isFalse();
	}
}
