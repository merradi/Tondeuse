//package fr.xebia.tondeuse;
//
//import static org.junit.Assert.fail;
//
//import java.io.IOException;
//import java.util.List;
//
//import junitparams.JUnitParamsRunner;
//import junitparams.Parameters;
//
//import org.apache.commons.io.IOUtils;
//import org.fest.assertions.Assertions;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
///**
// * Test class of MowingController
// *
// * @author merradi
// */
//@RunWith(JUnitParamsRunner.class)
//public class MowingControllerTest {
//
//	/**
//	 * Class to test
//	 */
//	private MowingController mowingController = new MowingController();
//
//	/**
//	 * Test of MowingController.mow method
//	 */
//	@Test
//	@Parameters(method = "mowParameters")
//	public void testMow(String input, String output) {
//
//		try {
//			List<String> instructions = IOUtils.readLines(getClass().getResourceAsStream(input));
//			List<String> expectedResult = IOUtils.readLines(getClass().getResourceAsStream(output));
//
//			// Start mowing
//			List<String> result = mowingController.mow(instructions);
//
//			// Test output
//			Assertions.assertThat(result).isEqualTo(expectedResult);
//		} catch (Exception e) {
//			fail("MowingException: " + e.getMessage());
//		} catch (IOException e) {
//			fail("Error reading test files, it should not happen.");
//		}
//	}
//
//	/**
//	 * Test of MowingController.mow method
//	 */
//	@Test
//	public void testMowWhenInvalidSurface() {
//		try {
//			List<String> instructions = IOUtils.readLines(getClass().getResourceAsStream("/invalid-surface-input.txt"));
//			mowingController.mow(instructions);
//			fail("MowingController.mow must throw a MowingException caused by surface.");
//		} catch (Exception e) {
//
//		} catch (IOException e) {
//			fail("Error reading test files, it should not happen.");
//		}
//	}
//
//	/**
//	 * Test of MowingController.mow method
//	 */
//	@Test
//	public void testMowWhenInvalidMowerCoordinates() {
//		try {
//			List<String> instructions = IOUtils.readLines(getClass().getResourceAsStream("/invalid-mower-coordinates-input.txt"));
//			mowingController.mow(instructions);
//			fail("MowingController.mow must throw a MowingException caused by mower coordinates.");
//		} catch (Exception e) {
//
//		} catch (IOException e) {
//			fail("Error reading test files, it should not happen.");
//		}
//	}
//
//	/**
//	 * Test of MowingController.mow method
//	 */
//	@Test
//	public void testMowWhenInvalidMowerInstructions() {
//		try {
//			List<String> instructions = IOUtils.readLines(getClass().getResourceAsStream("/invalid-mower-instructions-input.txt"));
//			mowingController.mow(instructions);
//			fail("MowingController.mow must throw a MowingException caused by mower instructions.");
//		} catch (Exception e) {
//
//		} catch (IOException e) {
//			fail("Error reading test files, it should not happen.");
//		}
//	}
//
//	/**
//	 * @return collection of parameters to execute testMow
//	 */
//	public static Object[] mowParameters() {
//
//		return new String[][]{
//				{"/input.txt", "/output.txt"},
//				{"/collision-input.txt", "/collision-output.txt"}
//		};
//	}
//}
