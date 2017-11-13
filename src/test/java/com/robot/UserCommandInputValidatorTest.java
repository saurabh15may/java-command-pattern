package com.robot;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.robot.commands.PlaceCommand;
import com.robot.model.Robot;

public class UserCommandInputValidatorTest {

	@Test
	public void PLACECommandIsValid() {
		Robot robot = new Robot();
		PlaceCommand placeCommand = new PlaceCommand(robot, 0, 0, 0);

		assertTrue(placeCommand.execute() != null);
	}
}
