package com.auth2.auth2.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;





@Entity
@Table(name = "payment_account")
public class PaymentAccount {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private long payment_account_id;
	
	

	private String account_type;
     
	private String account_remarkString;
	
	private String account_status;
 

	public String getAccount_status() {
	return account_status;
}

public void setAccount_status(String account_status) {
	this.account_status = account_status;
}

	public PaymentAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentAccount(long payment_account_id, String account_type, String account_remarkString) {
		super();
		this.payment_account_id = payment_account_id;
		this.account_type = account_type;
		this.account_remarkString = account_remarkString;
	}

	public String getAccount_remarkString() {
		return account_remarkString;
	}

	public void setAccount_remarkString(String account_remarkString) {
		this.account_remarkString = account_remarkString;
	}

	public PaymentAccount(long payment_account_id, String account_type) {
		super();
		this.payment_account_id = payment_account_id;
		this.account_type = account_type;
	}

	public long getPayment_account_id() {
		return payment_account_id;
	}

	public void setPayment_account_id(long payment_account_id) {
		this.payment_account_id = payment_account_id;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	@Override
	public String toString() {
		return "PaymentAccount [payment_account_id=" + payment_account_id + ", account_type=" + account_type
				+ ", account_remarkString=" + account_remarkString + ", account_status=" + account_status + "]";
	}
	
	
	
	
	

}
