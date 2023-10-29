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
import com.corso.checkstring.AlgorithmHandler;
import com.corso.checkstring.CheckString;
import com.corso.checkstring.Contained;
import com.corso.checkstring.Contains;
import com.corso.checkstring.Levenshtein;
import com.corso.checkstring.MatchCheckString;
import com.corso.service.MatchService;
import com.corso.service.StandardWordService;
import com.corso.standardwords.StandardWords;
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

	@Bean(name="matchDao")
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

	@Bean(name="sw")
	public StandardWords getStandardWordsFromDB() {
		StandardWords sw = new StandardWordsFromDB();
		return sw;
	}

	@Bean(name="ah")
	public AlgorithmHandler getAlgorithmHandler() {
		AlgorithmHandler ah = new AlgorithmHandler();
		return ah;
	}

	@Bean(name="c1")
	public CheckString getMatchCheckString() {
		return new MatchCheckString();
	}

	@Bean(name="c2")
	public CheckString getContains() {
		return new Contains();
	}

	@Bean(name="c3")
	public CheckString getContained() {
		return new Contained();
	}

	@Bean(name="c4")
	public CheckString getLevenshtein() {
		return new Levenshtein(1);
	}



}
