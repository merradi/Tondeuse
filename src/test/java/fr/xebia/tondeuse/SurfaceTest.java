package fr.xebia.tondeuse;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test class of Surface
 *
 * @author merradi
 */
@RunWith(JUnitParamsRunner.class)
public class SurfaceTest {

	/**
	 * Limit area to test
	 */
	private final static int LIMIT_X = 5;
	private final static int LIMIT_Y = 5;

	/**
	 * Surface to test
	 */
	private Surface surface = new Surface(LIMIT_X, LIMIT_Y);

	/**
	 * Test of Surface.isValidPosition method
	 *
	 * @param position       Position to test
	 * @param expectedReturn Expected result
	 */
	@Test
	@Parameters(method = "parameters")
	public void testIsValidPosition(Position position, boolean expectedReturn) {
		Assertions.assertThat(surface.isValidPosition(position)).isEqualTo(expectedReturn);
	}

	/**
	 * @return Collection of parameters
	 */
	public static Object[] parameters() {
		return new Object[][]{
				// Corners
				{new Position(0, 0), true},
				{new Position(LIMIT_X, 0), true},
				{new Position(LIMIT_X, LIMIT_Y), true},
				{new Position(0, LIMIT_Y), true},

				// In
				{new Position(1, 1), true},
				{new Position(LIMIT_X - 1, 1), true},
				{new Position(LIMIT_X - 1, LIMIT_Y - 1), true},
				{new Position(1, LIMIT_Y - 1), true},

				// Out
				{new Position(-1, -1), false},
				{new Position(LIMIT_X + 1, -1), false},
				{new Position(LIMIT_X + 1, LIMIT_Y + 1), false},
				{new Position(-1, LIMIT_Y + 1), false},
		};
	}
}