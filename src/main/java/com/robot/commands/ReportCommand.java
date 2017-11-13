package com.robot.commands;

import com.robot.model.Robot;

public class ReportCommand implements Command {

	private Robot robot;

	public ReportCommand(Robot robot) {
		this.robot = robot;
	}

	@Override
	public Robot execute() {
		if (robot.isValidToString()) {
			System.out.println(robot);
			return robot;
		} else {
			return null;
		}

	}

}
