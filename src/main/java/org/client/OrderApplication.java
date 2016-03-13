package org.client;
import org.apache.log4j.Logger;
import org.domain.*;
import org.services.AccountingService;
import org.services.InventoryService;
import org.services.InventoryServiceImpl;
import org.services.OrderProcessor;
import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderApplication {
	private static Logger log = Logger.getLogger(OrderApplication.class);
	public static void main(String args[]) {
		Customer customer = new Customer("Devi", 15255, "CA");
		Product product1 = new Product("LapTap",10.0);
		OrderItem orderItem = new OrderItem(product1, 8);
		Product product2 = new Product("DeskTops",20.0);
		OrderItem orderItem1 = new OrderItem(product2, 4);
		Order order = new Order("Order-1", customer);
		order.addItem(orderItem);
		order.addItem(orderItem1);
		ApplicationContext container = new ClassPathXmlApplicationContext("application.xml");
		log.info("Before processing order::::::::::::::::");
		InventoryService inventoryService = (InventoryService) container.getBean(InventoryService.class);
		OrderProcessor orderProcessor = (OrderProcessor) container.getBean(OrderProcessor.class);
		log.info("orderItems in the order being processed: ");
		for (OrderItem orderItems : order.getOrderlist()) {
			log.info("ItemDetails{" + "product - " + orderItems.getProd().getName() + ", quantity- " + orderItems.getQuantity() + "}");
		}
		orderProcessor.newOrder(order);
		log.info("order tax- " + order.getTax() + ", order subTotal- " + order.getSubtotal() + ", orderTotal- " + order.getTotal());
		log.info("After Processing Order: ");
		((ClassPathXmlApplicationContext) container).close(); 
		
	}
}
