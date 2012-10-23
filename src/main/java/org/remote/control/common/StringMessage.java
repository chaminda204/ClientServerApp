/**
 * 
 */
package org.remote.control.common;

/**
 * Class to handle String messages sent to the server.
 * 
 * @author Chaminda
 * 
 *         Created Sep 28, 2012
 */
public class StringMessage extends AbstractMessage {

	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = -2280433476437336737L;

	/**
	 * Message that the client sent. 
	 */
	private String message;

	/**
	 * Getter method for getMessage
	 * 
	 * @return the message of type String
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Setter method for message
	 * 
	 *@param message
	 *            to set message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
