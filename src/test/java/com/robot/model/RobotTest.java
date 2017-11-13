package com.robot.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RobotTest {

	@Test
	public void positionXisValid() {
		Robot robot = new Robot();

		robot.setPositionX(0);
		assertTrue(robot.isValidPositionX());

		robot.setPositionX(4);
		assertTrue(robot.isValidPositionX());
	}

	@Test
	public void positionXisInValid() {
		Robot robot = new Robot();

		robot.setPositionX(-1);
		assertFalse(robot.isValidPositionX());

		robot.setPositionX(5);
		assertFalse(robot.isValidPositionX());
	}

	@Test
	public void positionYisValid() {
		Robot robot = new Robot();

		robot.setPositionY(0);
		assertTrue(robot.isValidPositionY());

		robot.setPositionY(4);
		assertTrue(robot.isValidPositionY());
	}

	@Test
	public void positionYisInValid() {
		Robot robot = new Robot();

		robot.setPositionY(-1);
		assertFalse(robot.isValidPositionY());

		robot.setPositionY(5);
		assertFalse(robot.isValidPositionY());
	}

	@Test
	public void faceDirectionIsValid() {
		Robot robot = new Robot();

		robot.setFaceDirection(0);
		assertTrue(robot.isValidFaceDirection());

		robot.setFaceDirection(3);
		assertTrue(robot.isValidFaceDirection());
	}

	@Test
	public void faceDirectionIsInValid() {
		Robot robot = new Robot();

		robot.setFaceDirection(-1);
		assertFalse(robot.isValidFaceDirection());

		robot.setFaceDirection(4);
		assertFalse(robot.isValidFaceDirection());
	}

	@Test
	public void toStringIsValid() {
		Robot robot = new Robot();
		robot.setPositionX(0);
		robot.setPositionY(0);
		robot.setFaceDirection(0);

		assertTrue(robot.isValidToString());
	}

	@Test
	public void toStringIsInValid() {
		Robot robot = new Robot();
		robot.setPositionX(0);
		robot.setPositionY(0);
		robot.setFaceDirection(0);

		assertNotEquals(robot.toString(), robot.getPositionX() + " " + robot.getPositionY() + " "
				+ robot.getDirections()[robot.getFaceDirection()]);
	}
}
