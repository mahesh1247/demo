package org.services;
import org.domain.*;
import org.springframework.stereotype.Service;
@Service
public interface InventoryService {
	public void adjustInventory(Order order);
	void printCurrentInventory();
}
