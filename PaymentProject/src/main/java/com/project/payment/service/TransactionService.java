package com.project.payment.service;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.payment.exception.LoggerException;
import com.project.payment.exception.TransactionException;
import com.project.payment.model.CustomerUser;
import com.project.payment.model.Customers;
import com.project.payment.model.Employee;
import com.project.payment.model.Transaction;
import com.project.payment.repository.CustomerRepo;
import com.project.payment.repository.LoggerRepository;
import com.project.payment.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	private CustomerRepo custRepo;
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private LoggerRepository loggerRepository;
	
//	public String saveTransaction(Transaction tr) throws TransactionException {
//		
//				Transaction updatedTr=transactionRepository.save(tr);
//				if(updatedTr==null) throw new TransactionException("Error!! Transaction Not save into the database!");
//				else return " Transaction Successfull";
//	}
	
	@Transactional
	public String makeTransaction2(Transaction tr) throws TransactionException, UnknownHostException, LoggerException {
		  java.util.Date utilDate = new java.util.Date();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    tr.setTransferdate(sqlDate);
		    
		    Customers customer=tr.getCustomer();
		    System.out.println("Customer Balance Before"+customer.getClearbalance());
		    double setBalance=customer.getClearbalance()-tr.getInramount();
		    int overdraft=1;
		    boolean checkList=false;
		    if(customer.getClearbalance()<tr.getInramount()) { 
		    	
		    	overdraft=customer.getOverdraftflag();}
		    
		    
		    if(overdraft==1&&checkList==false) {
		    
		    customer.setClearbalance(setBalance);
		    Customers updatedCustomer=custRepo.save(customer);
		    System.out.println("updatedCustomer clear Balance:"+updatedCustomer.getClearbalance());
		
		Transaction updatedResult=transactionRepository.save(tr);
		if(updatedResult==null) throw new TransactionException("Error!! Transaction Not save into the database!");
		else {
			
			
		Employee e=new Employee();
		Customers cust=tr.getCustomer();
		CustomerUser custUser=new CustomerUser(tr.getCustomer().getAccountholdername(), null, cust);
		String action="Transaction: "+tr.getMessage().getInstruction();
		String screenName="";
		 InetAddress localhost = InetAddress.getLocalHost();
		String ipAddress=(localhost.getHostAddress()).trim();
				
		/*
		 * //Logger log=new Logger(e, cust, custUser, screenName, action, ipAddress);
		 * 
		 * Logger updatedLog=loggerRepository.save(log); if(updatedLog==null) throw new
		 * LoggerException("Error !! Can't write logs"); else
		 */ return "Transaction Successfull";
		}
		    }
		    
		else
		{
			if(overdraft==0) return "Customer Can't Make transaction as due to low balance";
			else  return "\nCustomer Appeared in the block list! Sorry!!!";
		}
		    //return "Transaction Unsuccessfull";
		
		
	

}
}
