package org.services;

import org.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class OrderProcessor {
	@Autowired
	private AccountingService acctService;
	@Autowired
	private InventoryService inventoryService;
		
	public OrderProcessor() {
	}
	public AccountingService getAcctService() {
		return acctService;
	}
	public void setAcctService(AccountingService acctService) {
		this.acctService = acctService;
	}
	public void newOrder(Order order) {
		double total = 0.0;
		double subTotal = 0.0;
		for (OrderItem orderItem : order.getOrderlist()) {
			subTotal = subTotal + (orderItem.getProd().getPrice() * orderItem.getQuantity());
		}
		order.setSubtotal(subTotal);
		double tax = acctService.computeTax(order);
		order.setTax(tax);
		total = subTotal +tax;
		order.setTotal(total);
		inventoryService.adjustInventory(order);		
	}
	public InventoryService getInventoryService() {
		return inventoryService;
	}
	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}	
}