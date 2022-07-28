package com.binary.messenger;

import java.util.HashMap;

class BinaryMessenger {

	/**
	 * Convert a string to its binary string representation.
	 * 
	 * @param word an input string.
	 * @return a binary string containing all the bits represented by each character
	 *         from the input string.
	 */
	public String stringToBinary(String s) {
		String binaryStr = "";
		for (Character ch : s.toCharArray()) {
			binaryStr += leftPad(binaryString(ch.charValue()), 8) + " ";
		}
		return binaryStr.trim();
	}

	/**
	 * Convert a binary string in base 2 to its original character.
	 * 
	 * @param binaryCodePointStr
	 * @return
	 */
	public String binaryCodePointToString(String binaryCodePointStr) {
		return Character.toString((byte) Integer.parseInt(binaryCodePointStr, 2));
	}

	/**
	 * Decode a binary string.
	 * 
	 * @param binaryWord a string of bits.
	 * @return the decoded binary string as a normal string.
	 */
	public String decodeBinaryString(String binaryStr) {
		String s = "";
		for (String letter : binaryStr.split(" ")) {
			s += binaryCodePointToString(letter);
		}
		return s;
	}

	/**
	 * Convert a byte to its binary string representation.
	 * 
	 * @param b an input byte
	 * @return binary string representation of the input byte
	 */
	public String binaryString(byte b) {
		return Integer.toBinaryString(b);
	}

	/**
	 * Convert an integer to its binary string representation. Note: leading zeroes
	 * are not included, use toBits(T val) instead.
	 * 
	 * @param num an input integer value.
	 * @return binary string representation of the input integer.
	 */
	public String binaryString(int num) {
		return Integer.toBinaryString(num);
	}
	
	/**
	 * Get a HashMap with the maximum values for each bit of the specified bit
	 * width.
	 * 
	 * @param width bit width.
	 */
	public HashMap<Integer, Integer> getPotentialBits(int width) {
		HashMap<Integer, Integer> bitMap = new HashMap<>();
		for (int i = width; i >= 0; i--) {
			bitMap.put(i, (int) Math.pow(2, i));
		}
		return bitMap;
	}

	/**
	 * Show the maximum values for each bit of the specified bit width in console.
	 * 
	 * @param width bit width.
	 */
	public void showPotentialBits(int width) {
		for (int i = width; i >= 0; i--) {
			System.out.print((int) Math.pow(2, i) + " ");
		}
		System.out.println();
	}

	// Format a binary string by n-bit widths and left pad the binary string with
	// zeroes
	public String leftPad(String s, int width) {
		return String.format("%" + width + "s", s).replace(' ', '0');
	}

	// 1 byte default
	/**
	 * Create a byte string consisting of 8 bits.
	 * @param b input byte
	 * @return a string representing the byte
	 */
	public String toBinary(byte b) {
		return leftPad(binaryString(byteToInt(b)), 8);
	}

	/**
	 * Create a byte string consisting of 8 bits.
	 * @param b input byte.
	 * @return a string representing the byte.
	 */
	public String toBinary(int n) {
		return leftPad(binaryString(byteToInt((byte) n)), 8);
	}

	/**
	 * Create a binary string representing a byte consisting of `width` bits. 
	 * @param b input byte.
	 * @param width bit width.
	 * @return a string representing the byte.
	 */
	public String toBinary(byte b, int width) {
		return leftPad(binaryString(byteToInt(b)), width);
	}

	/**
	 * Create a byte string consisting of 8 bits.
	 * @param b input byte.
	 * @param width bit width.
	 * @return a string representing the byte.
	 */
	public String toBinary(int n, int width) {
		return leftPad(binaryString(byteToInt((byte) n)), width);
	}
	
	/**
	 * Convert a signed <code>byte</code> to a unsigned <code>int</code>.<br>
	 * <br>
	 * 
	 * Example:<br>
	 * byte b = 3;<br>
	 * <code>// b & 0xFF = 00000011 & 11111111 = 00000011</code>
	 * 
	 * <br>
	 * <br>
	 * 
	 * <code>
	 * 0000 0011<br>
	 * 1111 1111<br>
	 * <code>---------</code><br>
	 * 0000 0011 </code>
	 * 
	 * @param b an input byte.
	 * @return integer representation of the input byte.
	 */
	public int byteToInt(byte b) {
		return b & 0xFF;
	}
}
