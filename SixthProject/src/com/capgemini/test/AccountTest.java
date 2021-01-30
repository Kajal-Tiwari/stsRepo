package com.capgemini.test;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InsufficientOpeningAmountException;
//import com.capgemini.exception.InvalidAccountNumberException;
import com.capgemini.beans.Account;
import com.capgemini.repository.AccountRepository;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
public class AccountTest {
	AccountService accountService;
	public static Account account=new Account();
	@Mock
	AccountRepository accountRepository;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		accountService = new AccountServiceImpl(accountRepository);
	}
	@Test(expected=com.capgemini.exception.InsufficientOpeningAmountException.class)
	public void whenTheAmountIsLessThan500SystemShouldThrowException() throws InsufficientOpeningAmountException
	{
		accountService.createAccount(101, 400);
	}
	@Test
	public void whenTheValidInfoIsPassedAccountShouldBeCreatedSuccessfully() throws InsufficientOpeningAmountException
	{
		account=new Account(101,5000);
		when(accountRepository.save(account)).thenReturn(true);
		assertEquals(account, accountService.createAccount(101, 5000));
	}
	/*@Test(expected=com.capgemini.exception.InvalidAccountNumberException.class)
	public void whenAccountNumberIsInvalidSystemShouldThrowException() throws InvalidAccountNumberException, InsufficientBalanceException,InsufficientOpeningAmountException
	{  
		accountService.withdrawAmount(103,5000);

	}
	@Test(expected=com.capgemini.exception.InsufficientBalanceException.class)
	public void whenTheBalanceIsNotAvailableInAccountSystemShouldThrowException() throws InsufficientBalanceException ,InvalidAccountNumberException,InsufficientBalanceException
	{  
		account = new Account(101,700);
		when(accountRepository.searchAccount(101)).thenReturn(account);
		accountService.withdrawAmount(101, 800);
	}
	@Test
	public void whenTheValidInfoisPassedAmountShouldBeWithdrawn() throws InvalidAccountNumberException ,InsufficientBalanceException,InsufficientOpeningAmountException
	{
		account=new Account(101,6000);
		when(accountRepository.searchAccount(101)).thenReturn(account);
		assertEquals(account,accountService.withdrawAmount(101, 2500));
	}
	@Test(expected=com.capgemini.exception.InvalidAccountNumberException.class)
	public void whenAccountNumberIsNotValidSystemShouldThrowException() throws InvalidAccountNumberException, InsufficientOpeningAmountException
	{
		accountService.depositAmount(101, 4000);		
	}
	@Test
	public void whenValidInfoIsPassedAmountShouldBeDeposited() throws InvalidAccountNumberException, InsufficientOpeningAmountException
	{
		account=new Account(101,2000);
		when(accountRepository.searchAccount(101)).thenReturn(account);
		assertEquals(account,accountService.depositAmount(101, 7000));
	}*/
}

