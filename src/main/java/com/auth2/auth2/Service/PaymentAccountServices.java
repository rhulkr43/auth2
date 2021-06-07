package com.auth2.auth2.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.auth2.auth2.Repository.PaymentAccountRepository;
import com.auth2.auth2.entity.PaymentAccount;



@Service
@Transactional
public class PaymentAccountServices {

	@Autowired
	private PaymentAccountRepository paymentAccountRepository;
	
	
	public Long save(PaymentAccount paymentAccount) {
		PaymentAccount paymentAccount2=paymentAccountRepository.save(paymentAccount);
		System.out.println(paymentAccount2.getPayment_account_id());
		return paymentAccount2.getPayment_account_id();
		
	}
	
	public List<PaymentAccount> getAccount(){
		List<PaymentAccount> list=(List<PaymentAccount>) paymentAccountRepository.findAll();
		return list;
	}
	
	public PaymentAccount  getPaymentById(@Param("id") long id) {
		return paymentAccountRepository.findById(id).get();
	}
	
	public void deletebyid(@Param("id") long id) {
		paymentAccountRepository.deleteById(id);
	}
	
	public PaymentAccount getAccountByAccount(@Param("account_type") String account_type) {
		return paymentAccountRepository.getPaymentAccountByName(account_type);
	}
	
}
