package com.inditex.test.infraestructura.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;

@Configuration
public class ConfigData implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        Connection connection = dataSource.getConnection();

        ClassPathResource resource = new ClassPathResource("sql/data.sql");
        ScriptUtils.executeSqlScript(connection, new EncodedResource(resource, StandardCharsets.UTF_8));
    }
}
