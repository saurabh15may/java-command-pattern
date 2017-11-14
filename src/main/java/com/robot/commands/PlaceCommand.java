package com.robot.commands;

import com.robot.model.Direction;
import com.robot.model.Robot;
import com.robot.model.Table;

public class PlaceCommand implements Command {

	private Robot robot;
	int positionX;
	int positionY;
	int faceDirection;

	public PlaceCommand(Robot robot, int positionX, int positionY, int faceDirection) {
		this.robot = robot;
		this.positionX = positionX;
		this.positionY = positionY;
		this.faceDirection = faceDirection;
	}

	@Override
	public boolean execute() {
		boolean isSuccess = robot != null ? isValidPlaceCommand() : false;
		if (isSuccess) {
			robot.reset();
			robot.setPositionX(positionX);
			robot.setPositionY(positionY);
			robot.setFaceDirection(faceDirection);
			robot.setActive(true);
		}
		return isSuccess;
	}

	public boolean isValidPlaceCommand() {
		return (-1 < positionX && positionX < Table.WIDTH.getSize())
				&& (-1 < positionY && positionY < Table.LENGTH.getSize())
				&& (-1 < faceDirection && faceDirection < Direction.values().length) ? true : false;
	}

}
