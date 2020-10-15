package com.bridgelabz.employeepayroll;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class NIOFileAPITest {
	private static String HOME, PLAY_WITH_NIO;

	@BeforeClass
	public static void intialize() {
		HOME = System.getProperty("user.home");
		PLAY_WITH_NIO = "TempPlayGround";
	}

	@Test
	public void givenPathWhenCheckedThenConfirm() throws IOException {
		// Checking file existence
		Path homePath = Paths.get(HOME);
		Assert.assertTrue(Files.exists(homePath));

		// Deleting file
		Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
		if (Files.exists(playPath))
			FileUtils.deleteFiles(playPath.toFile());
		Assert.assertTrue(Files.notExists(playPath));

		// Creating directory
		Files.createDirectory(playPath);
		Assert.assertTrue(Files.exists(playPath));

		// Creating file
		IntStream.range(1, 10).forEach(fileNum -> {
			Path tempFile = Paths.get(playPath + "/temp" + fileNum);
			Assert.assertTrue(Files.notExists(tempFile));
			try {
				Files.createFile(tempFile);
			} catch (IOException e) {
				System.out.println("Message- " + e.getMessage());
			}
			Assert.assertTrue(Files.exists(tempFile));
		});
	}
}