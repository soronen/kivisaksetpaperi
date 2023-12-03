package kivipaperisakset;


/**
 * Enumeraatio pelin tuloksille. Jokaisella tuloksella on teksti, jota voi muuttaa tarvittaessa.
 */
public enum Valinta {

    KIVI("kivi"), PAPERI("paperi"), SAKSET("sakset");

    /**
     * Enumeraation teksti
     */
    private final String teksti;

    /**
     * Konstruktori enumeraatiolle
     *
     * @param teksti enumeraation teksti
     */
    private Valinta(String teksti) {
        this.teksti = teksti;
    }

    /**
     * Palauttaa valinnan tekstin
     *
     * @return valinnan teksti
     */
    public String getTeksti() {
        return teksti;
    }
}
