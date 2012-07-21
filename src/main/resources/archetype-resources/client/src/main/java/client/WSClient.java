#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client;

import org.example.contract.doubleit.DoubleItPortType;
import org.example.contract.doubleit.DoubleItService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WSClient {

	private static final Logger logger = LoggerFactory.getLogger(WSClient.class);
	
	private DoubleItPortType port;
	
	public WSClient(DoubleItPortType port) {
		this.port = port;
	}
	
	public void doubleIt(int number) {
		logger.info("The double of {} is {}", number, port.doubleIt(number));
	}
	
	public static void main(String[] args) {
		DoubleItService service = new DoubleItService();
		DoubleItPortType port = service.getDoubleItPort();
		
		WSClient client = new WSClient(port);
		client.doubleIt(10);
		client.doubleIt(0);
		client.doubleIt(-20);

	}

}
