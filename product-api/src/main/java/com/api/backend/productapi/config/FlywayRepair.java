package com.api.backend.productapi.config;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayRepair {

    @Bean
    public FlywayMigrationStrategy repair() {
        return flyway -> {
            // repair each script checksum
            flyway.repair();
            // before migration is executed
            flyway.migrate();
        };
    }
}
