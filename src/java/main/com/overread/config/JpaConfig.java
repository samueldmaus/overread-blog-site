package com.overread.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages={"com.overread"})
@EnableTransactionManagement
public class JpaConfig
{
	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory()
	{
		LocalEntityManagerFactoryBean fb = new LocalEntityManagerFactoryBean();
		fb.setPersistenceUnitName("overread_blog_site");
		return fb;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf)
	{
		JpaTransactionManager tm = new JpaTransactionManager();
		tm.setEntityManagerFactory(emf);
		return tm;
	}
}
