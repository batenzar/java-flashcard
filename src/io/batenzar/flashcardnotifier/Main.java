package io.batenzar.flashcardnotifier;

import java.awt.AWTException;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) throws Exception {
		String data = "./data.txt";
		if (args.length == 1) {
			data = args[0];
		}
		
		// read data file
		List<String> fileContent = FileReader.getFileContent(data);
		int randomIdx = new Random().nextInt(fileContent.size());
		try {
			ToastDisplay.displayTray("Flash Card", fileContent.get(randomIdx));
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		System.exit(0);
	}

}
