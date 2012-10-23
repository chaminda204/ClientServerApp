/**
 * 
 */
package org.remote.control.client.proxy;

import java.io.IOException;
import java.net.Socket;

/**
 * @author chamindaa
 * 
 *         date Oct 18, 2012
 */
public class SocketHandler {

	private Socket socket;
	private String serverHost;
	private int port;

	public SocketHandler() {
	}

	public SocketHandler(String serverHost, int port) {
		this.serverHost = serverHost;
		this.port = port;
	}

	public Socket getServerSocket() {

		if (socket == null) {
			createSocket();
		}
		return socket;
	}

	private void createSocket() {
		try {
			socket = new Socket(serverHost, port);
		} catch (IOException e) {
			throw new RuntimeException("Cannot create socket", e);
		}
	}

	public void setServerHost(String serverHost) {
		this.serverHost = serverHost;
	}

	public void setPort(int port) {
		this.port = port;
	}
}
