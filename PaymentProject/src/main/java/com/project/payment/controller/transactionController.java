package com.project.payment.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.payment.exception.LoggerException;
import com.project.payment.exception.TransactionException;
import com.project.payment.model.Customers;
import com.project.payment.model.Employee;
import com.project.payment.model.Logger;
import com.project.payment.model.Transaction;
import com.project.payment.repository.EmployeeRepository;
import com.project.payment.repository.LoggerRepository;
import com.project.payment.service.TransactionService;

@RestController
@CrossOrigin("*")
@RequestMapping("api/transaction")
public class transactionController {

	@Autowired
	private TransactionService transactionService;
	@Autowired
	private LoggerRepository loggerRepository;

	@Autowired
	private BanksController bankController;
	@Autowired
	private CustomerController customerController;
	@Autowired
	private CurrencyController currencyController;
	@Autowired
	private TransferTypeController transferTypecontroller;
	@Autowired
	private MessageController messageController;
	@Autowired
	private EmployeeRepository employeeRepository;

//	@PostMapping("/proceed")
//	public String makeTransaction(@RequestParam("custid") String customerid, @RequestParam("currcode") String currcode,
//			@RequestParam("sbic") String sbic, @RequestParam("rbic") String rbic, @RequestParam("msg") String msg,
//			@RequestParam("rname") String rname, @RequestParam("sname") String sname,
//			@RequestParam("ttype") String ttype, @RequestParam("amount") double amount,
//			@RequestParam("tfee") double tfee, @RequestParam("inramount") double inramount)
//			throws BankNotFoundException, CurrencyNotFoundException, MessageCodeNotFoundException, TransactionException,
//			TransferTypeNotFoundException, UnknownHostException, LoggerException {
//
//		Transaction tr = new Transaction();
//
//		String result = customerid + " " + currcode + " " + sbic + " " + rbic + " " + rbic + " " + rname + " " + sname
//				+ " " + ttype + " " + amount + " " + tfee + " " + inramount;
//		Currency ccode = currencyController.findCurrency(currcode);
//		Banks sb = bankController.findBank(sbic).get();
//		Banks rb = bankController.findBank(rbic).get();
//		Customers cust = custController.findId(customerid).get();
//		TransferType trtype = transferTypecontroller.findTransferType(ttype);
//		Message message = messageController.findMessage(msg);
//		Date date = new Date();
//
//		java.util.Date utilDate = new java.util.Date();
//		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//
//		tr.setCurrency(ccode);
//		tr.setCustomer(cust);
//		tr.setSenderbank(sb);
//		tr.setRecieverbank(rb);
//		tr.setMessage(message);
//		tr.setAccountholdernumber(sname);
//		tr.setRecieveraccountholdername(rname);
//		tr.setTransferfees(tfee);
//		tr.setCurrencyamount(80);
//		tr.setInramount(inramount * ccode.getConversionrate());
//		tr.setTransferdate(sqlDate);
//		String trResult = transactionService.saveTransaction(tr);
//		//saveLogger(tr);
//		return "Transaction Succesfull\n  " + trResult;
//
//	}

	private void saveLogger(Transaction tr) throws UnknownHostException, LoggerException {
		Employee e = employeeRepository.findById(1).get();

		Customers cust1 = tr.getCustomer();
		String action = "Transaction: " + tr.getMessage().getMessagecode();
		String screenName = "";
		InetAddress localhost = InetAddress.getLocalHost();
		String ipAddress = (localhost.getHostAddress()).trim();
	
		
		Logger log=new Logger(e, cust1, screenName, action, ipAddress);
		System.out.println("Logger:"+log);
		  Logger updatedLog=loggerRepository.save(log); if(updatedLog==null) throw new LoggerException("Error !! Can't write logs");
		 
	}

	@PostMapping("/Proceed2")
	public String makeTransaction2(@RequestBody Transaction tr)
			throws TransactionException, UnknownHostException, LoggerException {
		System.out.println(tr);
		//saveLogger(tr);
		return transactionService.makeTransaction2(tr);

	}

}
