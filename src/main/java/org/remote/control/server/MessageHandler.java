/**
 * 
 */
package org.remote.control.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.remote.control.client.util.LogManager;
import org.remote.control.common.AbstractMessage;
import org.remote.control.common.exception.GISCommunicationException;
import org.remote.control.common.listener.MessageListener;
import org.remote.control.server.listener.MessageListenerFactory;

/**
 * This class deals with connections and allocate a new thread for incoming
 * requests.
 * 
 * @author Chaminda
 * 
 *         Created Sep 28, 2012
 */
public final class MessageHandler implements Runnable {

	private static final Logger log = LogManager.getLogger(MessageHandler.class.getName());

	private Socket socket;

	public MessageHandler(Socket socket) {
		this.socket = socket;
	}

	/**
	 * This operation will be dealing with user inputs.
	 */
	public void run() {

		try {

			// Read a message sent by clients

			final ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

			final Object message = ois.readObject();

			AbstractMessage reply = null;

			if (message instanceof AbstractMessage) {

				AbstractMessage abstractMessage = (AbstractMessage) message;

				MessageListener listener = MessageListenerFactory.getListenerInstance(abstractMessage.getClass()
						.getSimpleName());
				reply = listener.onMessage(abstractMessage);

			} else {
				//System.out.println("Unknown message type");
				log.log(Level.INFO, "Unknown message type");
			}

			// Send a response information to the client application

			final ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(reply);

			ois.close();
			oos.close();
			socket.close();

			System.out.println("Waiting for client message...");
		} catch (IOException e) {
			throw new GISCommunicationException("Communication Error", e);
		} catch (ClassNotFoundException e) {
			throw new GISCommunicationException("Communication Error", e);
		}
	}

	public void process() {

		new Thread(this).start();

	}

}