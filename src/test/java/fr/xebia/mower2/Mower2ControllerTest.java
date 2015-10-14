package fr.xebia.mower2;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.List;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.apache.commons.io.IOUtils;
import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;

import fr.xebia.mower2.Mower2Controller;

/**
 * Test class of Mower2Controller
 *
 * @author merradi
 */
@RunWith(JUnitParamsRunner.class)
public class Mower2ControllerTest {

	/**
	 * Class to test
	 */
	private Mower2Controller mowingController = new Mower2Controller();

	/**
	 * Test of MowingController.mow method
	 */
	@Test
	@Parameters(method = "mowParameters")
	public void testMow(String input, String output) throws IOException {

		try {
			List<String> instructions = IOUtils.readLines(getClass().getResourceAsStream(input));
			List<String> expectedResult = IOUtils.readLines(getClass().getResourceAsStream(output));

			// Start mowing
			List<String> result = mowingController.mow(instructions);

			// Test output
			Assertions.assertThat(result).isEqualTo(expectedResult);
		} catch (Exception e) {
			fail("MowingException: " + e.getMessage());
		}
	}

	/**
	 * Test of MowingController.mow method
	 */
	@Test
	public void testMowWhenInvalidSurface() throws IOException {
		try {
			List<String> instructions = IOUtils.readLines(getClass().getResourceAsStream("/invalid-surface-input.txt"));
			mowingController.mow(instructions);
			fail("MowingController.mow must throw a MowingException caused by surface.");
		} catch (Exception e) {

		}
	}

	/**
	 * Test of MowingController.mow method
	 */
	@Test
	public void testMowWhenInvalidMowerCoordinates() throws IOException {
		try {
			List<String> instructions = IOUtils.readLines(getClass().getResourceAsStream("/invalid-mower-coordinates-input.txt"));
			mowingController.mow(instructions);
			fail("MowingController.mow must throw a MowingException caused by mower coordinates.");
		} catch (Exception e) {

		}
	}

	/**
	 * Test of MowingController.mow method
	 */
	@Test
	public void testMowWhenInvalidMowerInstructions() throws IOException {
		try {
			List<String> instructions = IOUtils.readLines(getClass().getResourceAsStream("/invalid-mower-instructions-input.txt"));
			mowingController.mow(instructions);
			fail("MowingController.mow must throw a MowingException caused by mower instructions.");
		} catch (Exception e) {

		}
	}

	/**
	 * @return collection of parameters to execute testMow
	 */
	public static Object[] mowParameters() {

		return new String[][]{
				{"/input.txt", "/output.txt"},
				{"/collision-input.txt", "/collision-output.txt"}
		};
	}
}
