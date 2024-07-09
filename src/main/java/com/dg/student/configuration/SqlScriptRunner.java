package com.dg.student.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Component
public class SqlScriptRunner implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SqlScriptRunner(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        executeScript("schema.sql");
        executeScript("data.sql");
    }

    private void executeScript(String filename) throws Exception {
        ClassPathResource resource = new ClassPathResource(filename);
        if (resource.exists()) {
            try (InputStreamReader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
                String sql = FileCopyUtils.copyToString(reader);
                jdbcTemplate.execute(sql);
            }
        } else {
            throw new IllegalArgumentException("Script file not found: " + filename);
        }
    }
}

