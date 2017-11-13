package com.robot.commands;

import com.robot.model.Robot;

public class InvalidCommand implements Command {

	public InvalidCommand() {
	}

	@Override
	public Robot execute() {
		return null;
	}

}
