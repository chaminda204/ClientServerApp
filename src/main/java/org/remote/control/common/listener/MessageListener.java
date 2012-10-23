/**
 * 
 */
package org.remote.control.common.listener;

import org.remote.control.common.AbstractMessage;

/**
 * Message Listener class that takes Entity as a parameter.
 * 
 * @author Chaminda
 * 
 *         Created Sep 28, 2012
 */
public interface MessageListener<T extends AbstractMessage> {

	/**
	 * This operation will be invoked when message is received.
	 * 
	 * @param T
	 *            contains any class extends Entity.
	 * @return T contains any class extends Entity.
	 */
	T onMessage(T message);

}
