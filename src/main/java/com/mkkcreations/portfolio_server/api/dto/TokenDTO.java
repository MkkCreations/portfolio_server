package com.mkkcreations.portfolio_server.api.dto;

import com.mkkcreations.portfolio_server.api.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TokenDTO {
    private User user;
    private String accessToken;
    private String refreshToken;
}