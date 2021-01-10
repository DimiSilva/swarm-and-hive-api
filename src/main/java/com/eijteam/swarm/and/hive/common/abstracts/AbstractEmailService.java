package com.eijteam.swarm.and.hive.common.abstracts;

import com.eijteam.swarm.and.hive.common.interfaces.IEmailService;
import com.eijteam.swarm.and.hive.modules.user.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;

public abstract class AbstractEmailService implements IEmailService {

    @Value("${default.sender}")
    private String sender;

    @Override
    public void sendRegisterConfirmationEmail(User user) {
        SimpleMailMessage simpleMailMessage = prepareSimpleMailMessageForRegisterConfirmation(user);
        sendEmail(simpleMailMessage);
    }

    protected SimpleMailMessage prepareSimpleMailMessageForRegisterConfirmation(User user) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(user.getEmail());
        simpleMailMessage.setFrom(sender);
        simpleMailMessage.setSubject("Cadastro feito com sucesso");
        simpleMailMessage.setSentDate(new Date(System.currentTimeMillis()));
        simpleMailMessage.setText("Bem vindo " + user.getUsername());
        return simpleMailMessage;
    }
}
