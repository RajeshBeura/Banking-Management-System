package com.bankingproject.banking_app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="accounts")
@Entity
public class Account {
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="account_holder_name")
	private String accountHolderName;
	private double balance;
	
	

	    // Constructor
	    public Account(Long id, String accountHolderName, double balance) {
	        this.id = id;
	        this.accountHolderName = accountHolderName;
	        this.balance = balance;
	    }

	    // Getters and Setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getAccountHolderName() {
	        return accountHolderName;
	    }

	    public void setAccountHolderName(String accountHolderName) {
	        this.accountHolderName = accountHolderName;
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public void setBalance(double balance) {
	        this.balance = balance;
	    }
	

}