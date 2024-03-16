package com.user.passwordrecovery.service;

import com.user.passwordrecovery.model.UserDto;

public interface PasswordResetService {
    String sendPasswordResetEmail(String userEmail);

    void updatePasswordReset(String token, UserDto userDto);
}
