package com.auth2.auth2.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.auth2.auth2.entity.Account;



@Repository

public interface AccountRepository  extends CrudRepository<Account, Long>{

	@Query(value="select * from account  where account_status=:account_status",nativeQuery = true)
	public List<Account>  findByAccount_status(String account_status);
	
	@Query(value="select *from account where payment_account_payment_account_id=:payment_account_payment_account_id",nativeQuery=true)
	public List<Account>  findByAccount_type(int payment_account_payment_account_id);
	@Query(value="select *from account where  payment_payment_id=:payment_payment_id",nativeQuery=true)
	public List<Account>  findBypayment_type(int payment_payment_id);
}
