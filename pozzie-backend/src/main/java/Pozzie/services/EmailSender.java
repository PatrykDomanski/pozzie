package Pozzie.services;

import org.springframework.stereotype.Service;

@Service
public interface EmailSender {
    void sendEmail(String to, String subject, String content);
}
