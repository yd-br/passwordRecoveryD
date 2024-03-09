/*
package com.user.passwordrecovery.service;

import org.springframework.beans.factory.annotation.Autowired;

public class EmailServiceImpl implements EmailService{

    @Autowired
    private JavaMailSender javaMailSender;
    public void sendPasswordResetEmail(String email, String token) {
       */
/* Send an email containing a link with the password reset token
        You can use JavaMailSender or any other email sending library for this purpose
   *//*
 }
}
*/
/*
@Service
public class UserService {

    @Autowired
    private PasswordResetTokenService tokenService;

    public void initiatePasswordReset(String email) {
        // Generate a unique token
        String token = UUID.randomUUID().toString();
        // Associate the token with the user's email address
        tokenService.createPasswordResetToken(email, token);
        // Send the password reset email with the token
        sendPasswordResetEmail(email, token);
    }
}*/

