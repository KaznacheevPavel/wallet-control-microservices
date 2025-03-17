package ru.kaznacheev.wallet.UserService.dto;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class BaseResponse {
    private final String status;
    private final int code;
    private final String detail;
}
