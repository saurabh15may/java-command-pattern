package com.robot.model;

public enum Table {

	LENGTH(5), WIDTH(5);

	private final int size;

	Table(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}

}
