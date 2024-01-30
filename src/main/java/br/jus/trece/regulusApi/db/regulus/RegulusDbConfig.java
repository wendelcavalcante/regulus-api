package br.jus.trece.regulusApi.db.regulus;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "regulusEntityManagerFactory",
    transactionManagerRef = "regulusTransactionManager", basePackages = {"br.jus.trece.regulusApi.db.regulus.repo"})
public class RegulusDbConfig {

    @Bean(name = "regulusDataSource")
    @ConfigurationProperties(prefix = "regulus.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "regulusEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean regulusEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("regulusDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource).packages("br.jus.trece.regulusApi.db.regulus.domain").persistenceUnit("regulus")
                .build();
    }

    @Bean(name = "regulusTransactionManager")
    public PlatformTransactionManager regulusTransactionManager(
            @Qualifier("regulusEntityManagerFactory") EntityManagerFactory regulusEntityManagerFactory) {
        return new JpaTransactionManager(regulusEntityManagerFactory);
    }

}
