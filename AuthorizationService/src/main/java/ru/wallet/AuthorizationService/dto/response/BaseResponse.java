package ru.wallet.AuthorizationService.dto.response;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class BaseResponse {
    private final int code;
    private final String status;
    private final String detail;
}
