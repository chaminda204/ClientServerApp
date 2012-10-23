/**
 *
 */
package org.remote.control.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.remote.control.client.util.LogManager;
import org.remote.control.client.util.ServerPropertyContextLoader;

/**
 * @author Chaminda
 *         
 *         Created Sep 27, 2012
 */
public final class Server {

    /**
     * Logger instance for logging.
     */
    private static final Logger log = LogManager.getLogger(Server.class.getName());

    /**
     * ServerSocket class instance.
     */
    private ServerSocket server;

    public Server() {

        try {
            ServerPropertyContextLoader contextLoader = ServerPropertyContextLoader.getInstance();
            server = new ServerSocket(contextLoader.getPort());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Starts the server and return the status.
     */
    public void startServer() {

        handleConnection();

    }

    private void handleConnection() {
        log.log(Level.INFO, "Ready to process client requests");

        // The server do a loop here to accept all connection initiated by the
        // client application.

        while (true) {
            try {

                final Socket socket = server.accept();
                new MessageHandler(socket).process();

            } catch (IOException e) {
                log.log(Level.SEVERE, "IOException occured when creating the connection ");
            }
        }
    }
}
