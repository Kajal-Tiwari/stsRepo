package com.capgemini.service;

import com.capgemini.beans.Account;
//import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InsufficientOpeningAmountException;
//import com.capgemini.exception.InvalidAccountNumberException;

public interface AccountService {

	Account createAccount(int accountNumber, int amount) throws InsufficientOpeningAmountException;
	//Account withdrawAmount(int accountNumber,int amount) throws InvalidAccountNumberException, InsufficientBalanceException;
	//Account depositAmount(int accountNumber, int amount) throws InvalidAccountNumberException;
	
}