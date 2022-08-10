package com.project.payment.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity 
@Data
public class Banks {
	@Id
	private String bic;
	private String bankname;
	
	/*
	 * public Banks() { // TODO Auto-generated constructor stub }
	 * 
	 * public Banks(String bic, String bankname) { super(); this.bic = bic;
	 * this.bankname = bankname; }
	 * 
	 * public String getBic() { return bic; }
	 * 
	 * public void setBic(String bic) { this.bic = bic; }
	 * 
	 * public String getBankname() { return bankname; }
	 * 
	 * public void setBankname(String bankname) { this.bankname = bankname; }
	 * 
	 * @Override public String toString() { return "Banks [bic=" + bic +
	 * ", bankname=" + bankname + "]"; }
	 * 
	 */

}
