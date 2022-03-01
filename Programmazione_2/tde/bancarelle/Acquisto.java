package bancarelle;

import java.util.Map;
import java.util.Objects;

/*
 * Record immutabile rappresentante un acquisto.
 */
public record Acquisto(Giocattolo giocattolo, Integer quantità, Integer prezzo, Map<Bancarella, Integer> bancherelle) {
    /*
     * RI:  nessun attributo può essere null, quantità > 0 e prezzo > 0
     *      essendo il record immutabile, è sufficiente controllare la RI nel costruttore
     */
    public Acquisto {
        Objects.requireNonNull(giocattolo);
        Objects.requireNonNull(quantità);
        Objects.requireNonNull(prezzo);
        Objects.requireNonNull(bancherelle);

        if (quantità <= 0) {
            throw new IllegalArgumentException("La quantità di acqusito deve essere strettamente maggiore di zero");
        }
        if (prezzo <= 0) {
            throw new IllegalArgumentException("Il prezzo di acquisto deve essere strettamente maggiore di zero");
        }
    }

    /*
     * Funzione di astrazione
     */
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format(
            "Acquisto di: %s, numero: %d, per un costo di: %d", 
            this.giocattolo.toString(), this.quantità, this.prezzo
        ));
        
        for (Bancarella b : bancherelle.keySet()) {
            res.append(String.format("\n%s: %d", b.getProprietario(), bancherelle.get(b)));
        }
        return res.toString();
    }
}
