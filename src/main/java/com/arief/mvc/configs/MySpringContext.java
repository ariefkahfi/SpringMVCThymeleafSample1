package com.arief.mvc.configs;

import com.arief.mvc.models.Penumpang;
import com.arief.mvc.models.Pesawat;
import com.arief.mvc.models.Tiket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"com.arief.mvc.dao"})
public class MySpringContext {


    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource dataSource
                = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_mvc2");
        dataSource.setUsername("arief");
        dataSource.setPassword("arief");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }


    private Properties hibernateProperties(){
        Properties props =  new Properties();
        props.setProperty("hibernate.show_sql","true");
        props.setProperty("hibernate.hbm2ddl.auto","update");
        props.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
        return props;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(){
        LocalSessionFactoryBean sessionFactoryBean
                = new LocalSessionFactoryBean();
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setAnnotatedClasses(
                Pesawat.class,
                Penumpang.class,
                Tiket.class
        );
        return sessionFactoryBean;
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager(){
        HibernateTransactionManager
                hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactoryBean().getObject());
        return hibernateTransactionManager;
    }

    @Bean
    public TransactionTemplate transactionTemplate(){
        TransactionTemplate transactionTemplate
                =new TransactionTemplate();
        transactionTemplate.setTransactionManager(hibernateTransactionManager());
        return transactionTemplate;
    }
}
