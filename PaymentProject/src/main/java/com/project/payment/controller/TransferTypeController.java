package com.project.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.project.payment.exception.TransferTypeNotFoundException;
import com.project.payment.model.TransferType;
import com.project.payment.service.TransferTypeService;

@RestController
public class TransferTypeController {
	@Autowired
	private TransferTypeService transferTypeService;
	
	
	public TransferType findTransferType(String ttype) throws TransferTypeNotFoundException {
		return transferTypeService.findTransferType(ttype);
	}
	

}
