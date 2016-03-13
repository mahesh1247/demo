package org.Aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.domain.Order;

@Aspect
public class OrderAspect {
	private static Logger log = Logger.getLogger(OrderAspect.class);
	
	@After("execution(* org.services.TaxService.computeTax(*)) and args(order)")
	public void afterComputeTax(Order order){
		
		//Object[] args = jp.getArgs();
		//Order order = (Order) args[0];
		
		if(order.getCus().getState().equals("CA")){
		log.info("After execution------------------------------+++++++++++++++++++++++"+order.getCus().getState());
		}
	}
	
	 @Around("execution(* org.services.OrderProcessor.newOrder(..))")
	    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
	       Long time = System.currentTimeMillis();
	        Object retVal = pjp.proceed();
	       log.info("Time taken to complete the order in millis ----  "+(System.currentTimeMillis()-time));
	        return retVal;
	    }
}
