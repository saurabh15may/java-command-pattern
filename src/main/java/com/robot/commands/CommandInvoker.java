package com.robot.commands;

import java.util.ArrayList;
import java.util.List;

public class CommandInvoker {

	private List<Command> robotCommands = new ArrayList<Command>();
	private List<String> commandExecutionLog = new ArrayList<String>();

	public void receiveCommands(Command command) {
		robotCommands.add(command);
	}

	public List<String> executeCommands() {
		for (Command command : robotCommands) {
			commandExecutionLog.add(command.execute() == null ? "IGNORED" : "SUCCESSFUL");
		}
		return commandExecutionLog;
	}

}
