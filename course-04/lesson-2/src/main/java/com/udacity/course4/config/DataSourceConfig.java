package com.udacity.course4.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    // implement method to return a DataSource object
    // Reference: https://docs.oracle.com/javase/8/docs/api/javax/sql/DataSource.html
    // to programmatically configure datasource properties: url, password, user
    @Bean
    @Primary // let Spring knows which beans to use by default of that type
    @ConfigurationProperties(prefix="com.udacity.datasource")
    public DataSource getDatasource() {
        // use DataSourceBuilder class to programmatically configure DataSource properties:
        // Reference: https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/jdbc/DataSourceBuilder.html
        DataSourceBuilder dsb = DataSourceBuilder.create();
        dsb.url("jdbc:mysql://localhost:3306/plant");
        return dsb.build();
    }
}
