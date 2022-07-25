package com.binary.messenger;

import java.util.Scanner;

import com.binary.messenger.BinaryMessenger;

public class MessengerService {
	protected static boolean messengerActive = true;

	public static void main(String[] args) {
		BinaryMessenger messenger = new BinaryMessenger();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the Binary Messenger!");

		while (messengerActive) {
			// Options:
			// 1. Encode a string as its binary string representation
			// 2. Decode a binary string representation to the original string
			// 3. Stop the service
			System.out.println("1. Type 'encode' to encode a string into its binary representation:");
			System.out.println("2. Type 'decode' to decode a binary string:");
			System.out.println("3. Type 'quit' to stop");

			String choice = scanner.nextLine();
			
			switch (choice) {
				case "encode":
					System.out.println("Enter string to be encoded:");
					System.out.println(messenger.stringToBinary(scanner.nextLine()));
					break;
				case "decode":
					System.out.println("Enter binary string to be decoded:");
					System.out.println(messenger.decodeBinaryString(scanner.nextLine()));
					break;
				case "quit":
					messengerActive = false;
					System.out.println("Shutting down messenger service. Thanks for stopping by!");
					break;
				default:
					System.out.println("Invalid choice! Shutting down messenger service.");
					messengerActive = false;
					break;
			}
		}
		scanner.close();
	}
}
