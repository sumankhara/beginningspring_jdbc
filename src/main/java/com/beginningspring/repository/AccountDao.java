package com.beginningspring.repository;

import com.beginningspring.model.Account;

public interface AccountDao {

	void insert(Account account);
	
	void update(Account account);
	
	void delete(long accountId);
	
	Account find(long accountId);
	
	Account find(String ownername);
}
