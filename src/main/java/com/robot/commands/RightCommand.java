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
		if (robot != null ? isValidRightCommand() : false) {
			if (robot.getFaceDirection() == 3)
				robot.setFaceDirection(0);
			else
				robot.setFaceDirection(robot.getFaceDirection() + 1);
			return robot;
		} else {
			return null;
		}

	}

	public boolean isValidRightCommand() {
		return true;
	}

}
