package ru.kaznacheev.wallet.UserService.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.kaznacheev.wallet.UserService.dto.BaseResponse;
import ru.kaznacheev.wallet.UserService.dto.ResponseWithData;
import ru.kaznacheev.wallet.UserService.dto.request.CreateUserDto;
import ru.kaznacheev.wallet.UserService.entity.User;
import ru.kaznacheev.wallet.UserService.service.UserService;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse createUser(@RequestBody CreateUserDto createUserDto) {
        userService.createUser(createUserDto);
        return BaseResponse.builder()
                .status("CREATED")
                .code(HttpStatus.CREATED.value())
                .detail("Аккаунт успешно зарегистрирован")
                .build();
    }

    @GetMapping("/{username}")
    public ResponseWithData getUser(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        return ResponseWithData.builder()
                .status("SUCCESS")
                .code(HttpStatus.OK.value())
                .detail("Пользователь успешно получен")
                .data(Map.of("username", user.getUsername(), "email", user.getEmail()))
                .build();
    }

}
