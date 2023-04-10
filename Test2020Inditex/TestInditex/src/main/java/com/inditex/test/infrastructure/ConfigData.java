package com.inditex.test.infrastructure;
import com.inditex.test.infrastructure.inputadapter.rest.mappers.PriceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;

@Configuration
@RequiredArgsConstructor
@ComponentScan(basePackages = "com.inditex.test.infrastructure.inputadapter.rest.mappers")
public class ConfigData implements CommandLineRunner {

    private final DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        Connection connection = dataSource.getConnection();

        ClassPathResource resource = new ClassPathResource("sql/data.sql");
        ScriptUtils.executeSqlScript(connection, new EncodedResource(resource, StandardCharsets.UTF_8));
    }
    @Bean
    public PriceMapper priceMapper() {
        return PriceMapper.INSTANCE;
    }

}
