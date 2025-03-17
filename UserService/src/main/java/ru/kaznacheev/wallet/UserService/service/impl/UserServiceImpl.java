package ru.kaznacheev.wallet.UserService.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kaznacheev.wallet.UserService.dto.request.CreateUserDto;
import ru.kaznacheev.wallet.UserService.entity.User;
import ru.kaznacheev.wallet.UserService.repository.UserRepository;
import ru.kaznacheev.wallet.UserService.service.UserService;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void createUser(CreateUserDto createUserDto) {
        if (userRepository.existsByUsername(createUserDto.getUsername())) {
            throw new RuntimeException();
        }
        if (userRepository.existsByEmail(createUserDto.getEmail())) {
            throw new RuntimeException();
        }
        User user = User.builder()
                .username(createUserDto.getUsername())
                .email(createUserDto.getEmail())
                .password(passwordEncoder.encode(createUserDto.getPassword()))
                .build();
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.orElseThrow(RuntimeException::new);
    }

}
