package com.robot.commands;

import com.robot.model.Robot;

public class LeftCommand implements Command {

	private Robot robot;

	public LeftCommand(Robot robot) {
		super();
		this.robot = robot;
	}

	@Override
	public Robot execute() {
		return robot;

	}

}
