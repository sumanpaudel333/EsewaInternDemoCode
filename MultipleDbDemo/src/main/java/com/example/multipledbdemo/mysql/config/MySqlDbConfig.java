package com.example.multipledbdemo.mysql.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "",
basePackages = {},
transactionManagerRef = "")
public class MySqlDbConfig {
}
