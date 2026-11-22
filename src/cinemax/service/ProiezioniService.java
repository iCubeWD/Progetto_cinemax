// Cerca proiezioni, dettagli proiezione
package cinemax.service;

import cinemax.model.Film;
import cinemax.model.Proiezione;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class ProiezioniService {

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

            Film f = new Film(c[1],c[2],c[3],Integer.parseInt(c[4]),Integer.parseInt(c[5]),Integer.parseInt(c[6]));

            LocalDateTime dataOra = LocalDateTime.parse(c[0],FORMATO_FILE);

            Proiezione p = new Proiezione(f,dataOra,Double.parseDouble(c[7]));

            proiezioni.add(p);

        }

    }

    public List<Proiezione> cercaProiezioni(String titolo, String genere, LocalDate dataInizio, LocalDate datafine, Double prezzomin) {
        List<Proiezione> risultato = new ArrayList<>();

        for(Proiezione p : proiezioni){

            // titolo, anche parziale
            if(titolo!=null && !p.getFilm().getTitolo().toLowerCase().contains(titolo.toLowerCase()))
                continue;

            //genere, tipologia del film
            if(genere!=null && !p.getFilm().getGenere().toLowerCase().equals(genere.toLowerCase()))
                continue;

            //intervallo di date
            LocalDate giorno = p.getDataOra().toLocalDate();
            if(dataInizio != null && giorno.isBefore(dataInizio))
                continue;
            if(datafine != null && giorno.isAfter(datafine))
                continue;

            //costo dei biglietto
            if(prezzomin != null && p.getPrezzo() < prezzomin)
                continue;

            risultato.add(p);
        } return risultato;

    }

    public void visualizzaProiezioni() {

    }
     }



