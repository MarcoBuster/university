package bancarelle;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

/*
 * Classe astratta raggruppante attributi, costruttori e metodi comuni per le implementazioni di Listino
 */
public abstract class ListinoAbs implements Listino {
    /*
     * RI: prezzi non può essere null, deve contenere almeno un elemento e i prezzi devono essere strettamente positivi.
     */
    protected final Map<Giocattolo, Integer> prezzi;

    public ListinoAbs(final Map<Giocattolo, Integer> prezzi) {
        Objects.requireNonNull(prezzi);
        this.prezzi = prezzi;

        assert repOk();
    }

    /*
     * Metodo astratto utilizzato solo per controllare le pre-condizioni.
     */
    @Override
    public int prezzo(Giocattolo g, int quantità) {
        assert repOk();

        // Controlla le pre-condizioni
        if (quantità <= 0) {
            throw new IllegalArgumentException("La quantità deve essere strettamente maggiore di zero");
        }
        if (this.prezzi.get(g) == null) {
            throw new NoSuchElementException("Il giocattolo non è presente nel listino");
        }

        // Il metodo è da ritenersi astratto
        throw new AbstractMethodError();
    }

    /*
     * Funzione di astrazione
     */
    public String toString() {
        // TODO
        return "";
    }

    private boolean repOk() {
        if (this.prezzi.size() == 0) {
            return false;
        }
        for (Giocattolo g : this.prezzi.keySet()) {
            if (this.prezzi.get(g) <= 0) {
                return false;
            }
        }
        return true;
    }
}
