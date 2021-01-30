package com.capgemini.service;
//import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InsufficientOpeningAmountException;
//import com.capgemini.exception.InvalidAccountNumberException;
import com.capgemini.beans.Account;
import com.capgemini.repository.AccountRepository;
import com.capgemini.test.AccountTest;

public class AccountServiceImpl implements AccountService {
	AccountRepository accountRepository;
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}
	@Override
	public Account createAccount(int accountNumber,int amount) throws InsufficientOpeningAmountException
	{
		if(amount<500)
		{
			throw new InsufficientOpeningAmountException();
		}

		AccountTest.account.setAccountNumber(accountNumber);

		AccountTest.account.setAmount(amount);

		if(accountRepository.save(AccountTest.account))
		{
			return AccountTest.account;

		}
		return AccountTest.account;
	}
	/*@Override
	public Account withdrawAmount(int accountNumber,int amount) throws InvalidAccountNumberException, InsufficientBalanceException
	{	

		if(accountRepository.searchAccount(accountNumber)!=AccountTest.account)
		{   
			throw new InsufficientBalanceException();	
		}
		if(AccountTest.account.getAmount()-amount<0) {

			throw new InvalidAccountNumberException();
		}
		AccountTest.account.setAmount(AccountTest.account.getAmount()-amount);
		return AccountTest.account;		
	}
	@Override
	public Account depositAmount(int accountNumber, int amount) throws InvalidAccountNumberException {

		if(accountRepository.searchAccount(accountNumber)!=AccountTest.account) {
			throw new InvalidAccountNumberException();
		}
		AccountTest.account.setAmount(AccountTest.account.getAmount()+amount);		
		return AccountTest.account;	

	}

*/
}