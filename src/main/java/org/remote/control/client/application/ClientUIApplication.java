/**
 * 
 */
package org.remote.control.client.application;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.remote.control.client.proxy.MessageServiceProxy;
import org.remote.control.client.proxy.RequestHandler;
import org.remote.control.client.proxy.ResponseHandler;
import org.remote.control.client.proxy.SocketHandler;
import org.remote.control.common.AbstractMessage;
import org.remote.control.common.ComputeMessage;
import org.remote.control.common.Constants;
import org.remote.control.common.StringMessage;

/**
 * This class deals with starting the application and will be dealing with the
 * client inputs.
 * 
 * @author Chaminda
 * 
 *         Created Sep 28, 2012
 */
public class ClientUIApplication {

	/**
	 * Name of the client is stored in the static variable.
	 */
	private String clientName, serverIp, serverPort;

	/**
	 * Main method that initiates the application (Command line)
	 * 
	 */
	public void start() {

		System.out.println("****************  Welcome Client Server Communication ****************");

		serverIp = CommandReader.read("Please enter server IP address: ");
		serverPort = CommandReader.read("Please enter server port      : ");
		// do {
		clientName = CommandReader.read("Please enter your name : ");
		System.out.println("****************  Welcome " + clientName + " ****************");

		// } while ("".equals(clientName));

		runCommand();

		CommandReader.close();
		System.out.println("****************** Good Bye " + clientName + " ****************");

	}

	/**
	 * This operation handles user inputs until user is chosen to exit from the
	 * application.
	 */
	public void runCommand() {
		printHelp();

		String command;
		do {
			command = CommandReader.read("Please enter your choice : ");

			AbstractMessage entity = null;

			if (Constants.SAY_HELLO.equalsIgnoreCase(command) || Constants.SAY_GOODBYE.equalsIgnoreCase(command)) {
				entity = getStringMessage(command);

			} else if (command.length() > 3 && command.substring(0, 3).equalsIgnoreCase(Constants.OPTION_SUM)) {
				entity = extractInputDataForSumOperation(command);

			} else {
				// This is an invalid command.
				printHelp();
			}

			if (entity != null) {
				MessageServiceProxy proxy = new MessageServiceProxy(
                        new SocketHandler(serverIp, getServerPort(serverPort)),
                        new RequestHandler(),
                        new ResponseHandler());

                AbstractMessage reply = proxy.onMessage(entity);
                System.out.println("Server responded " + reply.getReply());
			}
		} while (!Constants.OPTION_EXIT.equals(command));
	}
    
	private int getServerPort(String port) {
        return Integer.parseInt(port);
    }
	/*
	 * Creates a new StringMessage and returns the created object.
	 */
	private StringMessage getStringMessage(final String command) {
		StringMessage stringMessage = new StringMessage();
		stringMessage.setClientName(clientName);
		stringMessage.setMessage(command);
		return stringMessage;
	}

	/*
	 * This method takes string data for sum operation and will be converting
	 * them in to a list of double values. If the format is invalid, it will
	 * prompt again for next input.
	 */
	private AbstractMessage extractInputDataForSumOperation(final String command) {

		ComputeMessage message = null;
		final List<Double> numbers = new ArrayList<Double>();
		;

		// Extracting the string input and break in to numbers for calculation.
		final StringTokenizer token = new StringTokenizer(command.substring(3), Constants.SEPARATOR_COMMA);

		while (token.hasMoreElements()) {

			try {

				numbers.add(Double.parseDouble(token.nextElement().toString().trim()));

			} catch (NumberFormatException e) {
				System.out.println("Invalid Input, Please try again");
				printHelpForSum();
			}

		}

		// TODO useBuilder for creation
		if (!numbers.isEmpty()) {
			message = new ComputeMessage();
			message.setClientName(clientName);
			message.setNumbers(numbers);
			message.setMessage(command);

		}

		return message;
	}

	/*
	 * Displays the available options for the user.
	 */
	private void printHelp() {

		System.out.println("Following are the input choices.");
		System.out.println("SAY HELLO TO SERVER COMMAND : SAY HELLO");
		System.out.println("SAY GOODBYE TO SERVER COMMAND : SAY GOODBYE");
		System.out.println("CALCULATE ASSISTANCE COMMAND : SUM <NUM1>,<NUM2>,<NUM3> etc.");
		System.out.println("EXIT THE APPLICATION COMMAND : 0");
	}

	/*
	 * Displays an example of how SUM command should be used in the application.
	 */
	private void printHelpForSum() {

		System.out.println("Example of sum command: SUM 10, 44.45, 20");

	}

}
