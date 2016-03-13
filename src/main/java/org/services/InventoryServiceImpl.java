package org.services;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.domain.Order;
import org.domain.OrderItem;
import org.domain.Product;
import org.apache.log4j.*;
import org.springframework.stereotype.Service;
@Service
public class InventoryServiceImpl implements InventoryService{
	
	Map<String, OrderItem> inventoryMap = new HashMap<String, OrderItem>();
	private Logger log = Logger.getLogger(InventoryServiceImpl.class);
	@PostConstruct
	public void initializeInventory() {
		inventoryMap.put("LapTap",new OrderItem(new Product("LapTap",10.0), 50));
		inventoryMap.put("DeskTops",new OrderItem(new Product("DeskTops",20.0), 100));
		inventoryMap.put("Ipads",new OrderItem(new Product("Ipads",15.0), 150));
		System.out.println("At the time of post construct");
		for(String items : inventoryMap.keySet()) {
			log.info("product name: " + items + ", quantity: " + inventoryMap.get(items).getQuantity() + ", price: " + inventoryMap.get(items).getProd().getPrice());
		}
	}

	@Override
	public void adjustInventory(Order order) {
		for(OrderItem o : order.getOrderlist()) {
			int totalQuantity = inventoryMap.get(o.getProd().getName()).getQuantity();
			int quantity = o.getQuantity();
			int remainingQuantity = totalQuantity - quantity;
			inventoryMap.get(o.getProd().getName()).setQuantity(remainingQuantity);
		}
		
	}
	
	@PreDestroy
	public void printCurrentInventory() {
		log.info("At the time of destroying");
		for(String items : inventoryMap.keySet()) {
			log.info("product name: " + items + ", quantity: " + inventoryMap.get(items).getQuantity() + ", price: " + inventoryMap.get(items).getProd().getPrice());
		}
	}

}
