/**
 * 
 */
package org.remote.control.client.util;

import static org.remote.control.common.Constants.SERVER_CONFIG_PROPERTY_LOCATION;
import static org.remote.control.common.Constants.SERVER_PORT;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Chaminda
 * 
 *         Created Sep 30, 2012
 */
public class ServerPropertyContextLoader {

	/**
	 * System properties instance.
	 */
	private final Properties SERVER_CONTEXT = new Properties();

	private static ServerPropertyContextLoader instance;

	/**
	 * Get instance operation.
	 * 
	 * @return ServerPropertyContextLoader instance.
	 */
	public static ServerPropertyContextLoader getInstance() {
		if (instance == null) {
			instance = new ServerPropertyContextLoader();
		}

		return instance;
	}

	private ServerPropertyContextLoader() {
		initContext();
	}

	private void initContext() {
		try {
			loadListenersContext();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void loadListenersContext() throws IOException {
		final InputStream fis = getClass().getClassLoader()
				.getResourceAsStream(SERVER_CONFIG_PROPERTY_LOCATION);
		SERVER_CONTEXT.load(fis);
		closeListenersContext(fis);
	}

	private void closeListenersContext(final InputStream fis)
			throws IOException {
		if (fis != null) {
			fis.close();
		}
	}

	public boolean containsProperty(final String propKey) {
		return SERVER_CONTEXT.containsKey(propKey);
	}

	/**
	 * returning properties for given key.
	 * 
	 * @param propKey
	 *            to retrieve the property.
	 * @return String value of the property.
	 */
	public String getProperty(final String propKey) {
		return (String) SERVER_CONTEXT.get(propKey);
	}

	/**
	 * 
	 * @return Port of the server.
	 */
	public int getPort() {
		return Integer.parseInt(getProperty(SERVER_PORT));
	}
}
