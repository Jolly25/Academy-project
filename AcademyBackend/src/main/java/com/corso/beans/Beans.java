package com.corso.beans;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.corso.dao.MatchDAO;
import com.corso.dao.StandardWordDAO;
import com.corso.checkstring.Contained;
import com.corso.checkstring.Contains;
import com.corso.checkstring.Levenshtein;
import com.corso.service.MatchService;
import com.corso.service.StandardWordService;
import com.corso.standardwords.StandardWordsFromDB;

@Configuration
@ComponentScan(basePackages="com.corso")
@EnableTransactionManagement 

public class Beans {

	@Bean(name="dataSource")
	public DataSource getDataSource () {
		DriverManagerDataSource ds = new DriverManagerDataSource(); 
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("Links23?");
		ds.setUrl("jdbc:mysql://localhost:3306/paesidb");
		return ds; 
	} 
	
	
	@Bean
	public EntityManagerFactory entityManagerFactory() throws SQLException {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(getJpaVendorAdapter());
		factory.setPackagesToScan(this.getClass().getPackage().getName());
		factory.setDataSource(getDataSource());
		factory.afterPropertiesSet();
		return factory.getObject();
	}

	
	
	@Bean
	public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
		return entityManagerFactory.createEntityManager();
	}

	private HibernateJpaVendorAdapter getJpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);   
		adapter.setGenerateDdl(true);          
		adapter.setShowSql(true);             
		return adapter;
	}	

	

	@Bean
	public PlatformTransactionManager transactionManager() throws SQLException {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}
	
	

	@Bean(name="dao")
	public MatchDAO getMatchDAO() {
		return new MatchDAO();
	}

	@Bean(name="swDAO")
	public StandardWordDAO getStandardWordDAO() {
		return new StandardWordDAO();
	}

	@Bean(name="matchService")
	public MatchService getMatchService() {
		MatchService ms = new MatchService();
		ms.setDao(getMatchDAO());
		return ms;
	}

	@Bean(name="swService")
	public StandardWordService getStandardWordService() {
		StandardWordService sws = new StandardWordService();
		sws.setDao(getStandardWordDAO());
		return sws;
	}
	
	@Bean(name="swfd")
	public StandardWordsFromDB getStandardWordsFromDB() {
		return new StandardWordsFromDB();
	}

	


}
