/**
 * 
 */
package org.remote.control.client.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class is responsible for reading command line inputs and returning what
 * user has entered.
 * 
 * @author Chaminda
 * 
 *         Created Sep 28, 2012
 */
public class CommandReader {

	/**
	 * Static instance of BufferedReader;
	 */
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Read operation for user input. Also, the prompt will be displayed to
	 * assist to get desired user input.
	 * 
	 * @param prompt
	 *            to be displayed for the user.
	 * @return userInput what the user has entered.
	 */
	public static String read(final String prompt) {
		try {
			System.out.println();
			System.out.print(prompt);
			return reader.readLine().trim();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Closing the reader.
	 */
	public static void close() {
		try {
			reader.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
