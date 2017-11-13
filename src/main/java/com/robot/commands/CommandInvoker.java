package com.robot.commands;

import java.util.ArrayList;
import java.util.List;

public class CommandInvoker {

	private List<Command> robotCommands = new ArrayList<Command>();

	public void receiveCommands(Command command) {
		robotCommands.add(command);
	}

	public void executeCommands() {
		for (Command command : robotCommands) {
			command.execute();
		}
	}

}
