/**
 *
 */
package org.remote.control.server.listener;

import org.remote.control.client.util.ServerPropertyContextLoader;
import org.remote.control.common.exception.MessageListenerNotFound;
import org.remote.control.common.listener.MessageListener;

/**
 * @author Chaminda
 * 
 *         Created Sep 28, 2012
 */
public final class MessageListenerFactory {

	/**
	 * Private constructor.
	 */
	private MessageListenerFactory() {
	}

	/**
	 * Returns the factory instance.
	 * 
	 * @param className
	 *            to get the relevant listener,
	 * @return MessageListener for the given class.
	 */
	public static MessageListener getListenerInstance(final String className) {

		if (isRegisteredListener(className)) {
			return getMessageListenerClass(className);
		}

		throw new MessageListenerNotFound();
	}

	/*
	 * 
	 */
	private static boolean isRegisteredListener(final String className) {
		return ServerPropertyContextLoader.getInstance().containsProperty(
				className);
	}

	/*
	 * Returns the instance of the requested message listener.
	 */
	private static MessageListener getMessageListenerClass(
			final String className) {
		try {
			return (MessageListener) Class.forName(getListener(className))
					.newInstance();
		} catch (Exception e) {
			throw new MessageListenerNotFound(e);
		}
	}

	private static String getListener(final String className) {
		return ServerPropertyContextLoader.getInstance().getProperty(className);
	}

}
