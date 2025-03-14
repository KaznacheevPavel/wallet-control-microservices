package ru.wallet.AuthorizationService.dto;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AuthenticationRequest {
    private final String username;
    private final String password;
}
