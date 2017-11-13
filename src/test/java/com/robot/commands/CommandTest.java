package com.robot.commands;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.robot.model.Robot;

public class CommandTest {

	@Test
	public void PLACECommandIsValid() {
		Robot robot = new Robot();
		PlaceCommand pCommand = new PlaceCommand(robot, 0, 0, 0);

		assertTrue(pCommand.execute() != null);
	}

	@Test
	public void PLACECommandIsInValid() {
		Robot robot = new Robot();
		PlaceCommand pCommand = new PlaceCommand(robot, -1, 5, 4);

		assertTrue(pCommand.execute() != null);
	}

	@Test
	public void REPORTCommandIsValid() {
		Robot robot = new Robot(0, 0, 0);
		ReportCommand rCommand = new ReportCommand(robot);

		assertTrue(rCommand.execute() != null);
	}

	@Test
	public void REPORTCommandIsInValid() {
		Robot robot = new Robot(-1, 0, 0);
		ReportCommand rCommand = new ReportCommand(robot);

		assertTrue(rCommand.execute() != null);
	}

	@Test
	public void MOVECommandIsValid() {
	}

	@Test
	public void MOVECommandIsInValid() {
	}

	@Test
	public void LEFTCommandIsValid() {
	}

	@Test
	public void LEFTCommandIsInValid() {
	}

	@Test
	public void RIGHTCommandIsValid() {
	}

	@Test
	public void RIGHTCommandIsInValid() {
	}

}
