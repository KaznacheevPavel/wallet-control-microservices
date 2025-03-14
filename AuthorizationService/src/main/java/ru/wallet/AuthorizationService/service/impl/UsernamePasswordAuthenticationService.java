package ru.wallet.AuthorizationService.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.wallet.AuthorizationService.dto.AuthenticationRequest;
import ru.wallet.AuthorizationService.entity.User;
import ru.wallet.AuthorizationService.repository.UserRepository;
import ru.wallet.AuthorizationService.service.AuthenticationService;
import ru.wallet.AuthorizationService.service.JwtService;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsernamePasswordAuthenticationService implements AuthenticationService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    @Override
    public String authenticate(AuthenticationRequest request) {
        Optional<User> user = userRepository.findByUsername(request.getUsername());
        if (user.isEmpty()) {
            throw new RuntimeException("Ошибка"); //TODO Заменить на кастомный exception
        }
        if (!passwordEncoder.matches(request.getPassword(), user.get().getPassword())) {
            throw new RuntimeException("Ошибка"); //TODO Заменить на кастомный exception
        }

        return jwtService.generate(user.get());
    }

}
