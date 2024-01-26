package br.jus.trece.regulusApi.db.juris;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

public class JurisDbConfig {
        @Bean(name = "jurisDataSource")
    @ConfigurationProperties(prefix = "juris.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "jurisEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean barEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("jurisDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource).packages("br.jus.trece.regulusApi.db.juris.domain").persistenceUnit("juris")
                .build();
    }

    @Bean(name = "jurisTransactionManager")
    public PlatformTransactionManager jurisTransactionManager(
            @Qualifier("regulusEntityManagerFactory") EntityManagerFactory jurisEntityManagerFactory) {
        return new JpaTransactionManager(jurisEntityManagerFactory);
    }
}
