package bancarelle;

import java.util.Map;

public class PoliticaMoltiplicativa extends ListinoAbs {

    public PoliticaMoltiplicativa(Map<Giocattolo, Integer> prezzi) {
        super(prezzi);
    }

    /*
     * Post-condizioni: prezzo dell'articolo basato su una semplice politica moltiplicativa
     *                  prezzo = prezzo unitario * quantità
     */
    @Override
    public int prezzo(Giocattolo g, int quantità) {
        try {
            super.prezzo(g, quantità);
        } catch(AbstractMethodError e) {
        }
        return this.prezzi.get(g) * quantità;
    }
}
