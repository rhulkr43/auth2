package com.auth2.auth2.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.auth2.auth2.entity.PaymentAccount;



@Repository
public interface PaymentAccountRepository extends CrudRepository<PaymentAccount, Long> {

	@Query(value="select * from payment_account  where account_type=:account_type",nativeQuery = true)
	 public PaymentAccount getPaymentAccountByName(@Param("account_type") String account_type); 
	
	
	
	
}
