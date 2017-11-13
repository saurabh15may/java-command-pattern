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

public class RobotSimulator {

	static Robot robot = null;
	static ArrayList<String> userCommands = new ArrayList<String>();

	public static void main(String[] args) {

		if (args[0] != null) {

			readUserCommandInputsFromFile(args[0]);

			List<String> commandExecutionLog = validateAndExecuteCommands();

			System.out.println("\n\n******** Commands execution steps *********");
			for (int i = 0; i < userCommands.size(); i++) {
				System.out.println(userCommands.get(i) + ": " + commandExecutionLog.get(i));
			}
		}

	}

	private static void readUserCommandInputsFromFile(String filename) {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String curentLine;
			while ((curentLine = br.readLine()) != null) {
				userCommands.add(curentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static List<String> validateAndExecuteCommands() {
		String status = null;
		CommandInvoker invoker = new CommandInvoker();

		// Loop through all the userCommands and Validate & Execute
		for (String cparam : userCommands) {
			String command = cparam;

			if (UserCommandInputValidator.isPlaceCommand(cparam))
				command = "PLACE";

			switch (command) {

			case "PLACE":
				// The first PLACE command creates the actual Robot Object and assigns it to the
				// global reference
				robot = new Robot();
				PlaceCommand placeCommand = UserCommandInputValidator.isValidPlaceCommand(cparam, robot);
				if (placeCommand != null) {
					invoker.receiveCommands(placeCommand);
				}
				break;

			case "MOVE":
				MoveCommand moveCommand = new MoveCommand(robot);
				invoker.receiveCommands(moveCommand);
				break;

			case "LEFT":
				LeftCommand leftCommand = new LeftCommand(robot);
				invoker.receiveCommands(leftCommand);
				break;

			case "RIGHT":
				RightCommand rightCommand = new RightCommand(robot);
				invoker.receiveCommands(rightCommand);
				break;

			case "REPORT":
				ReportCommand reportCommand = new ReportCommand(robot);
				invoker.receiveCommands(reportCommand);
				break;

			default:
				InvalidCommand invalidCommand = new InvalidCommand();
				invoker.receiveCommands(invalidCommand);
				break;
			}

			// commandExecutionStatus.add(status);
		}
		List<String> commandExecutionLog = invoker.executeCommands();

		return commandExecutionLog;
	}
}
