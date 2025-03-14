package ru.wallet.AuthorizationService.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.wallet.AuthorizationService.dto.AuthenticationRequest;
import ru.wallet.AuthorizationService.dto.response.BaseResponse;
import ru.wallet.AuthorizationService.dto.response.ResponseWithData;
import ru.wallet.AuthorizationService.service.AuthenticationService;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping
    public BaseResponse authentication(@RequestBody AuthenticationRequest request) {
        String jwt = authenticationService.authenticate(request);
        return ResponseWithData.builder()
                .code(HttpStatus.OK.value())
                .status("SUCCESS")
                .detail("Успешная аутентификация")
                .data(Map.of("access_token", jwt))
                .build();
    }

}
