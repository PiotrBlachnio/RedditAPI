package com.piotrblachnio.reddit.dto.request;

import javax.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @Email(message = "Email should be valid")
    @Size(min = 5, max = 64, message = "Email should be between 5 and 64 characters")
    @NotEmpty(message = "Email cannot be empty")
    private String email;

    @Size(min = 3, max = 32, message = "Username should be between 3 and 32 characters")
    @NotEmpty(message = "Username cannot be empty")
    private String username;

    @Size(min = 5, max = 64, message = "Password should be between 5 and 64 characters")
    @NotEmpty(message = "Password cannot be empty")
    private String password;
}