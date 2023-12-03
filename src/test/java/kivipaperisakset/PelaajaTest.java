package kivipaperisakset;

import kivipaperisakset.Pelaaja;
import kivipaperisakset.Valinta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Pelaaja-luokan testit
 */
class PelaajaTest {

    @Test
    void pelaajanValintaTest() {
        Pelaaja pelaaja = new Pelaaja();

        for (int i = 0; i < 100; i++) {
            Valinta valinta = pelaaja.pelaajanValinta();
            assertTrue(valinta == Valinta.KIVI || valinta == Valinta.PAPERI || valinta == Valinta.SAKSET);
        }
    }

    @Test
    void lisaaVoittoTest() {
        Pelaaja pelaaja = new Pelaaja();

        assertEquals(0, pelaaja.getVoitot());

        // Simulate winning a game
        pelaaja.lisaaVoitto();

        assertEquals(1, pelaaja.getVoitot());

        // Simulate winning multiple games
        for (int i = 0; i < 5; i++) {
            pelaaja.lisaaVoitto();
        }

        assertEquals(6, pelaaja.getVoitot());
    }
}
