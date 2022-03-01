package algebretta;

/*
 * Classe concreta rappresentante una matrice nulla,
 * ovvero una matrice con tutti i componenti pari a 0
 */
public class MatriceNulla extends MatriceDensa {
    /*
     * |m|:     numero di righe di m
     * |m[i]|:  numero di colonne della riga m[i]
     * 
     * AF(m[0][0], m[0][1], m[0][(n-1)], m[1][0], ..., m[(n-1)][(n-1)]): 
     * matrice | 0    0  ... 0 | /\
     *         | 0   ... ... 0 | n
     *         | ... ... ... 0 | \/
     *            <-- n -->
     * 
     * RI(m[0][0], m[0][1], m[0][(n-1)], m[1][0], ..., m[(n-1)][(n-1)]): 
     * n > 0, |m| = n, per ogni i da 0 a (n-1) allora |m[i]| = n E
     *                 per ogni j da 0 a (n-1) allora m[i][j] = 0
     */

    /*
     * Costruttore principale della classe.
     * 
     * Pre-condizioni: un array di vettori rispettante l'invariante di rappresentazione
     * Post-condizioni: ritorna una MatriceNulla rappresentante la matrice data
     * Effetti collaterali: popola gli attributi 'elementi' e 'n', tramite il costruttore della superclasse
     */
    public MatriceNulla(final Vettore[] vettori) {
        super(vettori);

        if (!repOK()) {
            throw new BadMatrixException("la matrice inserita non è nulla");
        }
    }

    /*
     * Costruttore principale della classe.
     * 
     * Pre-condizioni: un array di array di interi rispettante l'invariante di rappresentazione
     * Post-condizioni: ritorna una MatriceNulla rappresentante la matrice data
     * Effetti collaterali: popola gli attributi 'elementi' e 'n', tramite il costruttore della superclasse
     */
    public MatriceNulla(final int[][] elementi) {
        super(elementi);

        if (!repOK()) {
            throw new BadMatrixException("la matrice inserita non è nulla");
        }
    }

    protected boolean repOK() {
        if (!super.repOK()) {
            return false;
        }

        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                if (this.elementi[i].val(j) != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
