package com.mkkcreations.portfolio_server.api.dto;

import com.mkkcreations.portfolio_server.api.model.User;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TokenDTO {
    @Nullable
    private User user;
    private String accessToken;
    private String refreshToken;
}