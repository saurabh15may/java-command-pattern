package com.robot.commands;

import com.robot.model.Robot;

public class RightCommand implements Command {

	private Robot robot;

	public RightCommand(Robot robot) {
		super();
		this.robot = robot;
	}

	@Override
	public Robot execute() {
		return robot;

	}

}
