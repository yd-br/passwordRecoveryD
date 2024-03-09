package com.user.passwordrecovery.service;

import com.user.passwordrecovery.model.User;
import com.user.passwordrecovery.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class PasswordResetServiceImpl implements PasswordResetService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String emailFrom;

    @Autowired
    private UserRepo userRepo;

    public void sendPasswordResetEmail(String userEmail) {
        User user = userRepo.findByEmail(userEmail);
        if (user != null) {// Generate reset token and link
//        String resetToken = new PasswordResetTokenGenerator().generateToken();
            String resetToken = "trawler92";
            user.setToken(resetToken);
            userRepo.save(user);
            String resetLink = "http://localhost:8080/updatepassword?token=" + resetToken;
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(emailFrom);
        mailMessage.setTo(userEmail);
        mailMessage.setSubject("Password Reset Request");
        mailMessage.setText("To reset your password, click the following link: " + resetLink);
        javaMailSender.send(mailMessage);}
    }
    /*public boolean isTokenValid(String token) {
        // Check if the token is valid (e.g., not expired)
        return false;
    }

    public void resetPassword(String token, String newPassword) {
        // Update the user's password with the new password
    }*/
}
