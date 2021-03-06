package com.robot.commands;

import com.robot.model.Robot;

public class MoveCommand implements Command {

	private Robot robot;

	public MoveCommand(Robot robot) {
		this.robot = robot;
	}

	@Override
	public boolean execute() {
		boolean isSuccess = robot != null ? (robot.isActive() ? isValidMoveCommand() : false) : false;
		if (isSuccess) {
			switch (robot.getFaceDirection()) {// NORTH-0, EAST-1, SOUTH-2, WEST-3
			case 0:
				robot.setPositionY(robot.getPositionY() + 1);
				break;

			case 1:
				robot.setPositionX(robot.getPositionX() + 1);
				break;

			case 2:
				robot.setPositionY(robot.getPositionY() - 1);
				break;

			case 3:
				robot.setPositionX(robot.getPositionX() - 1);
				break;

			default:
				isSuccess = false;
				break;
			}
		}
		return isSuccess;
	}

	public boolean isValidMoveCommand() {

		Robot temp = new Robot(robot.getPositionX(), robot.getPositionY(), robot.getFaceDirection());

		switch (robot.getFaceDirection()) {
		case 0:
			temp.setPositionY(robot.getPositionY() + 1);
			return temp.isValidPositionY();

		case 1:
			temp.setPositionX(robot.getPositionX() + 1);
			return temp.isValidPositionX();

		case 2:
			temp.setPositionY(robot.getPositionY() - 1);
			return temp.isValidPositionY();

		case 3:
			temp.setPositionX(robot.getPositionX() - 1);
			return temp.isValidPositionX();

		default:
			return false;

		}

	}
}
