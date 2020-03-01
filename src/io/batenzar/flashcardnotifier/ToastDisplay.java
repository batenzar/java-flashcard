package io.batenzar.flashcardnotifier;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;

public class ToastDisplay {

	private static TrayIcon trayIcon;
	static {
		Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
		trayIcon = new TrayIcon(image, "Tray Demo");
		trayIcon.setImageAutoSize(true);
		trayIcon.setToolTip("System tray icon tooltip");

		SystemTray tray = SystemTray.getSystemTray();
		try {
			tray.add(trayIcon);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static void displayTray(String title, String message) throws AWTException {
		trayIcon.displayMessage(title, message, MessageType.INFO);
	}
}
