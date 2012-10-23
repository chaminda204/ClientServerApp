/**
 * 
 */
package org.remote.control.server.listener.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.remote.control.client.util.LogManager;
import org.remote.control.common.ComputeMessage;
import org.remote.control.common.listener.MessageListener;

/**
 * This class deals with computing messages.
 * 
 * @author Chaminda
 * 
 *         Created Sep 28, 2012
 */
public final class ComputeMessageListener implements MessageListener<ComputeMessage> {

	/**
	 * Logger instance.
	 */
	private static final Logger log = LogManager.getLogger(ComputeMessageListener.class.getName());

	/**
	 * This operation will add the numbers that client is passing and returns
	 * the sum.
	 * 
	 * @param ComputeMessageTest
	 *            contains numbers to be processed.
	 * @return ComputeMessage contains the processed message.
	 */
	public ComputeMessage onMessage(final ComputeMessage message) {

		final List<Double> numbers = message.getNumbers();

		double total = 0.00;

		if (null != numbers && !numbers.isEmpty()) {
			for (double number : numbers) {
				total += number;
			}
		}
		message.setReply(String.valueOf(total));

		log.log(Level.INFO, "Message sent by - " + message.getClientName() + " Sent command - " + message.getMessage());
		log.log(Level.INFO, "Server responded for " + message.getMessage() + " Command : " + message.getReply());

		return message;
	}

}
