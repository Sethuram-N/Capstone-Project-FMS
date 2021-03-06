package com.capstone.fmsevent.configuration;

import com.github.jasync.r2dbc.mysql.JasyncConnectionFactory;
import com.github.jasync.sql.db.mysql.pool.MySQLConnectionFactory;
import com.github.jasync.sql.db.mysql.util.URLParser;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import java.nio.charset.StandardCharsets;

@Configuration
@EnableR2dbcRepositories
public class DBConfiguration extends AbstractR2dbcConfiguration {

    @Override
    @Bean
    public ConnectionFactory connectionFactory() {
        String url = "mysql://root:root123@localhost:3306/testdb";
        return new JasyncConnectionFactory(new MySQLConnectionFactory
                (URLParser.INSTANCE.parseOrDie(url, StandardCharsets.UTF_8)));

    }
}
