package com.user.passwordrecovery.service;

public interface PasswordResetService {
    void sendPasswordResetEmail(String userEmail);
}
