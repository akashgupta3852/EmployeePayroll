package com.bridgelabz.employeepayroll;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.BeforeClass;
import org.junit.Test;

public class WatchServiceDemoTest {
	private static String HOME, PLAY_WITH_NIO;

	@BeforeClass
	public static void intialize() {
		HOME = System.getProperty("user.home");
		PLAY_WITH_NIO = "TempPlayGround";
	}

	@Test
	public void givenADirectory_WhenWatched_ListAllTheActivities() throws IOException {
		Path dir = Paths.get(HOME + "/" + PLAY_WITH_NIO);
		new WatchServiceDemo(dir).processEvents();
	}
}