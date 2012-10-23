/**
 * 
 */
package org.remote.control.common;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * @author chamindaa
 * 
 * date Oct 18, 2012
 */
public class ComputeMessageTest {
	
	private ComputeMessage computeMsg ;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUpBeforeClass() throws Exception {
		computeMsg = new ComputeMessage();
		
	}

	@Test
	public void setAndGetMessage() {
		computeMsg.setMessage("Hello");
		Assert.assertEquals("Hello", computeMsg.getMessage());
	}
	
	@Test
	public void setAndGetClientName() {
		computeMsg.setClientName("Chaminda");
		Assert.assertEquals("Chaminda", computeMsg.getClientName());
	}
	
	@Test
	public void setAndGetNumbers() {
		computeMsg.setNumbers(new ArrayList<Double>());
		Assert.assertNotNull(computeMsg.getNumbers());
	}
	
	@Test
	public void setAndGetReply() {
		computeMsg.setReply("HELLO Chaminda");
		Assert.assertEquals("HELLO Chaminda", computeMsg.getReply());
	}

}
