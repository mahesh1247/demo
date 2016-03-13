package org.services;


import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Service
public class TaxServiceImpl implements TaxService {
  private  Map<String,String> salesTax;
  private Map<String,Double> stateTaxRates;
  
  @Autowired
	public TaxServiceImpl(@Value("${stateTaxRates.list}") String taxRateListStr) {
	   convertStringListToMap(taxRateListStr);
	}

	private void convertStringListToMap(String taxRateListStr) {
		salesTax = new HashMap<String, String>();
		String[] split = taxRateListStr.split(",");
		for (int i =0; i < split.length; i++) {
			String state = split[i];
			i = i+1;
			String tax = split[i];
			salesTax.put(state, tax);
		}
		
	}
  
  public Map<String, String> getSalesTax() {
		return salesTax;
	}

	public void setSalesTax(Map<String, String> salesTax) {
		this.salesTax = salesTax;
	}

	@Override
	public double computeTax(Order order) {
		String state = order.getCus().getState();
		double taxPercent = Double.valueOf(salesTax.get(state));
		double tax = (taxPercent * order.getSubtotal())/100;
		return tax; 
	
}
}