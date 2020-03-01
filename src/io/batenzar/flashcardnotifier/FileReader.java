package io.batenzar.flashcardnotifier;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class FileReader {

	public static List<String> getFileContent(String file) {
		try {
			return Files.readAllLines(Paths.get(file));
		} catch (IOException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
}
