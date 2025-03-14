package ru.wallet.AuthorizationService.service;

import ru.wallet.AuthorizationService.entity.User;

public interface JwtService {
    String generate(User user);
}
