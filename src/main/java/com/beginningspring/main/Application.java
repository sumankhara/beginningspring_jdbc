package com.beginningspring.main;

import java.sql.SQLException;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.beginningspring.model.Account;
import com.beginningspring.repository.AccountDao;

public class Application {

	public static void main(String[] args) throws SQLException {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		AccountDao accountdao = context.getBean("accountDao", AccountDao.class);
		
//		Account account = accountdao.find("john doe");
//		
//		System.out.println(account.getId());
//		System.out.println(account.getOwnerName());
//		System.out.println(account.getBalance());
//		System.out.println(account.getAccessTime());
//		System.out.println(account.isLocked());
		
		Account account = new Account();
		account.setOwnerName("Joe Smith");
		account.setBalance(20.0);
		account.setAccessTime(new Date());
		account.setLocked(true);
		
		accountdao.insert(account);
		
		account = accountdao.find(account.getId());
		
		System.out.println(account.getId());
		System.out.println(account.getOwnerName());
		System.out.println(account.getBalance());
		System.out.println(account.getAccessTime());
		System.out.println(account.isLocked());
		
		account.setBalance(30.0);
		accountdao.update(account);
		
		account = accountdao.find(account.getId());
		System.out.println(account.getBalance());
		
		accountdao.delete(account.getId());
	}

}
