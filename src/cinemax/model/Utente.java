package cinemax.model;

import java.time.LocalDate;

//la password è mia?

public class Utente {

    private final String nome;
    private final String cognome;
    private final String username;
    private final String password;
    private final String domicilio;
    private final Ruolo ruolo;
    private final LocalDate dataNascita;

    public Utente(String nome, String cognome, String username, String password, LocalDate dataNascita, String domicilio, Ruolo ruolo) {

        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.password = password;
        this.dataNascita = dataNascita;
        this.domicilio = domicilio;
        this.ruolo = ruolo;
    }


    public String getNome() {

        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    public String getDomicilio() {
        return domicilio;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public boolean passwordCorretta(String tentativo) {
        return password.equals(tentativo);
    }

    @Override
    public String toString() {
        return nome + " " + cognome + " (" + username + ", " + ruolo + ")";
    }
}
