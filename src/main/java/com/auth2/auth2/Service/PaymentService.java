package com.auth2.auth2.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.auth2.auth2.Repository.PaymentRepository;
import com.auth2.auth2.entity.Payment;




@Service
@Transactional
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	public void addPayment(Payment payment) {
		paymentRepository.save(payment);
	}
	
	public List<Payment> getAllPayment(){
		List<Payment> list=(List<Payment>) paymentRepository.findAll();
		return list;
	}
	
	public Payment getPaymentById(@Param("id") long id) {
		return paymentRepository.findById(id).get();
	}
	
	public void deletebyid(@Param("id") long id) {
		paymentRepository.deleteById(id);
		
	}
	
	public Payment findbYname(@Param("name") String name) {
		return paymentRepository.getPaymentByName(name);
	}
	
	public Payment findByPaymentType(@Param("payment_type") String payment_type) {
		return paymentRepository.getPaymentAccountBypayment_type(payment_type);
	}
}
