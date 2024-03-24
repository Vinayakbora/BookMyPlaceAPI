package com.bajaj.bookmyplace.models;

public class LoginResponse {

    private String token;
    private String username;
    private String email;

    private ErrorModel errorModel;

    public LoginResponse(String token, String username, String email, ErrorModel errorModel) {
        this.token = token;
        this.username = username;
        this.email = email;
        this.errorModel = errorModel;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ErrorModel getErrorModel() {
        return errorModel;
    }

    public void setErrorModel(ErrorModel errorModel) {
        this.errorModel = errorModel;
    }
}
