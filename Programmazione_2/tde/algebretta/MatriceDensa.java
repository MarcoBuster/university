package algebretta;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Classe concreta rappresentante una matrice densa, 
 * ovvero una matrice con elementi
 */
public class MatriceDensa implements Matrice {
    /*
     * |m|:     numero di righe di m
     * |m[i]|:  numero di colonne della riga m[i]
     * 
     * AF(m[0][0], m[0][1], m[0][(n-1)], m[1][0], ..., m[(n-1)][(n-1)]): 
     * matrice | m[0][0]  m[0][1]  ...     m[0][(n-1)]  | /\
     *         | m[1][0]    ...    ...         ...      | n
     *         |   ...      ...    ...  m[(n-1)][(n-1)] | \/
     *                          <-- n -->
     * 
     * RI(m[0][0], m[0][1], m[0][(n-1)], m[1][0], ..., m[(n-1)][(n-1)]): 
     * n > 0, |m| = n, per ogni i da 0 a (n-1) allora |m[i]| = n
     */
    protected final Vettore[] elementi;
    protected final int n;

    /*
     * Costruttore principale della classe.
     * 
     * Pre-condizioni: un array di vettori rispettante l'invariante di rappresentazione
     * Post-condizioni: ritorna una MatriceDensa rappresentante la matrice data
     * Effetti collaterali: popola gli attributi 'elementi' e 'n'
     */
    public MatriceDensa(final Vettore[] vettori) {
        this.elementi = vettori;
        this.n = vettori.length;
        assert repOK();
    }

    /*
     * Costruttore principale della classe.
     * 
     * Pre-condizioni: un array di array di interi rispettante l'invariante di rappresentazione
     * Post-condizioni: ritorna una MatriceDensa rappresentante la matrice data
     * Effetti collaterali: popola gli attributi 'elementi' e 'n'
     */
    public MatriceDensa(final int[][] elementi) {
        this.n = elementi.length;
        Vettore[] risultato = new Vettore[this.n];
        for (int i = 0; i < this.n; i++) {
            risultato[i] = new VettoreDenso(elementi[i]);
        }
        this.elementi = risultato;
        assert repOK();
    }

    @Override
    public int dim() {
        assert repOK();
        return this.n;
    }

    /*
     * Pre-condizioni: siano i, j interi >= 0 ed entrambi < dimensione della matrice
     * Post-condizioni: ritorna il valore dell'elemento posto nell'i-esima riga e j-esima colonna
     */
    public int val(final int i, final int j) {
        assert repOK();

        if (i > this.dim() || i < 0) {
            throw new IllegalArgumentException("i deve essere strettamente minore della dimensione della matrice e maggiore o uguale a zero");
        }
        if (j > this.dim() || j < 0) {
            throw new IllegalArgumentException("j deve essere strettamente minore della dimensione della matrice e maggiore o uguale a zero");
        }
        return this.elementi[i].val(j);
    }

    /*
     * Pre-condizioni: sia alpha un intero
     * Post-condizioni: ritorna una nuova matrice con tutti i componenti moltiplicati per lo scalare alpha
     */
    public Matrice per(final int alpha) {
        assert repOK();

        Vettore[] risultato = new VettoreDenso[this.n];
        for (int i = 0; i < this.n; i++) {
            int[] risultatoRiga = new int[this.n];
            for (int j = 0; j < this.n; j++) {
                risultatoRiga[j] = this.val(i, j) * alpha;
            }
            risultato[i] = new VettoreDenso(risultatoRiga);
        }
        return new MatriceDensa(risultato);
    }

    /*
     * Pre-condizioni: sia m una matrice delle stesse dimensioni della matrice considerata
     * Post-condizioni: ritorna una nuova matrice risultante della moltiplicazione con m
     */
    public Matrice per(final Matrice m) {
        assert repOK();
        assert ((MatriceDensa) m).repOK();
        
        if (this.dim() != m.dim()) {
            throw new IllegalArgumentException("m deve avere la stessa dimensione della matrice");
        }

        Vettore[] risultato = new VettoreDenso[this.n];
        for (int i = 0; i < this.n; i++) {
            int[] risultatoRiga = new int[this.n];
            for (int j = 0; j < this.n; j++) {
                // Calcolando R[i, j]
                int sum = 0;
                for (int r = 0; r < this.n; r++) {
                    sum += this.val(i, r) * m.val(r, j);
                }
                risultatoRiga[j] = sum;
            }
            risultato[i] = new VettoreDenso(risultatoRiga);
        }
        return new MatriceDensa(risultato);
    }

    public Vettore per(final Vettore v) {
        assert repOK();
        
        if (this.n != v.dim()) {
            throw new IllegalArgumentException("m deve avere la stessa dimensione della matrice");
        }

        /*
         * Si ricorda che il prodotto matriciale tra M ed N è la matrice MN tale che (MN)ᵢⱼ = ∑ᵣ MᵢᵣNᵣⱼ. 
         * Inoltre, il prodotto della matrice M con il vettore v è il vettore Mv tale che (Mv)ᵢ = ∑ᵣ Mᵢᵣvᵣ. 
         * Si noti che, in entrambi i casi, n è la dimensione delle matrici e dei vettori coinvolti e 
         * la somma è per r che va da 0 a n-1.
         */

        int[] risultato = new int[this.n];
        for (int i = 0; i < this.n; i++) {
            int sum = 0;
            for (int r = 0; r < this.n; r++) {
                sum += this.val(i, r) * v.val(r);
            }
            risultato[i] = sum;
        }
        return new VettoreDenso(risultato);
    }

    /*
     * Pre-condizioni: sia m una matrice delle stesse dimensioni della matrice considerata
     * Post-condizioni: ritorna una nuova matrice risultante della somma con m
     */
    public Matrice più(final Matrice m) {
        MatriceDensa md = (MatriceDensa) m;

        assert repOK();
        assert md.repOK();

        if (this.n != md.n) {
            throw new IllegalArgumentException("m deve avere la stessa dimensione della matrice");
        }

        Vettore[] risultato = new VettoreDenso[this.n];
        for (int i = 0; i < this.n; i++) {
            int[] risultatoRiga = new int[this.n];
            for (int j = 0; j < this.n; j++) {
                risultatoRiga[j] = this.val(i, j) + m.val(i, j);
            }
            risultato[i] = new VettoreDenso(risultatoRiga);
        }
        return new MatriceDensa(risultato);
    }

    public Iterator<Vettore> getIterator() {
        assert repOK();

        Iterator<Vettore> iterator = new Iterator<Vettore>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < dim();
            }

            @Override
            public Vettore next() {
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
        sb.append("[");
        
        Iterator<Vettore> rowIterator = this.getIterator();
        while (rowIterator.hasNext()) {
            Vettore row = rowIterator.next();
            Iterator<Integer> colIterator = ((VettoreDenso) row).getIterator();
            while (colIterator.hasNext()) {
                Integer next = colIterator.next();
                sb.append(next.toString());
                if (colIterator.hasNext()) {
                    sb.append(", ");
                }
            }
            if (rowIterator.hasNext()) {
                sb.append("; ");
            } else {
                sb.append("]");
            }
        }
        return sb.toString();
    }
    
    /*
     * Controllo dell'invariante di rappresentazione
     */
    protected boolean repOK() {
        if (this.n < 0 || this.elementi.length != n) {
            return false;
        }

        Iterator<Vettore> rowIterator = this.getIterator();
        while (rowIterator.hasNext()) {
            Vettore row = rowIterator.next();
            if (row.dim() != n) {
                return false;
            }
        }
        return true;
    }
}
