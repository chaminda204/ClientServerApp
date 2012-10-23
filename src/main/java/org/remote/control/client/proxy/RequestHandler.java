/**
 * 
 */
package org.remote.control.client.proxy;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.remote.control.common.AbstractMessage;

/**
 * @author chamindaa
 * 
 * date Oct 18, 2012
 */
public class RequestHandler {
    /*
     * Sending the request and returning the outputstream to be closed safely.
     */
   public ObjectOutputStream makeRequest(Socket socket, final AbstractMessage requestMessage) {
       ObjectOutputStream outputStream = null;

       try {
           outputStream = new ObjectOutputStream(socket.getOutputStream());
           outputStream.writeObject(requestMessage);
       } catch (IOException e) {
           throw new RuntimeException("Cannot write to socket", e);
       }

       return outputStream;
   }

   /*
     * closing the inputStream.
     */
   public void closeSafely(final ObjectOutputStream outputStream) {
       if (outputStream != null) {
           try {
               outputStream.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
   }
}
