package demo;

import org.domain.Customer;
import org.domain.Order;
import org.domain.OrderItem;
import org.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.services.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:**/application.xml" })
public class TaxServiceTest {
	
	@Autowired 
	private TaxService taxservice;
	private Order order= null;

	@Before
	public void setup(){
		Customer customer = new Customer("Devi", 15255, "CA");
		Product product1 = new Product("LapTap",10.0);
		OrderItem orderItem = new OrderItem(product1, 8);
		Product product2 = new Product("DeskTops",20.0);
		OrderItem orderItem1 = new OrderItem(product2, 4);
		order = new Order("Order-1", customer);
		order.addItem(orderItem);
		order.addItem(orderItem1);
	}
	
	@Test
	public void testComputeService(){
		taxservice.computeTax(order);
	}
	

}
