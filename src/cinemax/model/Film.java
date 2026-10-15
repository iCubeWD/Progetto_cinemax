package cinemax.model;



public class Film {

    private final String titolo;
    private final String genere;
    private final String regista;
    private final int anno;
    private final int durataMinuti;
    private final int etaMinima;

    //costruttore + get

    public Film(String titolo, String genere, String regista, int anno, int durataMinuti, int etaMinima) {
        this.titolo = titolo;
        this.genere = genere;
        this.regista = regista;
        this.anno = anno;
        this.durataMinuti = durataMinuti;
        this.etaMinima = etaMinima;

    }

    public String getTitolo() {
        return titolo;
    }

    public String getGenere() {
        return genere;
    }

    public String getRegista() {
        return regista;
    }

    public int getAnno() {
        return anno;
    }

    public int getDurataMinuti() {
        return durataMinuti;

    }
    public int getEtaMinima() {
        return etaMinima;
    }



    @Override
    public String toString() {
        return titolo + " (" + anno + ") - " + genere + ", regia di " + regista
                + ", " + durataMinuti + " min, età minima " + etaMinima;
    }
    }

