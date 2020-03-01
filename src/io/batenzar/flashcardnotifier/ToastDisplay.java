package io.batenzar.flashcardnotifier;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;

public class ToastDisplay {

	public static void displayTray(String title, String message) throws AWTException {
		Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
		TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
		trayIcon.setImageAutoSize(true);
		trayIcon.setToolTip("System tray icon tooltip");

		SystemTray tray = SystemTray.getSystemTray();
			tray.add(trayIcon);
		
		trayIcon.displayMessage(title, message, MessageType.INFO);
	}
}
