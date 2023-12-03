package kivipaperisakset;

import java.util.Random;

/**
 * Pelaaja-luokka kivi-paperi-sakset -peliä varten.
 * Sisältää metodit pelaajan valinnan tekemiseen ja voittojen laskemiseen.
 *
 * @author Ira Dook, Eetu Soronen
 */
public class Pelaaja {

    /*
     * Voittojen lukumäärä
     */
    private int voitot;

    /*
     * Random-luokkaa käytetään pelaajan valinnan arpomiseen
     */
    private final Random valitsija;


    public Pelaaja() {
        voitot = 0;
        valitsija = new Random();
    }

    /**
     * Valitse randomilla kivi, paperi tai sakset
     */
    public Valinta pelaajanValinta() {
        return switch (valitsija.nextInt(3)) {
            case 0 -> Valinta.KIVI;
            case 1 -> Valinta.PAPERI;
            case 2 -> Valinta.SAKSET;
            default -> null;
        };
    }

    /**
     * Lisää voittojen lukumäärää yhdellä
     */
    public void lisaaVoitto() {
        voitot++;
    }

    /*
     * Palauttaa voittojen lukumäärän
     */
    public int getVoitot() {
        return (voitot);
    }
}
