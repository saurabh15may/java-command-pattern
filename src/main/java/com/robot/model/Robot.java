package com.robot.model;

public class Robot {

	private int positionX;

	private int positionY;

	private int faceDirection;

	private Direction Directions[] = { Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST };

	public Robot() {
	}

	public Robot(int positionX, int positionY, int faceDirection) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
		this.faceDirection = faceDirection;
	}

	@Override
	public String toString() {
		return positionX + "," + positionY + "," + Directions[faceDirection];
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public int getFaceDirection() {
		return faceDirection;
	}

	public void setFaceDirection(int faceDirection) {
		this.faceDirection = faceDirection;
	}

	public Direction[] getDirections() {
		return Directions;
	}

	public boolean isValidPositionX() {
		return -1 < positionX && positionX < Table.WIDTH.getSize();
	}

	public boolean isValidPositionY() {
		return -1 < positionY && positionY < Table.LENGTH.getSize();
	}

	public boolean isValidFaceDirection() {
		return -1 < faceDirection && faceDirection < Direction.values().length;
	}

}
