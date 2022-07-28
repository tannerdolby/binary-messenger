package com.binary.messenger;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.binary.messenger.BinaryMessenger;

public class MessengerService {
	protected static boolean messengerActive = true;
	public static HashMap<Integer, String> menuItems = new HashMap<>();
	public static HashMap<String, String> messages = new HashMap<>();
	
	public static void initMenu() {
		menuItems.put(1, "Type 'encode' to encode a string into its binary representation.");
		menuItems.put(2, "Type 'decode' to decode a binary string.");
		menuItems.put(3, "Type 'quit' to stop");
	}
	
	public static void main(String[] args) {
		BinaryMessenger messenger = new BinaryMessenger();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to the Binary Messenger!");
		initMenu();

		while (messengerActive) {
			// display menu options
			showMenu();

			String choice = scanner.nextLine();
			
			switch (choice) {
				case "encode":
					handleMessage(1, "Enter string to be encoded:", messenger, scanner);
					break;
				case "decode":
					handleMessage(2, "Enter binary string to be decoded:", messenger, scanner);
					break;
				case "quit":
					messengerActive = false;
					System.out.println("Shutting down messenger service. Thanks for stopping by!");
					break;
				default:
					System.out.println("Invalid choice '" + choice + "'. Try again!");
					continue;
			}
		}
		scanner.close();
	}
	
	public static void showMenu() {
		for (Map.Entry<Integer, String> entry : menuItems.entrySet()) {
			System.out.println(entry.getKey() + ". " + entry.getValue());
		}
	}

	public static void handleMessage(int menuItem, String menuText, BinaryMessenger messenger, Scanner scanner) {
		System.out.println(menuText);
		String s = scanner.nextLine();
		
		if (menuItem == 1) processMessage(s, messenger.stringToBinary(s));
		if (menuItem == 2) processMessage(s, messenger.decodeBinaryString(s));
	}
	
	public static void processMessage(String s, String res) {
		if (messages.containsKey(s)) {
			System.out.println(messages.get(s));
			return;
		}

		if (messages.containsValue(s)) {
			System.out.println(findKey(s));
			return;
		}

		System.out.println(res);
		messages.put(s, res);
	}
	
	public static String findKey(String val) {
		for (String key : messages.keySet()) {
			if (messages.get(key).equals(val)) {
				return key;
			}
		}
		return null;
	}
}
