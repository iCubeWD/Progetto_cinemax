package cinemax;
import cinemax.model.Proiezione;
import cinemax.service.AuthenticationService;
import cinemax.service.PasswordCript;
import cinemax.service.ProiezioniService;
import cinemax.ui.MenuConsole;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Cinemax {
    public static void main(String[] args) throws IOException {

        AuthenticationService auth = new AuthenticationService();


      //MenuConsole menu = new MenuConsole(auth);
        //menu.avvia();


        //test

        ProiezioniService p = new ProiezioniService();

        System.out.println(p.cercaProiezioni("lord of the rings",null,null,null,null,null));

        //List<Proiezione> risultato = proiezioniService.cercaProiezioni(null,null,null,null,null,null);
        //System.out.println("Proiezioni trovate: " + risultato.size());





    }
}

