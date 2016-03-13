package org.services;

import org.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AccountingServiceImpl implements AccountingService {
	@Autowired
    private TaxService taxService;
    
	public TaxService getTaxService() {
		return taxService;
	}

	public void setTaxService(TaxService taxService) {
		this.taxService = taxService;
	}
	
	
	public double computeTax(Order order) {
		// TODO Auto-generated method stub
		return taxService.computeTax(order);
	}
	


	
}
