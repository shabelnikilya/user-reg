package ru.hollow.sync.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RegistrationDto(
        @JsonProperty("username")
        String username,
        @JsonProperty("password")
        String password,
        @JsonProperty("firstName")
        String firstName,
        @JsonProperty("secondName")
        String secondName,
        @JsonProperty("age")
        Integer age,
        @JsonProperty("role")
        String role
) {
}
