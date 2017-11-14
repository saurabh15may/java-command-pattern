package com.robot.commands;

public class InvalidCommand implements Command {

	public InvalidCommand() {
	}

	@Override
	public boolean execute() {
		return false;
	}

}
