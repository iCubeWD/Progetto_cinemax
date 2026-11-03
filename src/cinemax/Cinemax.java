package cinemax;
import cinemax.service.AuthenticationService;
import cinemax.ui.MenuConsole;

import java.io.IOException;


public class Cinemax {
    public static void main(String[] args) throws IOException {

        AuthenticationService auth = new AuthenticationService();

        MenuConsole menu = new MenuConsole(auth);
        menu.avvia();






    }
}

