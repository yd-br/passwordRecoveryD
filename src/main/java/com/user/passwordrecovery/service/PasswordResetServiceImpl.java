package com.user.passwordrecovery.service;

import com.user.passwordrecovery.model.User;
import com.user.passwordrecovery.model.UserDto;
import com.user.passwordrecovery.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.GsonBuilderUtils;
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

    public String sendPasswordResetEmail(String userEmail) {

             User user = userRepo.findByEmail(userEmail);

        if (user != null) {// Generate reset token and link
      //  String resetToken = new PasswordResetTokenGenerator().generateToken();
            String resetToken = "trawler92";
            user.setToken(resetToken);
            userRepo.save(user);
            String resetLink = "http://localhost:8080/updatepassword?token=" + resetToken;
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(emailFrom);
        mailMessage.setTo(userEmail);
        mailMessage.setSubject("Password Reset Request");
            System.out.println(resetLink + " " );
        mailMessage.setText("To reset your password, click the following link: " + resetLink);
        javaMailSender.send(mailMessage);

      return "mail sent successfully....";
    }
        return "Email not found";
    }

    @Override
    public void updatePasswordReset(String token, UserDto userDto) {
        String email = userDto.getEmail();
        System.out.println(email);
        System.out.println(userDto.getPassword());
        User user = userRepo.findByEmail(email);

        if (user.getToken().equals(token)){
            user.setPassword(userDto.getPassword());
            userRepo.save(user);
            System.out.println("password updated successfully");
        }

    }
    /*public boolean isTokenValid(String token) {
        // Check if the token is valid (e.g., not expired)
        return false;
    }*/
   }
