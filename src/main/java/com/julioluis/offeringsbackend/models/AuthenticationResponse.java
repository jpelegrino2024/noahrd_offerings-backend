package com.julioluis.offeringsbackend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class AuthenticationResponse {
//    @JsonProperty("access_token")
//    private String accessToken;
//
//    @JsonProperty("refresh_token")
//    private String refreshToken;
//
//    @JsonProperty("message")
//    private String message;

    private String token;


}
