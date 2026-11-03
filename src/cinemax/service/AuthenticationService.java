// gestisce il login e registrazione
package cinemax.service;

import cinemax.model.Ruolo;
import cinemax.model.Utente;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AuthenticationService {

    private final List<Utente> utenti = new ArrayList<>();

    public AuthenticationService() throws IOException {
        caricaUtenti();
    }

    private void caricaUtenti() throws IOException {
        List<String> righe = Files.readAllLines(Paths.get("data", "utenti.csv"));

        for (int i = 1; i < righe.size(); i++) {
            if (righe.get(i).isBlank()) {
                continue;      // salta le righe vuote
            }
            String[] c = righe.get(i).split(";", -1);
            LocalDate nascita = c[4].isEmpty() ? null : LocalDate.parse(c[4]); //poiché la data è facoltativa, se c[4] è vuoto da' null, sennò da' la data
            Utente u = new Utente(c[0], c[1], c[2], c[3], nascita, c[5], Ruolo.valueOf(c[6]));
            utenti.add(u);

        }

    }

    public Utente login(String username, String password) {
        for (Utente u : utenti) {
            if (u.getUsername().equals(username) && u.passwordCorretta(password)) {
                return u;      // trovato: restituisco l'utente
            }
        }
        return null;           // nessun utente corrisponde
    }

    public boolean registraCliente(String nome, String cognome, LocalDate data, String domicilio, String username, String password) throws IOException{
        //controllo se lo username esiste già
        for(Utente u : utenti) {
            if (u.getUsername().equals(username)) {
                return false;
            }
        }
        //lo username è nuovom quindi creo l'utente
            Utente nuovo = new Utente(nome, cognome, username, password, data, domicilio, Ruolo.CLIENTE);

        //preparo la riga del file con .joim
            String dataTesto = (data == null) ? "" : data.toString();
            String riga = String.join(";", nome, cognome, username, password, dataTesto, domicilio, "CLIENTE"); //unisce i pezzi mettendo il ; in mezzo, nello stesso ordine delle colonne del file: nome, cognome, username, password, data, domicilio, ruolo

        //scrivo in fondo al file
        //scrivo in fondo al file (l'a capo va prima, così il nuovo utente parte sempre su una riga nuova)
        Files.writeString(Paths.get("data", "utenti.csv"), "\n" + riga, StandardOpenOption.APPEND);

        //aggiungo alla lista in memoria
        utenti.add(nuovo);
            return true;

        }
    }




