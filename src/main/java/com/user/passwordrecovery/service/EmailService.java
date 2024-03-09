package com.user.passwordrecovery.service;

public interface EmailService {
    public void sendPasswordResetEmail(String email, String token);
}
