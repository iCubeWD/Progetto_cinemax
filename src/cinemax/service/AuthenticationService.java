package cinemax.service;

import cinemax.model.Utente;

public class AuthenticationService {

    private final String username;
    private final String password;

    public AuthenticationService(String username, String password) {
        this.username = username;
        this.password = password;

    }


}
