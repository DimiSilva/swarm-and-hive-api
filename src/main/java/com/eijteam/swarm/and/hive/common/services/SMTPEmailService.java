package com.eijteam.swarm.and.hive.common.services;

import com.eijteam.swarm.and.hive.common.abstracts.AbstractEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SMTPEmailService extends AbstractEmailService {

    @Autowired
    private MailSender mailSender;

    @Override
    public void sendEmail(SimpleMailMessage simpleMailMessage) {
        mailSender.send(simpleMailMessage);
    }
}
