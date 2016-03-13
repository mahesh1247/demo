package demo;
import org.domain.Customer;
import org.domain.Order;
import org.domain.OrderItem;
import org.domain.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.services.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:**/application.xml" })
public class TestOrder {
	private Order order= null;
	OrderItem orderItem1 = null;

	@Before
	public void setup(){
		Customer customer = new Customer("Devi", 15255, "CA");
		Product product1 = new Product("LapTap",10.0);
		OrderItem orderItem = new OrderItem(product1, 8);
		Product product2 = new Product("DeskTops",20.0);
		 orderItem1 = new OrderItem(product2, 4);
		order = new Order("Order-1", customer);
		
	}
	@Test
	public void testaddItem(){
		order.addItem(orderItem1);
	}
	@Test(expected=NullPointerException.class)
	public void testaddItemException(){
		order.addItem(null);
	}
}
