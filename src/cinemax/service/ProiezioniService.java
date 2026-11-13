// Cerca proiezioni, dettagli proiezione
package cinemax.service;

import cinemax.model.Film;
import cinemax.model.Proiezione;
import cinemax.model.Ruolo;
import cinemax.model.Utente;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static cinemax.model.Proiezione.FORMATO;


/* public class ProiezioniService {

    private static final DateTimeFormatter FORMATO_FILE = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final ArrayList<Proiezione> proiezioni = new ArrayList<Proiezione>();
    //private final ArrayList<Film> film = new ArrayList<Film>();

    public ProiezioniService() throws IOException {
        caricaProiezioni();
    }



    public void caricaProiezioni() throws IOException {
        List<String> righe = Files.readAllLines(Paths.get("data", "proiezioni.csv"));
        for (int i = 1; i < righe.size(); i++) {
            if (righe.get(i).isBlank()) { // salta le righe vuote
                continue;
            }
            String[] c = righe.get(i).split(";", -1);

            Proiezione p = new Proiezione(c[0], c[1], c[2], c[3], nascita, c[5], Ruolo.valueOf(c[6]));
            proiezioni.add(u);

        }

    }

    public List<Proiezione> cercaProiezioni(String titolo, String genere, LocalDate dataInizio, LocalDate datafine, Double prezzomin, Double prezzomax) {
        List<Proiezione> risultato = new ArrayList<>();

        for(Proiezione p : proiezioni){
                risultato.add(p);
        } return risultato;

    }

    public void visualizzaProiezioni() {

    }
*/


