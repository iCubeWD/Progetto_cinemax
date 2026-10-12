package cinemax.model;

import java.time.LocalDateTime;

public class Prenotazione {

    private final String codice;
    private final String username;     // chi ha prenotato
    private Proiezione proiezione;
    private int numBiglietti;
    // costruttore + getter

    public Prenotazione(String codice, String username, int numBiglietti, Proiezione proiezione) {
        this.codice = codice;
        this.username = username;
        this.numBiglietti = numBiglietti;
        this.proiezione = proiezione;

    }

    public String getCodice() {
        return codice;
    }

    public String getUsername() {
        return username;
    }

    public int getNumBiglietti() {
        return numBiglietti;
    }

    public Proiezione getProiezione() {
        return proiezione;
    }

    public double getTotale() {
        return this.numBiglietti * proiezione.getPrezzo();
    }

    public void setNumBiglietti(int numBiglietti) {
        this.numBiglietti = numBiglietti;
    }


    public void setProiezione(Proiezione proiezione) {
        this.proiezione = proiezione;
    }

    @Override
    public String toString() {
        return "Prenotazione " + codice + " - cliente: " + username
                + "\n  " + proiezione
                + "\n  " + numBiglietti + " biglietti, totale "
                + String.format("%.2f", getTotale()) + " €";
    }

}


