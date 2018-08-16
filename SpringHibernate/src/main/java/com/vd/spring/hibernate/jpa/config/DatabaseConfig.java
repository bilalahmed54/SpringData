package com.vd.spring.hibernate.jpa.config;

import javax.sql.DataSource;
import java.util.Properties;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import com.vd.spring.hibernate.jpa.repository.VRepositoryImpl;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {
        "com.vd.spring.hibernate.jpa.repository"
}, repositoryBaseClass = VRepositoryImpl.class)
@EntityScan("com.vd.spring.hibernate.jpa.model")
public class DatabaseConfig {

    @Value("${db.driver}")
    private String DB_DRIVER;

    @Value("${db.password}")
    private String DB_PASSWORD;

    @Value("${db.url}")
    private String DB_URL;

    @Value("${db.username}")
    private String DB_USERNAME;

    @Value("${hibernate.dialect}")
    private String HIBERNATE_DIALECT;

    @Value("${hibernate.show_sql}")
    private String HIBERNATE_SHOW_SQL;

    @Value("${entity_manager.packagesToScan}")
    private String ENTITY_MANAGER_PACKAGES_TO_SCAN;

    // Connection pooling properties

    @Value("${dataSource.cachePrepStmts}")
    private boolean CACHE_PREPARED_STATEMENTS;

    @Value("${dataSource.prepStmtCacheSize}")
    private int PREPARED_STATEMENTS_CACHE_SIZE;

    @Value("${dataSource.prepStmtCacheSqlLimit}")
    private int PREPARED_STATEMENT_CACHE_SQL_LIMIT;

    @Value("${dataSource.useServerPrepStmts}")
    private boolean USE_SERVER_PREPARED_STATEMENTS;

    @Value("${dataSource.maximumPoolSize}")
    private int MAX_POOL_SIZE;

    @Value("${dataSource.connectionTimeout}")
    private int CONNECTION_TIMEOUT;

    @Value("${dataSource.className}")
    private String dataSourceClassName;

    @Bean
    public DataSource dataSource() {

        final HikariDataSource dataSource = new HikariDataSource();

        dataSource.setDataSourceClassName(dataSourceClassName);
        dataSource.addDataSourceProperty("url", DB_URL);
        dataSource.addDataSourceProperty("user", DB_USERNAME);
        dataSource.addDataSourceProperty("password", DB_PASSWORD);
        dataSource.addDataSourceProperty("cachePrepStmts", CACHE_PREPARED_STATEMENTS);
        dataSource.addDataSourceProperty("prepStmtCacheSize", PREPARED_STATEMENTS_CACHE_SIZE);
        dataSource.addDataSourceProperty("prepStmtCacheSqlLimit", PREPARED_STATEMENT_CACHE_SQL_LIMIT);
        dataSource.addDataSourceProperty("useServerPrepStmts", USE_SERVER_PREPARED_STATEMENTS);
        dataSource.setMaximumPoolSize(MAX_POOL_SIZE);
        dataSource.setConnectionTimeout(CONNECTION_TIMEOUT);

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {

        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();

        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan(ENTITY_MANAGER_PACKAGES_TO_SCAN);

        Properties hibernateProperties = new Properties();

        hibernateProperties.put("hibernate.dialect", HIBERNATE_DIALECT);
        hibernateProperties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
        hibernateProperties.put("hibernate.id.new_generator_mappings", false);

        sessionFactoryBean.setHibernateProperties(hibernateProperties);

        return sessionFactoryBean;
    }
}