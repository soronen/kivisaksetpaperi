package kivipaperisakset;

/**
 * Main-luokka, joka käynnistää pelin.
 * turnauksenPituus määrittää kuinka monta peliä pelataan.
 * Lopuksi luokkka tulostaa turnauksen loppukatsauksen.
 *
 * @author Eetu Soronen
 */
public class Main {

    /**
     * Main-metodi, joka käynnistää pelin.
     *
     * @param args komentoriviparametrit
     */
    public static void main(String args[]) {
        Pelaaja p1 = new Pelaaja();
        Pelaaja p2 = new Pelaaja();
        int turnauksenPituus = 100;
        Peli peli = new Peli(p1, p2, turnauksenPituus);

        while (!peli.turnausLoppunut()) {
            System.out.println(peli.pelaaPeli());
        }
        System.out.println(peli.getTilanne());
    }
}
