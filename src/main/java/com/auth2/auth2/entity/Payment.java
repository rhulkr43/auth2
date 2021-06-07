package com.auth2.auth2.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;

@Entity
@Table(name="payment")
public class Payment {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="payment_id")
	private long id;
	
	@Column(name = "payment_name")
	private String name;
	private Integer amount;
	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	private String payment_remarkString;
	
	public long getId() {
		return id;
	}

	public Payment(long id, String name, String payment_remarkString) {
		super();
		this.id = id;
		this.name = name;
		this.payment_remarkString = payment_remarkString;
	}

	public String getPayment_remarkString() {
		return payment_remarkString;
	}

	public void setPayment_remarkString(String payment_remarkString) {
		this.payment_remarkString = payment_remarkString;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
