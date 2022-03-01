package piastrelle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/*
 * Questa classe mutabile rappresenta una pavimentazione, ovvero
 * una collezione di piastrelle ed altre pavimentazioni. 
 * 
 * Per rappresentare lo stato, ho deciso di utilizzare una HashMap
 * che raccoglie tutte le superfici collezionate dalla classe e le loro rispettive quantità.
 */
public class Pavimentazione implements Superficie {
    /*
     * Mappa elementi.
     *     - chiave: la superficie
     *     - valore: la quantità della superficie nella pavimentazione
     * 
     * RI: elementi non può essere vuota o nulla
     *     elementi deve contenere solo superfici valide con l'RI specificato nell'interfaccia Superficie
     *     elementi deve contenere solo quantità strettamente positive e non nulle   
     *     elementi non deve contenere l'instanza della classe
     */
    private Map<Superficie, Integer> elementi;

    /*
     * Crea una nuova istanza della classe, vuota.
     * 
     * Effetti colleterali: viene inizializzato elementi con un HashSet vuoto
     */
    public Pavimentazione() {
        this.elementi = new HashMap<>();
        assert repOk();
    }

    /*
     * Crea una nuova istanza della classe, con già una superficie.
     * 
     * Pre-condizioni: riferirsi al metodo aggiungi()
     * Effetti colleterali: viene chiamato il metodo aggiungi() sui parametri
     */
    public Pavimentazione(Superficie s, Integer quantità) {
        this();
        aggiungi(s, quantità);
    }

    /*
     * Aggiunge una superficie alla pavimentazione
     * 
     * Pre-condizioni: una superficie da aggiungere, rispettante l'RI (vedere l'RI dell'interfaccia Superficie)
     *                 una quantità da aggiungere, non nulla e strettamente positiva
     * Effetti collaterali: aggiunge la superficie e la relativa quantità alla mappa
     */
    public void aggiungi(Superficie s, Integer quantità) {
        Superficie.controlla(s);
        if (s == this) {
            throw new IllegalArgumentException("Non è possibile aggiungere la pavimentazione a sé stessa!");
        }
        Objects.requireNonNull(quantità);
        if (quantità <= 0) {
            throw new IllegalArgumentException("La quantità deve essere strettamente positiva");
        }
        Integer vecchiaQuantità = elementi.get(s);
        if (vecchiaQuantità == null) {
            vecchiaQuantità = 0;
        }
        elementi.put(s, quantità+vecchiaQuantità);
        assert repOk();
    }

    /*
     * Post-condizioni: ritorna la superficie totale della pavimentazione
     */
    @Override
    public Integer superficie() {
        assert repOk();
        int somma = 0;
        for (Superficie s : this.elementi.keySet()) {
            // somma il risultato della moltiplicazione tra la superficie unitaria e la quantità
            somma += s.superficie() * this.elementi.get(s);
        }
        return somma;
    }

    /*
     * Post-condizioni: ritorna il costo totale della pavimentazione
     */
    @Override
    public Integer costo() {
        assert repOk();
        int somma = 0;
        for (Superficie s : this.elementi.keySet()) {
            // somma il risultato della moltiplicazione tra il costo unitario e la quantità
            somma += s.costo() * this.elementi.get(s);
        }
        return somma;
    }

    /*
     * Post-condizioni: ritorna l'hash code dell'oggetto
     */
    @Override
    public int hashCode() {
        return 31 * costo() * superficie() * Objects.hash(elementi);
    }

    @Override
    public boolean equals(Object obj) {
        Objects.requireNonNull(obj);
        if (!(obj instanceof Pavimentazione)) {
            return false;
        }
        Pavimentazione p = (Pavimentazione) obj;
        assert repOk();
        assert p.repOk();

        if (this.elementi.size() != p.elementi.size()) {
            return false;
        }
        Set<Superficie> keysets = new HashSet<>();
        keysets.addAll(this.elementi.keySet());
        keysets.addAll(p.elementi.keySet());
        for (Superficie elemento : keysets) {
            if (this.elementi.get(elemento) != this.elementi.get(elemento)) {
                return false;
            }
        }
        return true;
    }

    /*
     * Metodo per controllare l'invariante di rappresentazione
     */
    private boolean repOk() {
        Integer q;
        for (Superficie s : this.elementi.keySet()) {
            Superficie.controlla(s);
            q = this.elementi.get(s);
            Objects.requireNonNull(q);
            if (q < 0) {
                return false;
            }
            if (s == this) {
                return false;
            }
        }
        return true;
    }
}
