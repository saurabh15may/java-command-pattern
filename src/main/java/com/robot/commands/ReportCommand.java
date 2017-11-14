package com.robot.commands;

import com.robot.model.Robot;

public class ReportCommand implements Command {

	private Robot robot;

	public ReportCommand(Robot robot) {
		this.robot = robot;
	}

	@Override
	public boolean execute() {
		boolean isSuccess = robot != null ? (robot.isActive() ? robot.isValidToString() : false) : false;

		if (isSuccess)
			System.out.println(robot);

		return isSuccess;
	}

}
