package com.mkkcreations.portfolio_server.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefreshTokenDTO {
    private String refreshToken;

    public RefreshTokenDTO() {}
}
