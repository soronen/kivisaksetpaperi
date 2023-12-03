package kivipaperisakset;

/**
 * Enumeraatio pelin tuloksille. Jokaisella tuloksella on teksti, jota voi muuttaa tarvittaessa.
 */
public enum Tulos {

    PELAAJA1_VOITTI("Pelaaja 1 voitti!"), PELAAJA2_VOITTI("Pelaaja 2 voitti!"), TASAPELI("Tasapeli");

    /**
     * Enumeraation teksti
     */
    private final String teksti;

    /**
     * Konstruktori enumeraatiolle
     *
     * @param teksti enumeraation teksti
     */
    private Tulos(String teksti) {
        this.teksti = teksti;
    }

    /**
     * Palauttaa tuloksen tekstin
     *
     * @return tuloksen teksti
     */
    public String getTeksti() {
        return teksti;
    }
}
