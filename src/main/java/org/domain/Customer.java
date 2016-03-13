package org.domain;

public class Customer {
	private String name;
	private int id;
    private String state;
    public Customer(String n,int i,String s) {
    	this.name=n;
    	this.id=i;
    	this.state=s;
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
