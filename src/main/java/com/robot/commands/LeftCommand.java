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
		if (robot != null ? isValidLeftCommand() : false) {
			if (robot.getFaceDirection() == 0)
				robot.setFaceDirection(3);
			else
				robot.setFaceDirection(robot.getFaceDirection() - 1);
			return robot;
		} else {
			return null;
		}

	}

	public boolean isValidLeftCommand() {
		return true;
	}

}
