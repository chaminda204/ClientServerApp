/**
 * 
 */
package org.remote.control.common;

import java.util.ArrayList;
import java.util.List;

/**
 * This class holds the data related to computation.
 * 
 * @author Chaminda
 * 
 *         Created Sep 28, 2012
 */
public class ComputeMessage extends StringMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 171126724407056762L;
	/**
	 * Holds the numbers for calculation.
	 */
	private List<Double> numbers;

	/**
	 * Constructor which initializes the array.
	 */
	public ComputeMessage() {
		numbers = new ArrayList<Double>();
	}

	/**
	 * Getter method for getNumbers
	 * 
	 * @return the numbers of type List<Long>
	 */
	public List<Double> getNumbers() {
		return numbers;
	}

	/**
	 * Setter method for setNumbers
	 * 
	 *@param numbers
	 *            to set numbers
	 */
	public void setNumbers(List<Double> numbers) {
		this.numbers = numbers;
	}

}
