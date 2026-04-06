package com.fybeca.frame_controller.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.fybeca.frame_controller.repository.ge",
        entityManagerFactoryRef = "geEntityManagerFactory",
        transactionManagerRef = "geTransactionManager"
)
public class GeDataSourceConfig {

    /**
     * HikariDataSource permite bindear la propiedad "jdbc-url" directamente.
     * DataSourceProperties no soporta "jdbc-url", por eso se usa HikariDataSource aqui.
     */
    @Bean(name = "geDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.ge")
    public HikariDataSource geDataSource() {
        return new HikariDataSource();
    }

    @Bean(name = "geEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean geEntityManagerFactory(
            @Qualifier("geDataSource") DataSource dataSource) {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setPackagesToScan("com.fybeca.frame_controller.model.ge");
        emf.setJpaVendorAdapter(vendorAdapter);

        Map<String, Object> props = new HashMap<>();
        props.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
        props.put("hibernate.hbm2ddl.auto", "none");
        emf.setJpaPropertyMap(props);

        return emf;
    }

    @Bean(name = "geTransactionManager")
    public PlatformTransactionManager geTransactionManager(
            @Qualifier("geEntityManagerFactory") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
