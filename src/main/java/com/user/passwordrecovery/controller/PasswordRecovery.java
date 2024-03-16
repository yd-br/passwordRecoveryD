package com.user.passwordrecovery.controller;
import com.user.passwordrecovery.model.UserDto;
import com.user.passwordrecovery.service.PasswordResetService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@RestController
public class PasswordRecovery {

   @Autowired
    private PasswordResetService passwordResetService;

    @PostMapping("/reset-password/{userEmail}")
    public String resetPassword(@PathVariable String userEmail) {
        return passwordResetService.sendPasswordResetEmail(userEmail);
    }

@PostMapping("/updatepassword/")
    public ResponseEntity<String> updatePassword(@RequestParam ("token") String token, @RequestBody UserDto userDto) {
        passwordResetService.updatePasswordReset(token, userDto);
        return ResponseEntity.ok("Password reset email sent successfully");
    }

}
