package cinemax.ui;
import java.util.Scanner;

public class MenuConsole {
    private final Scanner scanner;
    Scanner sc = new Scanner(System.in);

    public MenuConsole() {
        this.scanner = new Scanner(System.in);

    }

    public void avvia(){

        boolean esci=false;

        while(!esci){
        stampaMenu();

        int scelta=leggiScelta();

        switch (scelta){

            case 1:

                break;

            case 2:
                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                esci=true;
                System.out.println("Arrivederci!");
                    break;

            default:
                System.out.println("Scelta non valida, riprova.");


        }

        }



    }

    private void stampaMenu(){
        System.out.println("\n=== CINEMAX ===");
        System.out.println("1) Cliente");
        System.out.println("2) Proiezionista");
        System.out.println("3) Bigliettaio");
        System.out.println("4) Guest");
        System.out.println("5) Esci");
        System.out.print("Scelta: ");

    }

    private int leggiScelta(){
        try{
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }

    }
}

