package piastrelle;

/*
 * Interfaccia rappresentante i metodi comuni a tutte le superfici
 * (piastrelle o pavimentazioni).
 * 
 * RI: la superficie non deve essere nulla
 *     la superficie deve avere un costo > 0
 *     la superficie deve avere una dimensione > 0
 */
public interface Superficie {

    /*
     * Post-condizioni: ritorna la dimensione della superficie
     */
    public Integer superficie();

    /*
     * Post-condizioni: ritorna il costo totale della superficie
     */
    public Integer costo();

    /*
     * Metodo statico utilizzato per controllare che una superficie rispetti l'RI
     * 
     * Pre-condizioni: un oggetto che implementa l'interfaccia Superficie da controllare
     * Effetti collaterali: scatena SuperficieNonValidaException se la superficie non è valida.
     */
    public static void controlla(Superficie s) {
        if (s == null) {
            throw new SuperficieNonValidaException("La superficie non può essere nulla");
        }
        if (s.superficie() < 0) {
            throw new SuperficieNonValidaException("La dimensione della superficie deve essere strettamente positiva");
        }
        if (s.costo() < 0) {
            throw new SuperficieNonValidaException("Il costo della superficie deve essere strettamente positivo");
        }
    }
}
