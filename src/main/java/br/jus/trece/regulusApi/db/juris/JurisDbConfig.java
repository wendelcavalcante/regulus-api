package br.jus.trece.regulusApi.db.juris;

import java.util.HashMap;

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
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "jurisEntityManagerFactory",
    transactionManagerRef = "jurisTransactionManager", basePackages = {"br.jus.trece.regulusApi.db.juris.repo"})
public class JurisDbConfig {
        @Bean(name = "jurisDataSource")
    @ConfigurationProperties(prefix = "juris.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "jurisEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean jurisEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("jurisDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource).packages("br.jus.trece.regulusApi.db.juris.domain").persistenceUnit("juris")
                .build();
    }

    @Bean(name = "jurisTransactionManager")
    public PlatformTransactionManager jurisTransactionManager(
            @Qualifier("jurisEntityManagerFactory") EntityManagerFactory jurisEntityManagerFactory) {
        return new JpaTransactionManager(jurisEntityManagerFactory);
    }

    @Bean
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder() {
        return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new HashMap<>(), null);
    }
}
