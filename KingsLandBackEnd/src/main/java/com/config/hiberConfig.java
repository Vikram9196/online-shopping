package com.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.DaoImpl.*;
import com.model.*;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement

public class hiberConfig {
	@Autowired
	@Bean(name="datasource")
	public DataSource getH2Data()
	{
		System.out.println("Hibernate bean is intiated");
		DriverManagerDataSource dsource = new DriverManagerDataSource();
		
		dsource.setDriverClassName("org.h2.Driver");
		dsource.setUrl("jdbc:h2:tcp://localhost/~/onlineshopping");
		dsource.setUsername("sa");
		dsource.setPassword("");
		System.out.println("H2 Connected");
		return dsource;
	}

	
	private Properties getHiber()
	{
		Properties p= new Properties();
		p.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		p.put("hibernate.hbm2ddl.auto", "update");
		p.put("hibernate.show_sql", "true");
		System.out.println("Tables are Created");
		return p;
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getHiberSession(DataSource datasource)
	{
		LocalSessionFactoryBuilder lsfb= new LocalSessionFactoryBuilder(datasource);
		lsfb.addProperties(getHiber());
		lsfb.addAnnotatedClass(User.class);
		lsfb.addAnnotatedClass(Supplier.class);
		lsfb.addAnnotatedClass(Category.class);
		lsfb.addAnnotatedClass(Product.class);
		return lsfb.buildSessionFactory();
	}
	
	
	@Autowired
	@Bean(name="UserDaoImpl")
	public UserDaoImpl saveUserData(SessionFactory sf)
	{
		return new UserDaoImpl(sf);
				
	}
	

	@Autowired
	@Bean(name="SupplierDaoImpl")
	public SupplierDaoImpl saveSupplierData(SessionFactory sf) 
	{
		return new SupplierDaoImpl(sf);
	}
	
	@Autowired
	@Bean(name="CategoryDaoImpl")
	public CategoryDaoImpl saveCategoryData(SessionFactory sf) 
	{
		return new CategoryDaoImpl(sf);
	}
	
	@Autowired
	@Bean(name="ProductDaoImpl")
	public ProductDaoImpl saveProductData(SessionFactory sf) 
	{
		return new ProductDaoImpl(sf);
	}
	
	@Autowired
	@Bean(name="tranactionManager")
	public HibernateTransactionManager getTrans(SessionFactory sf)
	{
		HibernateTransactionManager tm = new HibernateTransactionManager(sf);
		return tm;
		
	}
}
