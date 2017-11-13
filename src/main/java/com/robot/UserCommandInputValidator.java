package com.robot;

import com.robot.commands.PlaceCommand;
import com.robot.model.Robot;

public class UserCommandInputValidator {

	protected static PlaceCommand isValidPlaceCommand(String command, Robot robot) {
		// System.out.println(command + " : " + isPlaceCommand(command));
		if (isPlaceCommand(command)) {
			String[] tokens = command.split(" ");
			String[] tparams = tokens[1].split(",");
			int positionX = Integer.parseInt(tparams[0].trim());
			int positionY = Integer.parseInt(tparams[1].trim());
			String fDirection = tparams[2].trim();
			int faceDirection = fDirection.equals("NORTH") ? 0
					: (fDirection.equals("EAST") ? 1
							: (fDirection.equals("SOUTH") ? 2 : (fDirection.equals("WEST") ? 3 : -1)));

			PlaceCommand placeCommand = new PlaceCommand(robot, positionX, positionY, faceDirection);
			return placeCommand.isValidPlaceCommand() ? placeCommand : null;

		} else {
			return null;
		}
	}

	protected static boolean isPlaceCommand(String command) {
		if (command.contains(" ")) {
			String[] tokens = command.split(" ");
			// System.out.println(tokens[0]);
			return tokens[0].equals("PLACE");
		} else {
			return false;
		}
	}
}
