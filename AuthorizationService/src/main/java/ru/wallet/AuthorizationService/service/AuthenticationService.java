package ru.wallet.AuthorizationService.service;

import ru.wallet.AuthorizationService.dto.AuthenticationRequest;

public interface AuthenticationService {
    String authenticate(AuthenticationRequest request);
}
