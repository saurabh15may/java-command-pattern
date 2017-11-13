package com.robot.commands;

import com.robot.model.Robot;

public class MoveCommand implements Command {

	private Robot robot;

	public MoveCommand(Robot robot) {
		this.robot = robot;
	}

	@Override
	public Robot execute() {
		return robot;

	}

}
