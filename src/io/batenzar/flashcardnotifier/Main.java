package io.batenzar.flashcardnotifier;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Simple notifier. 
 * This class will loop infinitely to display notification at specified intervals (in seconds).
 * 
 * @author batenzar
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		// load properties
		Properties prop = new Properties();
		prop.load(new FileInputStream("config.properties"));
		String data = prop.getProperty("data", "./data.txt");
		int period = Integer.parseInt(prop.getProperty("interval", "30"));

		// read data file
		List<String> fileContent = FileReader.getFileContent(data);
		Runnable r = new Runnable() {

			@Override
			public void run() {
				int randomIdx = new Random().nextInt(fileContent.size());
				try {
					ToastDisplay.displayTray("Flash Card", fileContent.get(randomIdx));
				} catch (AWTException e) {
					e.printStackTrace();
				}
			}
		};

		// start scheduling
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.scheduleAtFixedRate(r, 3, period, TimeUnit.SECONDS);
	}

}
