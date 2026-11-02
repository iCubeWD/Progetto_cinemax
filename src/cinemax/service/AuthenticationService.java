// gestisce il login e registrazione
package cinemax.service;

import cinemax.model.Ruolo;
import cinemax.model.Utente;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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

}



