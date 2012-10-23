/**
 * 
 */
package org.remote.control.common.exception;

/**
 * @author Chaminda
 * 
 *         Created Oct 1, 2012
 */
public class GISCommunicationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4766005828583347510L;

	/**
	 * empty constructor.
	 */
	public GISCommunicationException() {

	}

	/**
	 * constructor with error message.
	 * 
	 * @param message
	 *            -Error description of the exception.
	 */
	public GISCommunicationException(final String message) {
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
	public GISCommunicationException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor with error description and cause.
	 * 
	 * @param cause
	 *            -Exception that caused the issue.
	 */
	public GISCommunicationException(Throwable cause) {
		super(cause);
	}

}
