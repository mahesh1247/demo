package org.services;

import org.domain.Order;
import org.springframework.stereotype.Service;

@Service
public interface TaxService {
	public double computeTax(Order order);
}
