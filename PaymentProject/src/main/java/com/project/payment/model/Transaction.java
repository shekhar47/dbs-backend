package com.project.payment.model;

//import java.util.Date;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionid;
	@ManyToOne
	@JoinColumn(name="customerid")
	private Customers customers;
	@ManyToOne
	@JoinColumn(name="currencycode")
	private Currency currency;
	@ManyToOne
	@JoinColumn(name="senderbic")
	private Banks senderbank;
	@ManyToOne
	@JoinColumn(name="recieverbic")
	private Banks recieverbank;
	private String accountholdernumber;
	private String recieveraccountholdername;
	@ManyToOne
	@JoinColumn(name="transfertypecode")
	private TransferType transferType;
	@ManyToOne
	@JoinColumn(name="messagecode")
	private Message message;
	private double currencyamount;
	private double transferfees;
	private double inramount;
	private Date transferdate;
	
	public Transaction() {
		
	}

	public Transaction(int transactionid, Customers customers, Currency currency, Banks senderbank, Banks recieverbank,
			String accountholdernumber, String recieveraccountholdername, TransferType transferType, Message message,
			double currencyamount, double transferfees, double inramount, Date transferdate) {
		super();
		this.transactionid = transactionid;
		this.customers = customers;
		this.currency = currency;
		this.senderbank = senderbank;
		this.recieverbank = recieverbank;
		this.accountholdernumber = accountholdernumber;
		this.recieveraccountholdername = recieveraccountholdername;
		this.transferType = transferType;
		this.message = message;
		this.currencyamount = currencyamount;
		this.transferfees = transferfees;
		this.inramount = inramount;
		this.transferdate = transferdate;
	}

	public Transaction(String accountholdernumber, String recieveraccountholdername, double currencyamount,
			double transferfees, double inramount, Date transferdate) {
		super();
		this.accountholdernumber = accountholdernumber;
		this.recieveraccountholdername = recieveraccountholdername;
		this.currencyamount = currencyamount;
		this.transferfees = transferfees;
		this.inramount = inramount;
		this.transferdate = transferdate;
	}

	public int getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}

	public Customers getCustomer() {
		return customers;
	}

	public void setCustomer(Customers customers) {
		this.customers = customers;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Banks getSenderbank() {
		return senderbank;
	}

	public void setSenderbank(Banks senderbank) {
		this.senderbank = senderbank;
	}

	public Banks getRecieverbank() {
		return recieverbank;
	}

	public void setRecieverbank(Banks recieverbank) {
		this.recieverbank = recieverbank;
	}

	public String getAccountholdernumber() {
		return accountholdernumber;
	}

	public void setAccountholdernumber(String accountholdernumber) {
		this.accountholdernumber = accountholdernumber;
	}

	public String getRecieveraccountholdername() {
		return recieveraccountholdername;
	}

	public void setRecieveraccountholdername(String recieveraccountholdername) {
		this.recieveraccountholdername = recieveraccountholdername;
	}

	public TransferType getTransferType() {
		return transferType;
	}

	public void setTransferType(TransferType transferType) {
		this.transferType = transferType;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public double getCurrencyamount() {
		return currencyamount;
	}

	public void setCurrencyamount(double currencyamount) {
		this.currencyamount = currencyamount;
	}

	public double getTransferfees() {
		return transferfees;
	}

	public void setTransferfees(double transferfees) {
		this.transferfees = transferfees;
	}

	public double getInramount() {
		return inramount;
	}

	public void setInramount(double inramount) {
		this.inramount = inramount;
	}

	public Date getTransferdate() {
		return transferdate;
	}

	public void setTransferdate(java.util.Date date) {
		this.transferdate = (Date) date;
	}

	@Override
	public String toString() {
		return "Transaction [transactionid=" + transactionid + ", customer=" + customers + ", currency=" + currency
				+ ", senderbank=" + senderbank + ", recieverbank=" + recieverbank + ", accountholdernumber="
				+ accountholdernumber + ", recieveraccountholdername=" + recieveraccountholdername + ", transferType="
				+ transferType + ", message=" + message + ", currencyamount=" + currencyamount + ", transferfees="
				+ transferfees + ", inramount=" + inramount + ", transferdate=" + transferdate + "]";
	}
	
	

}
