/**
 * 
 */
package org.remote.control;

import org.remote.control.client.application.ClientUIApplication;
import org.remote.control.server.Server;

/**
 * This is the starting point of the application.
 * 
 * @author Chaminda
 * 
 *         Created Sep 30, 2012
 */
public class Bootstrap {

	/**
	 * Entry point of the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String runAs = System.getProperty("runAs");

		if ("server".equals(runAs)) {
			new Server().startServer();
		} else if ("client".equals(runAs)) {
			new ClientUIApplication().start();
		} else {
			printUsage();
		}
	}

	private static void printUsage() {
		System.out
				.println("To run as server:  java -DrunAs=server -Dport=8080 toll-gis.jar");
		System.out
				.println("To run as client:  java -DrunAs=client -DserverIp=10.0.0.1 -Dport=8080 toll-gis.jar");
	}
}
