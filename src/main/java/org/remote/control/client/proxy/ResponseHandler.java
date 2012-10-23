/**
 * 
 */
package org.remote.control.client.proxy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.remote.control.common.AbstractMessage;
import org.remote.control.common.exception.GISCommunicationException;

/**
 * @author chamindaa
 * 
 * date Oct 18, 2012
 */
public class ResponseHandler {
	 /**
     * Logger instance.
     */
    private static final Logger log = Logger.getLogger(ResponseHandler.class.getName());

    /*
      * reading the server response.
      */
    public AbstractMessage readResponse(Socket socket) {

        ObjectInputStream inputStream = null;
        AbstractMessage serverReply = null;

        try {
            inputStream = new ObjectInputStream(socket.getInputStream());
            serverReply = (AbstractMessage) inputStream.readObject();
            // System.out.println("SERVER RESPONDED: " +
            // serverReply.getReply());

        } catch (IOException e) {
            log.log(Level.INFO, "Exception occurred while sending and receiving messages");
            throw new RuntimeException("Exception occurred while sending and receiving messages", e);

        } catch (ClassNotFoundException e) {
            log.log(Level.INFO, "Exception occurred while  receiving messages");
            throw new RuntimeException("Exception occurred while  receiving messages", e);

        } finally {
            closeSafely(inputStream);
        }

        return serverReply;
    }

    /*
      * closing the outputStream.
      */
    private void closeSafely(final ObjectInputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                throw new GISCommunicationException("Communication Error",e);
            }
        }
    }
}
