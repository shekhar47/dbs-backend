package com.project.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.payment.exception.CurrencyNotFoundException;
import com.project.payment.model.Currency;
import com.project.payment.service.CurrencyService;

@CrossOrigin("*")
@RestController
public class CurrencyController {
	@Autowired
	private CurrencyService currencyService;
	
<<<<<<< HEAD
	@GetMapping("api/currency/findbyid/{ccode}")
	public Currency findCurrency(@PathVariable String ccode) throws CurrencyNotFoundException {
=======
	@GetMapping("/api/currency/findbyid/{ccode}")
	public Currency findCurrency(@PathVariable String ccode) throws CurrencyNotFoundException {
		System.out.println("Currency Code :"+ccode);
>>>>>>> 2fb818ba177ed1aaef26999242978dea21d64838
		return currencyService.findCurrency(ccode);
	}

}
