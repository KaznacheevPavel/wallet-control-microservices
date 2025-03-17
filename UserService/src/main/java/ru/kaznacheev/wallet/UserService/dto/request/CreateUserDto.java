package ru.kaznacheev.wallet.UserService.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateUserDto {
    private final String username;
    private final String email;
    private final String password;
}
