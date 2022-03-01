package algebretta;

/*
 * Questa interfaccia definisce i comportamenti
 * comuni a tutte le matrici quadrate
 */
public interface Matrice {
    /*
     * Post-condizioni: ritorna la dimensione della matrice
     */
    int dim();

    /*
     * Pre-condizioni: siano i, j interi >= 0 ed entrambi < dimensione della matrice
     * Post-condizioni: ritorna il valore dell'elemento posto nell'i-esima riga e j-esima colonna
     */
    int val(final int i, final int j);

    /*
     * Pre-condizioni: sia alpha un intero
     * Post-condizioni: ritorna una nuova matrice con tutti i componenti moltiplicati per lo scalare alpha
     */
    Matrice per(final int alpha);

    /*
     * Pre-condizioni: sia m una matrice delle stesse dimensioni della matrice considerata
     * Post-condizioni: ritorna una nuova matrice risultante della moltiplicazione con m
     */
    Matrice per(final Matrice m);

    /*
     * Pre-condizioni: sia v una vettore delle stesse dimensioni della matrice considerata
     * Post-condizioni: ritorna una nuovo vettore risultante della moltiplicazione con v
     */
    Vettore per(final Vettore v);

    /*
     * Pre-condizioni: sia m una matrice delle stesse dimensioni della matrice considerata
     * Post-condizioni: ritorna una nuova matrice risultante della somma con m
     */
    Matrice più(final Matrice m);
}
