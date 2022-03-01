package algebretta;

/*
 * Classe concreta rappresentante una matrice identità,
 * ovvero una matrice avente componenti fuori dalla diagonale pari a 0
 * e sulla diagonale pari a 1
 */
public class MatriceIdentità extends MatriceDiagonale {
    /*
     * |m|:     numero di righe di m
     * |m[i]|:  numero di colonne della riga m[i]
     * 
     * AF(m[0][0], m[0][1], m[0][(n-1)], m[1][0], m[1][1], ..., m[(n-1)][(n-1)]): 
     * matrice | 1  0  ... 0 | /\
     *         | 0  1  ... 0 | n
     *         | 0 ... ... 1 | \/
     *            <-- n -->
     * 
     * RI(m[0][0], m[0][1], m[0][(n-1)], m[1][0], m[1][1], ..., m[(n-1)][(n-1)]): 
     * n > 0, |m| = n, per ogni i da 0 a (n-1) allora |m[i]| = n E
     *                 per ogni j da 0 a (n-1) se i != j allora m[i][j] = 0 E
     *                                         se i == j allora m[i][j] = 1
     */

    /*
     * Costruttore principale della classe.
     * 
     * Pre-condizioni: un array di vettori rispettante l'invariante di rappresentazione
     * Post-condizioni: ritorna una MatriceIdentità rappresentante la matrice data
     * Effetti collaterali: popola gli attributi 'elementi' e 'n', tramite il costruttore della superclasse
     */
    public MatriceIdentità(final Vettore[] vettori) {
        super(vettori);

        if (!repOK()) {
            throw new BadMatrixException("la matrice inserita non è identità");
        }
    }

    /*
     * Costruttore principale della classe.
     * 
     * Pre-condizioni: un array di array di interi rispettante l'invariante di rappresentazione
     * Post-condizioni: ritorna una MatriceIdentità rappresentante la matrice data
     * Effetti collaterali: popola gli attributi 'elementi' e 'n', tramite il costruttore della superclasse
     */
    public MatriceIdentità(final int[][] elementi) {
        super(elementi);

        if (!repOK()) {
            throw new BadMatrixException("la matrice inserita non è identità");
        }
    }

    protected boolean repOK() {
        if (!super.repOK()) {
            return false;
        }

        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                if ((i != j && this.elementi[i].val(j) != 0) ||
                    (i == j && this.elementi[i].val(j) != 1)) {
                    return false;
                }
            }
        }
        return true;
    }
}
