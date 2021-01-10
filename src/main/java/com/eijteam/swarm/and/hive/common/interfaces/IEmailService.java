package com.eijteam.swarm.and.hive.common.interfaces;

import com.eijteam.swarm.and.hive.modules.user.entities.User;
import org.springframework.mail.SimpleMailMessage;

public interface IEmailService {
    void sendRegisterConfirmationEmail(User user);
    void sendEmail(SimpleMailMessage simpleMailMessage);
}
