package com.eijteam.swarm.and.hive.configs;

import com.eijteam.swarm.and.hive.common.interfaces.IEmailService;
import com.eijteam.swarm.and.hive.common.services.DBService;
import com.eijteam.swarm.and.hive.common.services.MockEmailService;
import com.eijteam.swarm.and.hive.common.services.SMTPEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig implements CommandLineRunner {

    @Autowired
    private DBService dbService;

    @Override
    public void run(String... args) throws Exception {
        //dbService.instantiateSeed();
    }

    @Bean
    public IEmailService emailService() {
        return new SMTPEmailService();
    }
}
