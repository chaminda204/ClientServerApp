/**
 * 
 */
package org.remote.control.common;

/**
 * @author Chaminda
 * 
 *         Created Sep 30, 2012
 */
public class Constants {

	// Common constants

	/**
	 * Constant for validating "say hello" user input.
	 */
	public static final String SAY_HELLO = "say hello";

	/**
	 * Constant for validating "say goodbye" user input.
	 */
	public static final String SAY_GOODBYE = "say goodbye";

	/**
	 * Separator value comma.
	 */
	public static final String SEPARATOR_COMMA = ",";

	// Client constants

	/**
	 * Constant for validating SUM user input.
	 */
	public static final String OPTION_SUM = "sum";

	/**
	 * Constant for validating Exit user input.
	 */
	public static final String OPTION_EXIT = "0";
	/**
	 * Holds the property file location information.
	 */
	public static final String CLIENT_CONFIG_PROPERTIES_FILE_PATH = "clientConfig.properties";

	// Server constants

	/**
	 * Holds the static logger instance and this will be returned when Logger is
	 * requested.
	 */
	public static final String SERVER_LOG_LOCATION = "server.log";

	/**
	 * Holds the property key for sever port.
	 */
	public static final String SERVER_PORT = "server.port";

	/**
	 * Location of the server config property file.
	 */
	public static final String SERVER_CONFIG_PROPERTY_LOCATION = "serverConfig.properties";

	/**
	 * Holds the property key for listeners.
	 */
	public static final String SERVER_LISTENER_REGISTRY = "server.listener.registry";

	/**
	 * Holds the listener config property file location.
	 */
	public static final String LISTENER_CONFIG_PROPERTY_LOCATION = "listenerConfig.properties";

}
