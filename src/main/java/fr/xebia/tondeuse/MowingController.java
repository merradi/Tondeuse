package fr.xebia.tondeuse;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Mowing controller, manage a list of mowers to mow an area
 * This controller is stateless
 *
 * @author merradi
 */
public class MowingController {

	/**
	 * Mow an area using list of instructions
	 *
	 * @param mowingInstructions List of instructions
	 * @return Mowers output final positions
	 */
	public List<String> mow(List<String> mowingInstructions) throws Exception  {
		MowingContext context = new MowingContext();
		List<String> output = new ArrayList<String>();

		// Create surface
		context.setSurface(createSurface(mowingInstructions.get(0)));

		for (int i = 1; i < mowingInstructions.size(); i += 2) {
			Mower mower = createMower(context, mowingInstructions.get(i));

			// Execute instructions
			if (i + 1 <= mowingInstructions.size()) {
				executeInstructions(mower, mowingInstructions.get(i + 1));
				output.add(mower.toString());
			}

			context.addMower(mower);
		}

		return output;
	}

	/**
	 * Create surface using the limit x and y given in the row
	 *
	 * @param row input instructions
	 * @throws Exception  if the row is invalid
	 */
	private Surface createSurface(String row) throws Exception  {

		// Validate line
		Pattern p = Pattern.compile("^([1-9]\\d*) ([1-9]\\d*)$");
		Matcher m = p.matcher(row);
		if (!m.matches()) {
			throw new Exception ("Invalid surface.");
		}
		return new Surface(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)));
	}

	/**
	 * Create mower using the x, y and orientation given in the row
	 *
	 * @param context mowing context
	 * @param row     input instructions
	 * @throws Exception  if the row is invalid
	 */
	private Mower createMower(MowingContext context, String row) throws Exception  {

		// Validate line
		Pattern p = Pattern.compile("^([1-9]\\d*) ([1-9]\\d*) ([NESW])$");
		Matcher m = p.matcher(row);
		if (!m.matches()) {
			throw new Exception ("Invalid mower coordinates at line: " + row);
		}

		return new Mower(context, new Position(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2))),
				Orientation.valueOf(m.group(3)));
	}

	/**
	 * Execute the instruction given in the row on the mower
	 *
	 * @param mower mower to animate
	 * @param row   input instructions
	 * @throws Exception  if the row is invalid
	 */
	private void executeInstructions(Mower mower, String row) throws Exception  {

		// Validate line
		Pattern p = Pattern.compile("^[ADG]*$");
		Matcher m = p.matcher(row);
		if (!m.matches()) {
			throw new Exception ("Invalid mower Instructions at line: " + row);
		}

		for (int index = 0; index < row.length(); index++) {
			char c = row.charAt(index);
			switch (c) {
				case 'A':
					mower.moveForward();
					break;

				case 'D':
					mower.rotateRight();
					break;

				case 'G':
					mower.rotateLeft();
					break;
			}
		}
	}
}
