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

import com.corso.dao.AlgorithmDAO;
import com.corso.dao.BandiereRisultatoDAO;
import com.corso.dao.MatchDAO;
import com.corso.dao.RisultatoDAO;
import com.corso.dao.SegnalazioneDAO;
import com.corso.dao.StandardWordDAO;
import com.corso.dao.UserDAO;
import com.corso.checkstring.AlgorithmHandler;
import com.corso.checkstring.CheckString;
import com.corso.checkstring.Contained;
import com.corso.checkstring.Contains;
import com.corso.checkstring.Equals;
import com.corso.checkstring.Fisher;
import com.corso.checkstring.Levenshtein1;
import com.corso.checkstring.Levenshtein2;
import com.corso.checkstring.Levenshtein3;
import com.corso.checkstring.MatchCheckString;
import com.corso.service.AlgorithmService;
import com.corso.service.BandiereRisultatoService;
import com.corso.service.MatchService;
import com.corso.service.RisultatoService;
import com.corso.service.SegnalazioneService;
import com.corso.service.StandardWordService;
import com.corso.service.UserService;
import com.corso.standardwords.StandardWords;
import com.corso.standardwords.StandardWordsFromDB;

@Configuration
@ComponentScan(basePackages="com.corso")
@EnableTransactionManagement 

public class Beans {
	
	
	@Bean(name="dataSource")
    public DataSource getDataSource () {
        DriverManagerDataSource ds = new DriverManagerDataSource(); 
        ds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        ds.setUsername("sa");
        ds.setPassword("1234");
        ds.setUrl("jdbc:sqlserver://localhost:1433;databaseName=academy;encrypt=true;trustServerCertificate=true");
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
		adapter.setDatabase(Database.SQL_SERVER);   
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
	
	@Bean(name="algorithmDao")
	public AlgorithmDAO getAlgorithmDAO() {
		return new AlgorithmDAO();
	}
	
	@Bean(name="userDao")
	public UserDAO getUserDAO() {
		return new UserDAO();
	}

	@Bean(name="swDAO")
	public StandardWordDAO getStandardWordDAO() {
		return new StandardWordDAO();
	}
	
	@Bean(name="risultatoDAO")
	public RisultatoDAO getRisultatoDAO() {
		return new RisultatoDAO();
	}
	
	@Bean(name = "bandiereRisultatoDAO")
	public BandiereRisultatoDAO getBandiereRisultatoDAO() {
		return new BandiereRisultatoDAO();
	}
	
	@Bean(name="segnalazioneDAO")
	public SegnalazioneDAO getSegnalazioneDAO() {
		return new SegnalazioneDAO();
	}

	@Bean(name="matchService")
	public MatchService getMatchService() {
		MatchService ms = new MatchService();
		ms.setDao(getMatchDAO());
		return ms;
	}
	
	@Bean(name="algorithmService")
	public AlgorithmService getAlgorithmService() {
		AlgorithmService as = new AlgorithmService();
		as.setDao(getAlgorithmDAO());
		return as;
	}
	
	@Bean(name="userService")
	public UserService getUserService() {
		UserService ms = new UserService();
		ms.setDao(getUserDAO());
		return ms;
	}

	@Bean(name="swService")
	public StandardWordService getStandardWordService() {
		StandardWordService sws = new StandardWordService();
		sws.setDao(getStandardWordDAO());
		return sws;
	}
	
	@Bean(name="risultatoService")
	public RisultatoService getPartitaService() {
		RisultatoService rs = new RisultatoService();
		rs.setDao(getRisultatoDAO());
		return rs;
	}
	
	@Bean(name="segnalazioneService")
	public SegnalazioneService getSegnalazioneService() {
		SegnalazioneService ss = new SegnalazioneService();
		ss.setDao(getSegnalazioneDAO());
		return ss;
	}
	
	@Bean(name="brs")
	public BandiereRisultatoService getBandiereRisultatoService() {
		BandiereRisultatoService brs = new BandiereRisultatoService();
		brs.setDao(getBandiereRisultatoDAO());
		return brs;
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

	@Bean(name="matchCS")
	public CheckString getMatchCheckString() {
		return new MatchCheckString();
	}

	@Bean(name="containsCS")
	public CheckString getContains() {
		return new Contains();
	}

	@Bean(name="containedCS")
	public CheckString getContained() {
		return new Contained();
	}

	@Bean(name="levenshtein1CS")
	public CheckString getLevenshtein1() {
		return new Levenshtein1();
	}
	
	@Bean(name="levenshtein2CS")
	public CheckString getLevenshtein2() {
		return new Levenshtein2();
	}
	
	@Bean(name="levenshtein3CS")
	public CheckString getLevenshtein3() {
		return new Levenshtein3();
	}
	
	@Bean(name="fisherCS")
	public CheckString getFisher() {
		return new Fisher();
	}
	
	@Bean(name="equalsCS")
	public CheckString getEquals() {
		return new Equals();
	}
	
	



}
