package com.robot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.robot.commands.CommandInvoker;
import com.robot.commands.InvalidCommand;
import com.robot.commands.LeftCommand;
import com.robot.commands.MoveCommand;
import com.robot.commands.PlaceCommand;
import com.robot.commands.ReportCommand;
import com.robot.commands.RightCommand;
import com.robot.model.Robot;
import com.robot.model.UserCommand;

public class RobotSimulator {

	static Robot robot = new Robot();
	static PlaceCommand placeCommand = null;
	static ArrayList<String> userCommands = new ArrayList<String>();

	public static void main(String[] args) {
		try {
			// Programs takes one argument - filename
			if (args[0] != null) {
				// Read commands from file
				readUserCommandInputsFromFile(args[0]);

				// Execute commands
				List<String> commandExecutionLog = validateAndExecuteCommands();

				if (args.length == 2 ? args[1].equals("--log") : false)
					printExecutionLog(commandExecutionLog);
			}
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
			e.printStackTrace();
		}

	}

	private static void readUserCommandInputsFromFile(String filename) {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String curentLine;
			while ((curentLine = br.readLine()) != null) {
				userCommands.add(curentLine.trim());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static List<String> validateAndExecuteCommands() {
		CommandInvoker invoker = new CommandInvoker();

		// Loop through all the userCommands and prepare the List of Command
		// Objects to be invoked later in sequence
		for (String command : userCommands) {
			UserCommand uCommand = isValidRobotCommand(command) ? UserCommand.valueOf(command)
					: (isValidPlaceCommand(command) ? UserCommand.PLACE : UserCommand.INVALID);

			switch (uCommand) {
			case PLACE:
				invoker.receiveCommands(placeCommand);
				break;

			case MOVE:
				invoker.receiveCommands(new MoveCommand(robot));
				break;

			case LEFT:
				invoker.receiveCommands(new LeftCommand(robot));
				break;

			case RIGHT:
				invoker.receiveCommands(new RightCommand(robot));
				break;

			case REPORT:
				invoker.receiveCommands(new ReportCommand(robot));
				break;

			default:
				invoker.receiveCommands(new InvalidCommand());
				break;
			}
		}
		// The invoker executes all the commands and return the execution log
		return invoker.executeCommands();
	}

	public static boolean isValidRobotCommand(String command) {
		if (command.contains("PLACE"))
			command += "X";
		return UserCommand.getCommandList().contains(command);
	}

	public static boolean isValidPlaceCommand(String command) {
		boolean isValid = false;
		try {
			if (command.contains(" ")) {
				String[] tokens = command.split(" ");
				if (tokens[0].equals("PLACE") && tokens.length == 2) {
					String[] tparams = tokens[1].split(",");
					if (tparams.length == 3) {
						int positionX = Integer.parseInt(tparams[0].trim());
						int positionY = Integer.parseInt(tparams[1].trim());
						String fDirection = tparams[2].trim();
						int faceDirection = fDirection.equals("NORTH") ? 0
								: (fDirection.equals("EAST") ? 1
										: (fDirection.equals("SOUTH") ? 2 : (fDirection.equals("WEST") ? 3 : -1)));

						PlaceCommand pCommand = new PlaceCommand(robot, positionX, positionY, faceDirection);
						isValid = pCommand.isValidPlaceCommand();
						if (isValid)
							placeCommand = pCommand;
					}
				}
			}
		} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
			isValid = false;
			e.printStackTrace();
		}
		return isValid;
	}

	private static void printExecutionLog(List<String> commandExecutionLog) {
		System.out.println("\n\n*********** Commands Execution log ************");
		for (int i = 0; i < userCommands.size(); i++) {
			System.out.println(userCommands.get(i) + ": " + commandExecutionLog.get(i));
		}
	}

}
