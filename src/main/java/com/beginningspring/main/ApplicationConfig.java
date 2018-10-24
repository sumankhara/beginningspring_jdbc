package com.beginningspring.main;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.beginningspring.repository.AccountDao;
import com.beginningspring.repository.AccountDaoJdbcImpl;

@Configuration
public class ApplicationConfig {

	@Bean(name = "h2DataSource")
	public DataSource getH2DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		return dataSource;
	}
	
	@Bean(name = "mysqlDataSource")
	public DataSource getMysqlDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/menagerie");
		dataSource.setUsername("root");
		dataSource.setPassword("su1028kh");
		
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getH2DataSource());
		
		return jdbcTemplate;
	}
	
	@Bean
	public AccountDao accountDao() {
		AccountDaoJdbcImpl accountDao = new AccountDaoJdbcImpl();
		accountDao.setJdbcTemplate(jdbcTemplate());
		
		return accountDao;
	}
}
