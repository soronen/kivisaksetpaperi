package kivipaperisakset;

/**
 * Peli-luokka, joka sisältää kivi-paperi-sakset -pelin logiikan.
 * Turnauksen pituus määrittää kuinka monta peliä pelataan.
 * Pelaaja 1 ja 2 annetaan konstruktorissa.
 *
 * @author Ira Dook, Eetu Soronen
 */
public class Peli {

    /**
     * Pelaaja 1
     */
    private Pelaaja p1;
    /**
     * Pelaaja 2
     */
    private Pelaaja p2;

    /**
     * Pelattujen pelien lukumäärä
     */
    private int pelatutPelit = 0;

    /**
     * Turnauksen pituus, eli monta matsia pelataan
     */
    private int turnauksenPituus;

    /**
     * Konstruktori
     *
     * @param p1               Pelaaja 1
     * @param p2               Pelaaja 2
     * @param turnauksenPituus Turnauksen pituus, eli monta matsia pelataan
     */
    public Peli(Pelaaja p1, Pelaaja p2, int turnauksenPituus) {
        this.p1 = p1;
        this.p2 = p2;
        this.turnauksenPituus = turnauksenPituus;
    }

    /**
     * Pelaa yhden pelin ja palauttaa tuloksen
     *
     * @return pelin tulos
     */
    public String pelaaPeli() {
        if (turnausLoppunut()) {
            return getTilanne();
        }
        pelatutPelit++;
        Valinta p1Valinta = p1.pelaajanValinta();
        Valinta p2Valinta = p2.pelaajanValinta();

        return switch (p1Valinta) {
            case KIVI -> switch (p2Valinta) {
                case SAKSET -> {
                    p1.lisaaVoitto();
                    yield Tulos.PELAAJA1_VOITTI.getTeksti();
                }
                case PAPERI -> {
                    p2.lisaaVoitto();
                    yield Tulos.PELAAJA2_VOITTI.getTeksti();
                }
                default -> Tulos.TASAPELI.getTeksti();
            };
            case PAPERI -> switch (p2Valinta) {
                case KIVI -> {
                    p1.lisaaVoitto();
                    yield Tulos.PELAAJA1_VOITTI.getTeksti();
                }
                case SAKSET -> {
                    p2.lisaaVoitto();
                    yield Tulos.PELAAJA2_VOITTI.getTeksti();
                }
                default -> Tulos.TASAPELI.getTeksti();
            };
            case SAKSET -> switch (p2Valinta) {
                case PAPERI -> {
                    p1.lisaaVoitto();
                    yield Tulos.PELAAJA1_VOITTI.getTeksti();
                }
                case KIVI -> {
                    p2.lisaaVoitto();
                    yield Tulos.PELAAJA2_VOITTI.getTeksti();
                }
                default -> Tulos.TASAPELI.getTeksti();
            };
        };
    }

    /**
     * Palauttaa turnauksen tilanteen
     *
     * @return turnauksen tilanne
     */
    public String getTilanne() {
        if (turnausLoppunut()) {
            return "Turnaus on päättynyt! Lopputulokset: " + p1.getVoitot() + " - " + p2.getVoitot();
        }
        return "Pelaaja 1: " + p1.getVoitot() + " - Pelaaja 2: " + p2.getVoitot();
    }

    public boolean turnausLoppunut() {
        return pelatutPelit >= turnauksenPituus;
    }

    /**
     * Palauttaa pelattujen pelien lukumäärän
     *
     * @return pelattujen pelien lukumäärä
     */
    public int getPelatutPelit() {
        return pelatutPelit;
    }

    /**
     * Palauttaa pelaajan 1 voittojen lukumäärän
     *
     * @return pelaajan 1 voittojen lukumäärä
     */
    public int getP1Voitot() {
        return p1.getVoitot();
    }

    /**
     * Palauttaa pelaajan 2 voittojen lukumäärän
     *
     * @return pelaajan 2 voittojen lukumäärä
     */
    public int getP2Voitot() {
        return p2.getVoitot();
    }
}
