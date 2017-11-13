package com.robot.commands;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.robot.model.Robot;

public class CommandTest {

	@Test
	public void PLACECommandIsValid() {
		Robot robot = new Robot();
		PlaceCommand placeCommand = new PlaceCommand(robot, 0, 0, 0);

		assertTrue(placeCommand.execute() != null);
	}

	@Test
	public void PLACECommandIsInValid() {
		Robot robot = new Robot();
		PlaceCommand placeCommand = new PlaceCommand(robot, -1, 5, 4);

		assertFalse(placeCommand.execute() != null);
	}

	@Test
	public void REPORTCommandIsValid() {
		Robot robot = new Robot(0, 0, 0);
		ReportCommand reportCommand = new ReportCommand(robot);

		assertTrue(reportCommand.execute() != null);
	}

	@Test
	public void REPORTCommandIsInValid() {
		Robot robot = null;
		ReportCommand reportCommand = new ReportCommand(robot);

		assertFalse(reportCommand.execute() != null);
	}

	@Test
	public void MOVECommandIsValid() {
		Robot robot = new Robot(0, 0, 0);
		MoveCommand moveCommand = new MoveCommand(robot);
		assertTrue(moveCommand.execute() != null);

		robot = new Robot(3, 3, 0);
		moveCommand = new MoveCommand(robot);
		assertTrue(moveCommand.execute() != null);
	}

	@Test
	public void MOVECommandIsInValid() {
		Robot robot = null;
		MoveCommand moveCommand = new MoveCommand(robot);
		assertFalse(moveCommand.execute() != null);

		robot = new Robot(4, 4, 0);
		moveCommand = new MoveCommand(robot);

		assertFalse(moveCommand.execute() != null);
	}

	@Test
	public void LEFTCommandIsValid() {
		Robot robot = new Robot(0, 0, 0);
		LeftCommand leftCommand = new LeftCommand(robot);

		assertTrue(leftCommand.execute() != null);
	}

	@Test
	public void LEFTCommandIsInValid() {
		Robot robot = null;
		LeftCommand leftCommand = new LeftCommand(robot);

		assertFalse(leftCommand.execute() != null);
	}

	@Test
	public void RIGHTCommandIsValid() {
		Robot robot = new Robot(0, 0, 0);
		RightCommand rightCommand = new RightCommand(robot);

		assertTrue(rightCommand.execute() != null);
	}

	@Test
	public void RIGHTCommandIsInValid() {
		Robot robot = null;
		RightCommand rightCommand = new RightCommand(robot);

		assertFalse(rightCommand.execute() != null);
	}

}
