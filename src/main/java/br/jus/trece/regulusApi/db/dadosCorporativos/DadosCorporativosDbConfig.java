package br.jus.trece.regulusApi.db.dadosCorporativos;

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
@EnableJpaRepositories(entityManagerFactoryRef = "dadosCorporativosEntityManagerFactory",
    transactionManagerRef = "dadosCorporativosTransactionManager", basePackages = {"br.jus.trece.regulusApi.db.dadosCorporativos.repo"})
public class DadosCorporativosDbConfig {
        @Bean(name = "dadosCorporativosDataSource")
    @ConfigurationProperties(prefix = "dados-corporativos.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dadosCorporativosEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean dadosCorporativosEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("dadosCorporativosDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource).packages("br.jus.trece.regulusApi.db.dadosCorporativos.domain").persistenceUnit("dadosCorporativos")
                .build();
    }

    @Bean(name = "dadosCorporativosTransactionManager")
    public PlatformTransactionManager dadosCorporativosTransactionManager(
            @Qualifier("dadosCorporativosEntityManagerFactory") EntityManagerFactory dadosCorporativosEntityManagerFactory) {
        return new JpaTransactionManager(dadosCorporativosEntityManagerFactory);
    }

    /*@Bean
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder() {
        return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new HashMap<>(), null);
    }*/
}

