/**
 *
 */
package org.remote.control.client.proxy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.remote.control.common.AbstractMessage;
import org.remote.control.common.StringMessage;

/**
 * @author chamindaa
 * 
 *         date Oct 18, 2012
 */
public class MessageServiceProxyTest {

	@InjectMocks
	MessageServiceProxy proxy;

	@Mock
	SocketHandler mockedSocketHandler;

	@Mock
	RequestHandler mockedRequestHandler;

	@Mock
	ResponseHandler mockedResponseHandler;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		proxy = new MessageServiceProxy();
		initMocks(this);
	}

	@Test
	public void testOnMessage() throws IOException {

		Socket mockedSocket = mock(Socket.class);
		ObjectOutputStream outputStream = mock(ObjectOutputStream.class);

		// Given
		AbstractMessage msg = getRequest();
		given(mockedSocketHandler.getServerSocket()).willReturn(mockedSocket);
		given(mockedRequestHandler.makeRequest(mockedSocket, msg)).willReturn(
				outputStream);
		given(mockedResponseHandler.readResponse(mockedSocket)).willReturn(
				getExpectedResponse());

		// When
		AbstractMessage response = proxy.onMessage(msg);

		// Then
		assertNotNull(response);
		assertEquals("Hello Chaminda", response.getReply());
		verify(mockedRequestHandler).closeSafely(outputStream);
	}

	private AbstractMessage getRequest() {
		StringMessage msg = new StringMessage();
		msg.setClientName("Chaminda");
		msg.setMessage("Say Hello");
		return msg;
	}

	private AbstractMessage getExpectedResponse() {
		AbstractMessage msg = new StringMessage();
		msg.setClientName("Chaminda");
		msg.setReply("Hello Chaminda");
		return msg;
	}

}
