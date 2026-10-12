package cinemax.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Proiezione {

    private final Film film;
    private LocalDateTime dataOra;   // non final: il proiezionista può modificarla
    private double prezzo;           // non final: modificabile se non ci sono prenotazioni
    // costruttore + getter + setter

    public Proiezione(Film film, LocalDateTime dataOra, double prezzo) {
        this.film = film;
        this.dataOra = dataOra;
        this.prezzo = prezzo;
    }

    public LocalDateTime getDataOra() {
        return dataOra;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public Film getFilm() {
        return film;
    }

    public LocalDateTime getFine() {
        return dataOra.plusMinutes(film.getDurataMinuti());
    }

    public void setDataOra(LocalDateTime dataOra) {
        this.dataOra = dataOra;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    // dentro la classe, tra i campi
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    @Override
    public String toString() {
        return film.getTitolo() + " - " + dataOra.format(FORMATO)
                + " - " + String.format("%.2f", prezzo) + " €";
    }

}
