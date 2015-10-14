package fr.xebia.mower2;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import fr.xebia.mower2.Mower2;
import fr.xebia.mower2.Mower2Context;
import fr.xebia.mower2.Orientation;
import fr.xebia.mower2.Position;
import fr.xebia.mower2.Surface;

/**
 * Test class of Mower2Context
 *
 * @author merradi
 */
public class Mower2ContextTest {

	/**
	 * Limit area to test
	 */
	private final static int LIMIT_X = 5;

	private final static int LIMIT_Y = 5;

	/**
	 * Mowing context to test
	 */
	private Mower2Context mowingContext = new Mower2Context();

	@Before
	public void before() {
		mowingContext.setSurface(new Surface(LIMIT_X, LIMIT_Y));

		// Add some mowers
		mowingContext.addMower(new Mower2(mowingContext, new Position(0, 0), Orientation.N));
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
