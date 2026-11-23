package cinemax.ui;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import cinemax.model.Proiezione;
import cinemax.service.AuthenticationService;
import cinemax.model.Utente;
import cinemax.service.ProiezioniService;

public class MenuConsole {
    private final Scanner scanner;

    private final AuthenticationService auth;
    private static final DateTimeFormatter FORMATO_INPUT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final ProiezioniService proiezioniService;

    public MenuConsole(AuthenticationService auth, ProiezioniService proiezioniService) {
        this.auth = auth;
        this.proiezioniService = proiezioniService;
        this.scanner = new Scanner(System.in);
    }

    public void avvia() throws IOException {

        boolean esci=false;

        while(!esci){
        stampaMenu();

        int scelta=leggiScelta();

        switch (scelta){

            case 1:
                login();
                break;

            case 2:
                registrati();
                break;

            case 3:
                menuGuest();
                break;

            case 4:
                esci = true;
                System.out.println("Arrivederci!");
                break;

            default:
                System.out.println("Scelta non valida, riprova.");


        }

        }



    }

    private void stampaMenu(){
        System.out.println("\n=== CINEMAX ===");
        System.out.println("1) Login");
        System.out.println("2) Registrati");
        System.out.println("3) Guest");
        System.out.println("4) Esci");
        System.out.print("Scelta: ");

    }

    private int leggiScelta(){
        try{
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }

    }

    static Double leggiDouble(Scanner scanner, String messaggio) {
        while (true) {
            System.out.print(messaggio);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                return null;
            }
            try {
                return Double.parseDouble(input.replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("Numero non valido, riprova.");
            }
        }
    }

    private LocalDate leggiData() {
        while (true) {
            String testo = scanner.nextLine().trim();

            if (testo.isEmpty()) {
                return null;                     // la data è facoltativa
            }
            try {
                return LocalDate.parse(testo, FORMATO_INPUT);
            } catch (DateTimeParseException e) {
                System.out.println("Data non valida, riprova.");
            }
        }
    }


    private void login(){
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        Utente u = auth.login(username, password);

        if (u == null) {
            System.out.println("Credenziali errate");
            return;
        }
        System.out.println("Benvenuto " + u.getNome() + "! Ruolo: " + u.getRuolo());

    }

    private void registrati() throws IOException {

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Cognome: ");
        String cognome = scanner.nextLine();
        System.out.print("Data di nascita (gg/mm/aaaa, invio per saltare): ");
        LocalDate data = leggiData();
        System.out.print("Domicilio: ");
        String domicilio = scanner.nextLine();
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        try {
            boolean registrato = auth.registraCliente(nome, cognome, data, domicilio, username, password);

            if (registrato) {
                System.out.println("Registrazione completata.");
            } else {
                System.out.println("Username già in uso.");
            }
        }catch (IOException e){
            System.out.println("Errore nel registrazione.");
        }
    }

    public void ricercaProiezioni(){

        //chiedo il titolo (non vuoto) e poi salvo in una var
        System.out.print("Inserisci il titolo del film (invio per saltare): ");
        String titolo = scanner.nextLine().trim();
        if(titolo.isEmpty()){
            titolo=null;
        }

        //chiedo il genere (non vuoto) e poi salvo in una var
        System.out.print("Inserisci il genere del film (invio per saltare): ");
        String genere = scanner.nextLine().trim();
        if(genere.isEmpty()){
            genere=null;
        }
        //chiedo datainizio (non vuoto) e poi salvo in una var
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.print("Inserisci la data di inizio del film [formato gg-mm-aaaa] (invio per saltare): ");
            String input = scanner.nextLine().trim();

            LocalDate dataInizio = null;
                if (!input.isEmpty()) {
                    try{
                    dataInizio = LocalDate.parse(input, formato);
                 }catch(DateTimeParseException e){
                    System.out.println("Formato non valido, data ignorata.");
                    }
                }

        //chiedo datafine (non vuoto) e poi salvo in una var

        System.out.print("Inserisci la data di fine del film [formato gg-mm-aaaa] (invio per saltare): ");
        String input1 = scanner.nextLine().trim();

        LocalDate dataFine = null;
        if (!input.isEmpty()) {
            try{
                dataFine = LocalDate.parse(input1, formato);
            }catch(DateTimeParseException e){
                System.out.println("Formato non valido, data ignorata.");
            }
        }
        //chiedo prezzomin (non vuoto) e poi salvo in una var
        Double prezzoMin = leggiDouble(scanner, "Inserisci il prezzo minimo (invio per saltare): ");


        //chiedo prezzomax (non vuoto) e poi salvo in una var
        Double prezzoMax = leggiDouble(scanner, "Inserisci il prezzo massimo (invio per saltare): ");

        List<Proiezione> risultati = proiezioniService.cercaProiezioni(titolo,genere,dataInizio,dataFine,prezzoMin,prezzoMax);

        if (risultati.isEmpty()){
            System.out.println("Nessuna proiezione trovata con i filtri inseriti.");
            return;
        }
        System.out.println("\nProiezioni trovate:");
        //for(..)
        for(int i=0;i<risultati.size();i++){
            Proiezione p = risultati.get(i);
            System.out.println((i+1)+ ") " + p);
        }

        //chiedo il numero, verifico e lo passo a visualizzaproiezioni()
        int numeroScelto = -1;
        while (true) {
            System.out.print("Seleziona il numero della proiezione (0 per annullare): ");
            String scelta = scanner.nextLine().trim();
            try {
                numeroScelto = Integer.parseInt(scelta);
                if (numeroScelto == 0) {
                    return;
                }
                if (numeroScelto >= 1 && numeroScelto <= risultati.size()) {
                    break;
                }
                System.out.println("Numero fuori intervallo. Inserisci un valore tra 1 e " + risultati.size() + ".");
            } catch (NumberFormatException e) {
                System.out.println("Inserisci un numero valido.");
            }
        }
        proiezioniService.visualizzaProiezioni(risultati, numeroScelto);

        //calcolare quanti posti ci sono in sala

    }




    private void menuGuest() throws IOException {
        //visualizzaProiezioni(), cercaProiezioni()

        boolean esci = false;
        while (!esci) {
            System.out.println("\nOpzioni disponibili:");
            System.out.println("1) Cerca e visualizza le proiezioni ");
            System.out.println("2) Registrati");
            System.out.println("3) Torna al menu principale");

            int scelta = leggiScelta();

            switch (scelta) {

                case 1:
                    ricercaProiezioni();
                    break;

                case 2:
                    registrati();
                    break;

                case 3:
                    esci = true;
                    break;

                default:
                    System.out.println("Scelta non valida, riprova.");
            }
        }


    }


}

