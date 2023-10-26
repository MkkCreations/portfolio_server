package com.mkkcreations.portfolio_server.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ChangePassDTO {
    private String actualPassword;
    private String newPassword;
    private String confirmPassword;
}
