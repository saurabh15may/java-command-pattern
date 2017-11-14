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

		assertTrue(placeCommand.execute());
	}

	@Test
	public void PLACECommandIsInValid() {
		Robot robot = new Robot();
		PlaceCommand placeCommand = new PlaceCommand(robot, -1, 5, 4);

		assertFalse(placeCommand.execute());
	}

	@Test
	public void REPORTCommandIsValid() {
		Robot robot = new Robot(0, 0, 0);
		robot.setActive(true);
		ReportCommand reportCommand = new ReportCommand(robot);

		assertTrue(reportCommand.execute());
	}

	@Test
	public void REPORTCommandIsInValid() {
		Robot robot = new Robot(0, 0, 0);
		robot.setActive(false);
		ReportCommand reportCommand = new ReportCommand(robot);

		assertFalse(reportCommand.execute());
	}

	@Test
	public void MOVECommandIsValid() {
		Robot robot = new Robot(0, 0, 0);
		robot.setActive(true);
		MoveCommand moveCommand = new MoveCommand(robot);

		assertTrue(moveCommand.execute());

		robot = new Robot(3, 3, 0);
		robot.setActive(true);
		moveCommand = new MoveCommand(robot);

		assertTrue(moveCommand.execute());
	}

	@Test
	public void MOVECommandIsInValid() {
		Robot robot = null;
		MoveCommand moveCommand = new MoveCommand(robot);

		assertFalse(moveCommand.execute());

		robot = new Robot(4, 4, 0);
		moveCommand = new MoveCommand(robot);

		assertFalse(moveCommand.execute());
	}

	@Test
	public void LEFTCommandIsValid() {
		Robot robot = new Robot(0, 0, 0);
		robot.setActive(true);
		LeftCommand leftCommand = new LeftCommand(robot);

		assertTrue(leftCommand.execute());
	}

	@Test
	public void LEFTCommandIsInValid() {
		Robot robot = null;
		LeftCommand leftCommand = new LeftCommand(robot);

		assertFalse(leftCommand.execute());

		robot = new Robot(0, 0, 0);
		robot.setActive(false);
		leftCommand = new LeftCommand(robot);

		assertFalse(leftCommand.execute());
	}

	@Test
	public void RIGHTCommandIsValid() {
		Robot robot = new Robot(0, 0, 0);
		robot.setActive(true);
		RightCommand rightCommand = new RightCommand(robot);

		assertTrue(rightCommand.execute());
	}

	@Test
	public void RIGHTCommandIsInValid() {
		Robot robot = null;
		RightCommand rightCommand = new RightCommand(robot);

		assertFalse(rightCommand.execute());

		robot = new Robot(0, 0, 0);
		robot.setActive(false);
		rightCommand = new RightCommand(robot);

		assertFalse(rightCommand.execute());
	}

}
