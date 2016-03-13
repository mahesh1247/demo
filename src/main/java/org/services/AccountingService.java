package org.services;
import org.domain.*;
import org.springframework.stereotype.Service;
@Service
public interface AccountingService {

	public double computeTax(Order order);
}
