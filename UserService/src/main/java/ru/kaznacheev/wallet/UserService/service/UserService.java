package ru.kaznacheev.wallet.UserService.service;

import ru.kaznacheev.wallet.UserService.dto.request.CreateUserDto;
import ru.kaznacheev.wallet.UserService.entity.User;

public interface UserService {
    void createUser(CreateUserDto createUserDto);
    User getUserByUsername(String username);
}
