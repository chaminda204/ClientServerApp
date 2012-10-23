/**
 * 
 */
package org.remote.control.client.proxy;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.remote.control.common.AbstractMessage;
import org.remote.control.common.listener.MessageListener;

/**
 * @author Chaminda
 * 
 *         Created Sep 28, 2012
 */
public class MessageServiceProxy implements MessageListener {

	/**
	 * Logger instance.
	 */
	private static final Logger log = Logger.getLogger(MessageServiceProxy.class.getName());

	/**
	 * Socket instance to be connected.
	 */
	private SocketHandler socketHandler;

    private RequestHandler requestHandler;

    private ResponseHandler responseHandler;

    public MessageServiceProxy() {
    }

    public MessageServiceProxy(SocketHandler socketHandler, RequestHandler requestHandler, ResponseHandler responseHandler) {
        this.socketHandler = socketHandler;
        this.requestHandler = requestHandler;
        this.responseHandler = responseHandler;
    }

    /**
	 * On message operation of the proxy and this deals with sending and
	 * receiving requests .
	 * 
	 * @param message
	 *            to be sent to the server.
	 * @return AbstractMessage reply from the server.
	 */
	public AbstractMessage onMessage(final AbstractMessage message) {
        Socket socket = socketHandler.getServerSocket();
		ObjectOutputStream outStream = requestHandler.makeRequest(socket, message);
		AbstractMessage response = responseHandler.readResponse(socket);
        requestHandler.closeSafely(outStream);
        log.log(Level.INFO, "Respnce received");
		return response;
	}

    public void setSocketHandler(final SocketHandler socketHandler) {
        this.socketHandler = socketHandler;
    }

    public void setRequestHandler(final RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public void setResponseHandler(final ResponseHandler responseHandler) {
        this.responseHandler = responseHandler;
    }
}
