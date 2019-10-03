package com.learn.graph;

import java.util.ArrayList;
import java.util.List;

public class Project {

	String val;
	Boolean visited;
	State state = State.BLANK;

	public enum State {
		COMPLETE, PARTIAL, BLANK
	};

	List<String> adjacentNodes = new ArrayList<String>();

	public Project(String data) {
		val = data;
	}

}
