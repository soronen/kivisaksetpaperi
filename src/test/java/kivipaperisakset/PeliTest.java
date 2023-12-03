package kivipaperisakset;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Peli-luokan testit
 */
class PeliTest {

    private final int turnauksenPituus = 5;
    private Pelaaja p1;
    private Pelaaja p2;
    private Peli peli;

    @BeforeEach
    void setUp() {
        this.p1 = new Pelaaja();
        this.p2 = new Pelaaja();
        this.peli = new Peli(p1, p2, turnauksenPituus);
    }

    @Test
    void pelaaPeliTest() {

        for (int i = 0; i < turnauksenPituus; i++) {
            String tulos = peli.pelaaPeli();
            assertTrue(tulos.equals(Tulos.PELAAJA1_VOITTI.getTeksti()) || tulos.equals(Tulos.PELAAJA2_VOITTI.getTeksti()) || tulos.equals(Tulos.TASAPELI.getTeksti()));
        }
    }

    @Test
    void turnausPaattynyt() {
        for (int i = 0; i <= turnauksenPituus; i++) {
            String tulos = peli.pelaaPeli();
        }
        assertTrue(peli.getTilanne().startsWith("Turnaus on päättynyt!"));
        assertTrue(peli.turnausLoppunut());
    }


    @Test
    void tarkistaTulosTeksti() {

        for (int i = 0; i < turnauksenPituus; i++) {
            String tulos = peli.pelaaPeli();
            assertTrue(tulos.equals(Tulos.PELAAJA1_VOITTI.getTeksti()) || tulos.equals(Tulos.PELAAJA2_VOITTI.getTeksti()) || tulos.equals(Tulos.TASAPELI.getTeksti()));
        }
    }

    @Test
    void getPelatutPelitTest() {

        assertEquals(0, peli.getPelatutPelit());

        // Play some games
        peli.pelaaPeli();
        assertEquals(1, peli.getPelatutPelit());

        // Play more games
        peli.pelaaPeli();
        peli.pelaaPeli();
        assertEquals(3, peli.getPelatutPelit());
    }

    @Test
    void pelaajienVoitot() {

        assertEquals(0, p1.getVoitot());
        assertEquals(0, p2.getVoitot());
        assertEquals(0, peli.getP1Voitot());
        assertEquals(0, peli.getP2Voitot());


    }
}
