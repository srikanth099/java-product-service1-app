package org.ecom.productservice9.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class AppConfig {
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setHibernateProperties(getConnectionProperties());
		sessionFactory.setPackagesToScan("org.ecom.productservice9.entity");
		return sessionFactory;
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/config_db");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	public static Properties getConnectionProperties() {
		Properties properties=new Properties();
		
		properties.setProperty("hibernate.show_sql","true");
		properties.setProperty("hibernate.hbm2ddl.auto","update");
		return properties;
		
	}

//	@Bean
//	public LocalSessionFactoryBean getSessionFactory() {
//
//		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//		sessionFactory.setDataSource(getDataSource());
//		sessionFactory.setHibernateProperties(getMySqlDbProperties());
//		sessionFactory.setPackagesToScan("org.ecom.productservice9.entity");// mapping
//		return sessionFactory;
//	}
//
//	@Bean
//	public DataSource getDataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/config_db");
//		dataSource.setUsername("root");
//		dataSource.setPassword("root");
//		return dataSource;
//	}
//
//	public static Properties getMySqlDbProperties() {
//		Properties properties = new Properties();
//
//		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
//		properties.setProperty("hibernate.show_sql", "true");// by default it is disable.//sql queries it can be
//																// displayed in hibernate internally.
//		properties.setProperty("hibernate.hbm2ddl.auto", "update");// execute tables created
//		return properties;
//	}
////	public void getModelMapper() {
////	 new ModelMapper();
////	}
}
