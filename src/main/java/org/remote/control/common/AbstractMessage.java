/**
 * 
 */
package org.remote.control.common;

import java.io.Serializable;

/**
 * This class will be extended by all the message classes.
 * 
 * @author Chaminda
 * 
 *         Created Sep 28, 2012
 */
public abstract class AbstractMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Reply to the client.
	 */
	private String reply;

	/**
	 * Client name.
	 */
	private String clientName;

	/**
	 * Getter method for getClientName
	 * 
	 * @return the clientName of type String
	 */
	public String getClientName() {
		return clientName;
	}

	/**
	 * Setter method for setClientName
	 * 
	 *@param clientName
	 *            to set clientName
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 * Getter method for getReply
	 * 
	 * @return the reply of type String
	 */
	public String getReply() {
		return reply;
	}

	/**
	 * Setter method for setReply
	 * 
	 *@param reply
	 *            to set reply
	 */
	public void setReply(String reply) {
		this.reply = reply;
	}

}
