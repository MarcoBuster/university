package piastrelle;

import java.util.Objects;

/*
 * Questa classe immutabile astratta rappresenta una piastrella.
 * 
 * Tutte le piastrelle, a prescindere dal tipo, hanno due caratteristiche:
 * - il costo (unitario);
 * - la superficie, calcolata diversamente per ogni tipo.
 * 
 * L'attributo costo è definito in questa classe perché comune a tutte le sottoclassi.
 * Lo stato è modificato solo dal costruttore, che controlla l'RI. 
 * Non è quindi necessario scrivere il metodo repOK.
 */
public abstract class Piastrella implements Superficie {
    /*
     * RI: costoUnitario non deve essere null;
     *     costoUnitario > 0
     */
    private Integer costoUnitario;

    /*
     * Costruttore della classe.
     * 
     * Pre-condizioni: il parametro costo deve rispettare l'RI
     * Effetti collaterali: l'attributo costoUnitario viene impostato come il parametro
     */
    public Piastrella(Integer costo) {
        Objects.requireNonNull(costo);
        if (costo <= 0) {
            throw new IllegalArgumentException("Il costo deve essere strettamente maggiore di 0");
        }
        this.costoUnitario = costo;
    }

    /*
     * Post-condizioni: ritorna il costo unitario della piastrella
     * 
     * Lo scopo di questo metodo è permettere la lettura di costoUnitario senza doverlo settare a public
     * (e quindi permettere anche la scrittura)
     */
    @Override
    public Integer costo() {
        return this.costoUnitario;
    }

    /*
     * L'implementazione è affidata alle sottoclassi specializzate
     */
    @Override
    public abstract Integer superficie();
    
    /*
     * Post-condizioni: ritorna l'hash code dell'oggetto, considerante anche il suo tipo
     */
    @Override
    public int hashCode() {
        // Particolarità: viene utilizzato getClass().getSimpleName() per distinguere 
        // le varie istanze della classe.
        // In questo modo, se due oggetti hanno la stessa superficie e lo stesso costo ma
        // sono di un tipo diverso, avranno due hashCode diversi.
        // In questo modo il metodo funziona per tutte le sottoclassi, senza doverlo rimplementare
        return 31 * this.costo() * this.superficie() * Objects.hash(getClass().getSimpleName());
    }

    /*
     * Funzione di astrazione
     */
    public abstract String toString();
}
