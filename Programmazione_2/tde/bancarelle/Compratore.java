package bancarelle;

import java.util.Objects;
import java.util.Set;

/*
 * Classe astratta rappresentante un compratore.
 */
public abstract class Compratore {
    /*
     * RI:  bancherelle non può essere null e deve contenere almeno un elemento.
     */
    protected final Set<Bancarella> bancherelle;

    public Compratore(final Set<Bancarella> bancherelle) {
        Objects.requireNonNull(bancherelle);
        if (bancherelle.size() == 0) {
            throw new IllegalArgumentException("L'insieme di bancherelle deve contenere almeno una bancarella");
        }
        this.bancherelle = bancherelle;
    }

    /*
     * Acquista un giocattolo per una data quantità
     */
    public abstract Acquisto compra(final int num, final Giocattolo giocattolo);

    protected boolean repOk() {
        return bancherelle.size() > 0;
    }
}
