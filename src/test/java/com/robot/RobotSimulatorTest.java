package com.robot;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RobotSimulatorTest {

	@Test
	public void UserCommandInputIsValid() {
		assertTrue(RobotSimulator.isValidRobotCommand("REPORT"));
		assertTrue(RobotSimulator.isValidRobotCommand("MOVE"));
		assertTrue(RobotSimulator.isValidRobotCommand("LEFT"));
		assertTrue(RobotSimulator.isValidRobotCommand("RIGHT"));
	}

	@Test
	public void UserPLACECommandInputIsValid() {
		assertTrue(RobotSimulator.isValidPlaceCommand("PLACE 0,0,NORTH"));
		assertTrue(RobotSimulator.isValidPlaceCommand("PLACE 1,1,EAST"));
		assertTrue(RobotSimulator.isValidPlaceCommand("PLACE 2,2,WEST"));
		assertTrue(RobotSimulator.isValidPlaceCommand("PLACE 3,3,SOUTH"));
		assertTrue(RobotSimulator.isValidPlaceCommand("PLACE 4,4,NORTH"));
	}

	@Test
	public void UserCommandInputIsInValid() {
		assertFalse(RobotSimulator.isValidRobotCommand("FLY"));
		assertFalse(RobotSimulator.isValidRobotCommand("JUMP"));
		assertFalse(RobotSimulator.isValidRobotCommand("REPORT 123"));
		assertFalse(RobotSimulator.isValidRobotCommand("LEFT 50"));
		assertFalse(RobotSimulator.isValidRobotCommand("10 RIGHT"));
		assertFalse(RobotSimulator.isValidRobotCommand("MOVE 10"));
		assertFalse(RobotSimulator.isValidRobotCommand("NORTH"));
	}

	@Test
	public void UserPLACECommandInputIsInValid() {
		assertFalse(RobotSimulator.isValidPlaceCommand("PLACE"));
		assertFalse(RobotSimulator.isValidPlaceCommand("PLACE 5"));
		assertFalse(RobotSimulator.isValidPlaceCommand("PLACE 1,1"));
		assertFalse(RobotSimulator.isValidPlaceCommand("PLACE 0,0,SKY"));
		assertFalse(RobotSimulator.isValidPlaceCommand("PLACE -1,-1,SOUTH"));
		assertFalse(RobotSimulator.isValidPlaceCommand("PLACE 5,5,NORTH"));
		assertFalse(RobotSimulator.isValidPlaceCommand("PLACE -1,0,NORTH"));
		assertFalse(RobotSimulator.isValidPlaceCommand("PLACE 0,-1,EAST"));
		assertFalse(RobotSimulator.isValidPlaceCommand("PLACE 0,0,NORTH 0"));
		assertFalse(RobotSimulator.isValidPlaceCommand("PLACE 0,0,WEST B"));
		assertFalse(RobotSimulator.isValidPlaceCommand("PLACE 0,0,EAST 1"));
		assertFalse(RobotSimulator.isValidPlaceCommand("PLACE 0,0,WEST 2"));

	}
}
