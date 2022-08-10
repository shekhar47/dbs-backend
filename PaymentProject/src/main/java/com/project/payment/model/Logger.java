package com.project.payment.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Logger {
	@Id
	private int loggerid;
	@ManyToOne
	@JoinColumn(name="employeeid")
	private Employee employee;
	@ManyToOne
	@JoinColumn(name="customerid")
	private Customers customers;
	private String screename;
	private String action;
	private String ipaddress;
	
	
	public Logger() {
		
	}
	
	
	public Logger(Employee employee, Customers customers,  String screename, String action,
			String ipaddress) {
		super();
		this.employee = employee;
		this.customers = customers;
		
		this.screename = screename;
		this.action = action;
		this.ipaddress = ipaddress;
	}
	public int getLoggerid() {
		return loggerid;
	}
	public void setLoggerid(int loggerid) {
		this.loggerid = loggerid;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Customers getCustomer() {
		return customers;
	}
	public void setCustomer(Customers customers) {
		this.customers = customers;
	}
	
	public String getScreename() {
		return screename;
	}
	public void setScreename(String screename) {
		this.screename = screename;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getIpaddress() {
		return ipaddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	@Override
	public String toString() {
		return "Logger [loggerid=" + loggerid + ", employee=" + employee + ", customers=" + customers + ", screename="
				+ screename + ", action=" + action + ", ipaddress=" + ipaddress + "]";
	}
	
	
	

}
