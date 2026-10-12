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

    public Utente(String nome, String cognome, String username, String password, String domicilio, Ruolo ruolo) {

        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.password = password;
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
    }   // serve per riscrivere il file


    public String getDomicilio() {
        return domicilio;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    @Override
    public String toString() {
        return nome + " " + cognome + " (" + username + ", " + ruolo + ")";
    }
}
