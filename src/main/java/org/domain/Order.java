package org.domain;
import java.util.ArrayList;

import org.domain.OrderItem;

public class Order {
	private String code;
	private Customer cus;
	private ArrayList<OrderItem> orderlist=new ArrayList<OrderItem>();
	private Double subtotal;
	private Double tax;
	private Double total;
	
	public Order(String code, Customer customer) {
		this.code = code;
		this.cus =customer;
	}
	
	public ArrayList<OrderItem> getOrderlist() {
		return this.orderlist;
	}
	public void setOrderList(ArrayList<OrderItem> al){
		this.orderlist=al;
	}
	
	public Order(String newOrderCode) {
		setCode(newOrderCode);
	}
	public void addItem(OrderItem additem) {
		   boolean hasit=false;
		   int index = 0;
			for (OrderItem orderItem : orderlist) {
				if (orderItem.getProd().equals(additem.getProd())) {
					hasit = true;
					break;
				}
				index++;
				
			}
			if (hasit) {
				OrderItem orderItem = orderlist.get(index);
				orderItem.setQuantity(orderItem.getQuantity() + additem.getQuantity());
			} else {
				this.orderlist.add(additem);
			}
		calsubtotal();	
			
	}
	public void calsubtotal() {
		Double stotal=0.0;
		for(OrderItem o: orderlist){
			stotal=stotal+(o.getProd().getPrice() * o.getQuantity());
		}
		this.setSubtotal(stotal);
	}
	public void computetax(){
		
	}
	public void computetotal() {
		
	}
	public void removeItem(Product prod) {
		orderlist.remove(prod);
	}
	public Customer getCus() {
		return cus;
	}
	public void setCus(Customer cus) {
		this.cus = cus;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public Double getTax() {
		return tax;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}

}
