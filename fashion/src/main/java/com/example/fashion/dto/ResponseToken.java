package com.example.fashion.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseToken {
    private String accessToken;
    private String tokenType = "Bearer";
    public ResponseToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
