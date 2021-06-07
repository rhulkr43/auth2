package com.auth2.auth2.Controller;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.auth2.auth2.Service.AccountService;
import com.auth2.auth2.Service.PaymentAccountServices;
import com.auth2.auth2.Service.PaymentService;
import com.auth2.auth2.entity.Account;
import com.auth2.auth2.entity.Payment;
import com.auth2.auth2.entity.PaymentAccount;





@RestController
@ResponseBody
@RequestMapping(value = "/payment")
public class PaymentController {
	
	@Autowired
	private PaymentAccountServices paymentAccountServices;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private AccountService accountService;
	@GetMapping(value = "/list")
	public List<Account> home(Model model) {
		List<Account> list=accountService.getAllList();
	  
		return list;
	}
	@GetMapping(value = "/edit/{id}")
	public String editaccount(@PathVariable Long id,Model model) {
		model.addAttribute("account5",accountService.getById(id));
		model.addAttribute("payment",paymentService.getAllPayment());
		model.addAttribute("account",paymentAccountServices.getAccount());
		return "edit/account";
	}
	
	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public String add(Model model) {
		List<PaymentAccount> items=paymentAccountServices.getAccount();
		List<PaymentAccount> initems=items.stream().filter(str->str.getAccount_status().equals("In")).collect(Collectors.toList());
		
		List<PaymentAccount> outitems=items.stream().filter(str->str.getAccount_status().equals("Out")).collect(Collectors.toList());
		
		return "add";
	}
	
	@RequestMapping(value = "/addsave",method = RequestMethod.POST)
	public String add(@ModelAttribute("account") Account account,Model model) {
		PaymentAccount paymentAccount=paymentAccountServices.getAccountByAccount(account.getAccount_type());
		
		if(account.getId()==0) {
			model.addAttribute("commond" ,new Account());
			Payment payment=paymentService.findbYname(account.getPayment_type());
			account.setPayment(payment);	
			account.setPaymentAccount(paymentAccount);
			account.setDate(LocalDate.now());
			accountService.save(account);
			int amountString=payment.getAmount();
			
			
			payment.setAmount(amountString);
			paymentService.addPayment(payment);
		}
		else {
		Account account1=accountService.getById(account.getId());
		

		account1.setAccount_type(account.getAccount_type());
		account1.setAmount(account.getAmount());
		account1.setName(account.getName());
		account1.setAccount_status(account.getAccount_status());
		account1.setPayment_type(account.getPayment_type());
		account1.setRemark(account.getRemark());
		account1.setPaymentAccount(paymentAccount);
		accountService.save(account1);
		}
		return "redirect:/payment/list";
	}
	
	
	
	@RequestMapping(value = "/account/list")
	public String accountlist(Model model) {
		model.addAttribute("list",paymentService.getAllPayment());
		Map<Object,Object> map = null;
		
		return "paymentaccountlist";
	}
	@RequestMapping(value = "/account/add")
	public String accountadd(Model model) {
		model.addAttribute("command",new Payment());   
		return "paymentaccountadd";
	}
	@RequestMapping(value = "/account/save")
	public String accountsave(@ModelAttribute("payment") Payment payment,Model model) {
		if(payment.getId()==0) {
			paymentService.addPayment(payment);
		}else {
			Payment payment2=paymentService.getPaymentById(payment.getId());
			payment2.setName(payment.getName());
			payment2.setPayment_remarkString(payment.getPayment_remarkString());
			payment2.setAmount(payment.getAmount());
			paymentService.addPayment(payment2);
		}
		
		return "redirect:/payment/account/list";
	}
	
	
	
}
