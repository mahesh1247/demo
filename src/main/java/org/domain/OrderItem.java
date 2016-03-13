package org.domain;

public class OrderItem {
   private Product prod;
   private int quantity;
   public OrderItem(Product p,int q) {
	   this.prod=p;
	   this.quantity=q;
   }
public Product getProd() {
	return prod;
}
public void setProd(Product prod) {
	this.prod = prod;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
   
}
