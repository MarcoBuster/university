package algebretta;

/*
 * Questa interfaccia definisce i comportamenti
 * comuni a tutti i vettori
 */
public interface Vettore {
    /*
     * Post-condizioni: ritorna la dimensione del vettore
     */
    int dim();

    /*
     * Pre-condizioni: sia i un intero >= 0 e < dimensione del vettore
     * Post-condizioni: ritorna il valore dell'i-esima componente del vettore
     */
    int val(final int i);

    /*
     * Pre-condizioni: sia alpha un intero
     * Post-condizioni: ritorna un nuovo vettore con i componenti moltiplicati per lo scalare alpha
     */
    Vettore per(final int alpha);

    /*
     * Pre-condizioni: sia v un vettore della stessa dimensione del vettore considerato
     * Post-condizioni: ritorna un nuovo vettore con i componenti sommati per i componenti del vettore v
     */
    Vettore più(final Vettore v);
}
