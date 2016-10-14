package ua.in.dris4ecoder.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ua.in.dris4ecoder.Model.Services.UserRegistrationService;
import ua.in.dris4ecoder.Model.Services.UserRegistrationServiceImpl;
import ua.in.dris4ecoder.Model.dao.Dao;
import ua.in.dris4ecoder.Model.dao.HibernateDaoImpl;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Alex Korneyko on 12.10.2016 8:55.
 */
@Configuration
@ComponentScan("ua.in.dris4ecoder")
@EnableTransactionManagement
public class HibernateConfig {

    @Bean
    ComboPooledDataSource comboPooledDataSource() throws IOException, PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        Properties properties = new Properties();
        properties.load(new FileInputStream(new ClassPathResource("jdbc.properties").getFile()));

        dataSource.setDriverClass(properties.getProperty("jdbc.driver.class"));
        dataSource.setJdbcUrl(properties.getProperty("jdbc.url"));
        dataSource.setUser(properties.getProperty("jdbc.user"));
        dataSource.setPassword(properties.getProperty("jdbc.password"));
        dataSource.setMinPoolSize(Integer.parseInt(properties.getProperty("jdbc.min.connection")));
        dataSource.setMaxPoolSize(Integer.parseInt(properties.getProperty("jdbc.max.connection")));
        dataSource.setAcquireIncrement(Integer.parseInt(properties.getProperty("jdbc.acquire.increment")));

        return dataSource;
    }

    @Bean
    LocalSessionFactoryBean localSessionFactoryBean(DataSource dataSource) {

        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setPackagesToScan("ua.in.dris4ecoder");
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        sessionFactoryBean.setHibernateProperties(properties);

        return sessionFactoryBean;
    }

    @Bean
    HibernateTransactionManager transactionManager (SessionFactory sessionFactory) {

        return new HibernateTransactionManager(sessionFactory);
    }

    @Bean
    Dao hibernateDaoImpl (SessionFactory sessionFactory) {

        Dao dao = new HibernateDaoImpl();
        dao.setSessionFactory(sessionFactory);

        return dao;
    }

    @Bean
    UserRegistrationService userRegistrationServiceImpl (Dao dao) {

        UserRegistrationService userRegistrationService = new UserRegistrationServiceImpl();
        userRegistrationService.setDao(dao);

        return userRegistrationService;
    }
}
