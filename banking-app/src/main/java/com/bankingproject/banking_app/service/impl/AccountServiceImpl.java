package com.bankingproject.banking_app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingproject.banking_app.dto.AccountDto;
import com.bankingproject.banking_app.entity.Account;
import com.bankingproject.banking_app.mapper.AccountMapper;
import com.bankingproject.banking_app.repository.AccountRepository;
import com.bankingproject.banking_app.service.AccountService;


@Service
public class AccountServiceImpl implements AccountService {
	
	private AccountRepository accountRepository;	
	
	
	
//	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}




	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account=AccountMapper.mapToAccount(accountDto);
		Account saveAccount=accountRepository.save(account);
		
		return AccountMapper.mapToAccountDto(saveAccount);
	}




	@Override
	public AccountDto getAccountById(Long id) {
		Account account=accountRepository
				.findById(id)
				.orElseThrow(()->new RuntimeException("Account does not exist"));
		return AccountMapper.mapToAccountDto(account);
	}




	@Override
	public AccountDto deposit(Long id, double amount) {
		Account account=accountRepository
				.findById(id)
				.orElseThrow(()->new RuntimeException("Account does not exist"));
		double total=account.getBalance()+amount;
		account.setBalance(total);
		Account savedAccount=accountRepository.save(account);
		
		return AccountMapper.mapToAccountDto(savedAccount);
	}




	@Override
	public AccountDto withdraw(Long id, double amount) {
		Account account=accountRepository
				.findById(id)
				.orElseThrow(()->new RuntimeException("Account does not exist"));
		
		if(account.getBalance() < amount) {
			throw new RuntimeException("Insufficient Ammount");
			
		}
		
		double total=account.getBalance()-amount;
		account.setBalance(total);
		Account saveAccount= accountRepository.save(account);
		return AccountMapper.mapToAccountDto(saveAccount);
		
	}




	@Override
	public List<AccountDto> getAllAccounts() {
		List<Account> accounts= accountRepository.findAll();
		return accounts.stream().map((account)->AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
		 
	}




	@Override
	public void deleteAccount(Long id) {
		Account account=accountRepository
				.findById(id)
				.orElseThrow(()->new RuntimeException("Account does not exist"));
		accountRepository.deleteById(id);
	}

}
