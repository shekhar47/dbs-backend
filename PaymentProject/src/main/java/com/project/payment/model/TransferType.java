package com.project.payment.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Transfertype")
public class TransferType {
	@Id
	private String transfertype;
	private String transfertypedescription;
	public TransferType() {
		
	}
	public TransferType(String transfertype, String transfertypedescription) {
		super();
		this.transfertype = transfertype;
		this.transfertypedescription = transfertypedescription;
	}
	public String getTransfertype() {
		return transfertype;
	}
	public void setTransfertype(String transfertype) {
		this.transfertype = transfertype;
	}
	public String getTransfertypedescription() {
		return transfertypedescription;
	}
	public void setTransfertypedescription(String transfertypedescription) {
		this.transfertypedescription = transfertypedescription;
	}
	@Override
	public String toString() {
		return "TransferType [transfertype=" + transfertype + ", transfertypedescription=" + transfertypedescription
				+ "]";
	}
	
	

}
