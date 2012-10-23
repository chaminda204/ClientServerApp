/**
 * 
 */
package org.remote.control.client.util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.remote.control.common.Constants;

/**
 * @author Chaminda
 * 
 *         Created Sep 29, 2012
 */
public class LogManager {

	

	/**
	 * Private constructor.
	 */
	private LogManager() {

	}

	/**
	 * Logger instance to be returned.
	 */
	private static Logger logger;

	/**
	 * Returns the logger instance.
	 * 
	 * @param clazz
	 *            logging class.
	 * @return Logger instance for logging.
	 */
	public static Logger getLogger(final String clazz) {

		if (logger == null) {
			logger = getLoggerInstance(clazz);
		}

		return logger;
	}

	/**
	 * 
	 * @param clazz
	 * @return
	 */
	private static Logger getLoggerInstance(final String clazz) {
		Logger logger = null;
		
		try {
			final FileHandler handler = new FileHandler(Constants.SERVER_LOG_LOCATION);
			final SimpleFormatter formatter = new SimpleFormatter();
			handler.setFormatter(formatter);
			logger = Logger.getLogger(clazz);
			logger.addHandler(handler);

		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return logger;
	}

}
