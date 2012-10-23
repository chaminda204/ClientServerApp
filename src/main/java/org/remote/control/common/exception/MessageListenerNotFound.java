/**
 * 
 */
package org.remote.control.common.exception;

/**
 * @author Chaminda
 * 
 *         Created Sep 29, 2012
 */
public class MessageListenerNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 592766892257870418L;

	/**
	 * empty constructor.
	 */
	public MessageListenerNotFound() {

	}

	/**
	 * constructor with error message.
	 * 
	 * @param message
	 *            -Error description of the exception.
	 */
	public MessageListenerNotFound(final String message) {
		super(message);
	}

	/**
	 * Constructor with error description and cause.
	 * 
	 * @param message
	 *            -Error description of the exception.
	 * @param cause
	 *            -Exception that caused the issue.
	 */
	public MessageListenerNotFound(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor with error description and cause.
	 * 
	 * @param cause
	 *            -Exception that caused the issue.
	 */
	public MessageListenerNotFound(Throwable cause) {
		super(cause);
	}

}
