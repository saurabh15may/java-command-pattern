package com.robot.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public enum UserCommand {
	PLACE, REPORT, MOVE, LEFT, RIGHT, INVALID;

	public static String[] getCommandNames() {
		return Stream.of(UserCommand.values()).map(UserCommand::name).toArray(String[]::new);
	}

	public static List<String> getCommandList() {
		return Arrays.asList(getCommandNames());
	}
}
