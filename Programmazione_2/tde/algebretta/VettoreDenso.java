package algebretta;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Classe concreta rappresentante un vettore denso, 
 * ovvero un vettore con elementi
 */
public class VettoreDenso implements Vettore {
    /*
     * |v|: numero di elementi in v
     * AF(v[0], v[1], ..., v[(n-1)]): vettore {v[0], v[1], ..., v[(n-1)]}
     * RI(v[0], v[1], ..., v[(n-1)]): n > 0, |v| = n  
     */
    private final int[] elementi;
    private final int n;  // Dimensione del Vettore

    /*
     * Costruttore principale della classe.
     * 
     * Pre-condizioni: un array di elementi rispettante l'invariante di rappresentazione
     * Post-condizioni: ritorna un VettoreDenso rappresentante il vettore dato
     * Effetti collaterali: popola gli attributi 'elementi' e 'n'
     */
    public VettoreDenso(final int[] elementi) {
        this.elementi = elementi;
        this.n = elementi.length;
        assert repOK();
    }

    @Override
    public int dim() {
        assert repOK();
        return this.n;
    }

    @Override
    public int val(final int i) {
        assert repOK();
        if (i >= this.dim() || i < 0) {
            throw new IllegalArgumentException("i deve essere strettamente minore della dimensione del vettore e maggiore o uguale a zero");
        }
        return this.elementi[i];
    }

    @Override
    public Vettore per(final int alpha) {
        assert repOK();
        
        int[] risultato = new int[this.n];
        for (int i = 0; i < this.n; i++) {
            risultato[i] = this.val(i) * alpha;
        }
        return new VettoreDenso(risultato);
    }

    @Override
    public Vettore più(final Vettore v) {
        assert repOK();
        assert ((VettoreDenso) v).repOK();

        if (this.dim() != v.dim()) {
            throw new IllegalArgumentException("v deve avere la stessa dimensione del vettore");
        }

        int[] risultato = new int[this.n];
        for (int i = 0; i < this.n; i++) {
            risultato[i] = this.val(i) + v.val(i);
        }
        return new VettoreDenso(risultato);
    }

    /*
     * Post-condizioni: ritorna un iteratore per la classe
     */
    public Iterator<Integer> getIterator() {
        assert repOK();

        Iterator<Integer> iterator = new Iterator<Integer>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < n;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return elementi[this.i++];
            }
        };
        return iterator;
    }

    /*
     * Funzione di astrazione
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        
        Iterator<Integer> iterator = getIterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (iterator.hasNext()) {
                sb.append(String.format("%d, ", next));
            } else {
                sb.append(String.format("%d)", next));
            }
        }
        return sb.toString();
    }

    /*
     * Controllo dell'invariante di rappresentazione
     */
    private boolean repOK() {
        return this.n > 0 && this.elementi.length == this.n;
    }
    
}
