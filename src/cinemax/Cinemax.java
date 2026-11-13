package cinemax;
import cinemax.model.Proiezione;
import cinemax.service.AuthenticationService;
import cinemax.service.PasswordCript;
import cinemax.ui.MenuConsole;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Cinemax {
    public static void main(String[] args) throws IOException {

        AuthenticationService auth = new AuthenticationService();


        MenuConsole menu = new MenuConsole(auth);
        menu.avvia();



        //  ProiezioniService proiezioniService = new ProiezioniService();

        //List<Proiezione> risultato = proiezioniService.cercaProiezioni(null,null,null,null,null,null);
        //System.out.println("Proiezioni trovate: " + risultato.size());





    }
}

