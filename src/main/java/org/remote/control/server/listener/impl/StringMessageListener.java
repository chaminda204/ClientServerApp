/**
 * 
 */
package org.remote.control.server.listener.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.remote.control.client.util.LogManager;
import org.remote.control.common.Constants;
import org.remote.control.common.StringMessage;
import org.remote.control.common.listener.MessageListener;

/**
 * This class is responsible for processing string messages.
 * 
 * @author Chaminda
 * 
 *         Created Sep 28, 2012
 */
public final class StringMessageListener implements MessageListener<StringMessage> {

	/**
	 * Logger Instance.
	 */
	private static final Logger log = LogManager.getLogger(StringMessageListener.class.getName());

	/**
	 * This operation will process the String messages coming from the client.
	 * 
	 * @param StringMessage
	 *            contains String message to be processed.
	 * @return StringMessage contains the processed message.
	 */
	public StringMessage onMessage(final StringMessage message) {

		if (message.getMessage() != null) {

			StringBuilder reply = null;

			if (message.getMessage().equalsIgnoreCase(Constants.SAY_HELLO)) {
				reply = new StringBuilder("Hello ").append((message.getClientName()));
				message.setReply(reply.toString());

				logMessage(message);

			} else if (message.getMessage().equalsIgnoreCase(Constants.SAY_GOODBYE)) {
				reply = new StringBuilder("Bye ").append((message.getClientName()));
				message.setReply(reply.toString());
				log.info(reply.toString());

			} else {
				log.info("Invalid Command");
			}
		}

		return message;

	}

	/*
	 * Logging the message.
	 */
	private void logMessage(final StringMessage message) {
		log.log(Level.INFO, "Message sent by - " + message.getClientName() + " Sent command - " + message.getMessage());
		log.log(Level.INFO, "Server responded for " + message.getMessage() + " Command : " + message.getReply());

	}

}
