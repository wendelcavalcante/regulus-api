package br.jus.trece.regulusApi.db.blank;

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
@EnableJpaRepositories(entityManagerFactoryRef = "blankEntityManagerFactory",
    transactionManagerRef = "blankTransactionManager", basePackages = {"br.jus.trece.regulusApi.db.blank.repo"})
public class BlankDbConfig {
        @Bean(name = "blankDataSource")
    @ConfigurationProperties(prefix = "blank.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "blankEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean blankEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("blankDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource).packages("br.jus.trece.regulusApi.db.blank.domain").persistenceUnit("blank")
                .build();
    }

    @Bean(name = "blankTransactionManager")
    public PlatformTransactionManager blankTransactionManager(
            @Qualifier("blankEntityManagerFactory") EntityManagerFactory blankEntityManagerFactory) {
        return new JpaTransactionManager(blankEntityManagerFactory);
    }

    @Bean
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder() {
        return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new HashMap<>(), null);
    }
}
