package com.eijteam.swarm.and.hive.common.services;

import com.eijteam.swarm.and.hive.common.abstracts.AbstractEmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

public class MockEmailService extends AbstractEmailService {

    private static final Logger logger = LoggerFactory.getLogger(MockEmailService.class);

    @Override
    public void sendEmail(SimpleMailMessage simpleMailMessage) {
        logger.info("Simulando envio de email...");
        logger.info(simpleMailMessage.toString());
        logger.info("Email enviado");
    }
}
