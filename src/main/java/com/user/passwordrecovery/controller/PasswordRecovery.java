package com.user.passwordrecovery.controller;
import com.user.passwordrecovery.service.PasswordResetService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@RestController
public class PasswordRecovery {

   @Autowired
    private PasswordResetService passwordResetService;

    @PostMapping("/reset-password")
    public String resetPassword(@RequestBody String userEmail) {
               passwordResetService.sendPasswordResetEmail(userEmail);

        return "Password reset email sent successfully!";
    }

/*@PostMapping("/updatepassword/{email}")
    public ResponseEntity<String> updatePassword(@RequestParam String token, @RequestBody String newPassword) {
        passwordResetService.updatePasswordReset(email, token, newPassword);
        return ResponseEntity.ok("Password reset email sent successfully");
    }*/

}
