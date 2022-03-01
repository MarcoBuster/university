package piastrelle;

import java.util.Objects;

/*
 * Questa classe concreta immutabile rappresenta una piastrella romboidale.
 * Oltre agli attributi della piastrella generica, la classe rappresenta:
 * - la lunghezza della prima diagonale
 * - la lunghezza della seconda diagonale
 * ed implementa quindi il metodo superficie()
 * 
 * Lo stato è modificato solo dal costruttore, che controlla l'RI. 
 * Non è quindi necessario scrivere il metodo repOK.
 */
public class PiastrellaRomboidale extends Piastrella {
    /*
     * RI: primaDiagonale, secondaDiagonale non possono essere nulli
     *     primaDiagonale > 0
     *     secondaDiagonale > 0
     */
    private Integer primaDiagonale;
    private Integer secondaDiagonale;
    
    /*
     * Costruttore della classe.
     * 
     * Pre-condizioni: tutti i parametri devono rispettare l'RI di Piastrella e PiastrellaDiagonale
     * Effetti collaterali: gli attributi base e altezza vengono inizializzati
     */
    public PiastrellaRomboidale(Integer costo, Integer primaDiagonale, Integer secondaDiagonale) {
        super(costo);
        Objects.requireNonNull(primaDiagonale);
        Objects.requireNonNull(secondaDiagonale);
        if (primaDiagonale <= 0) {
            throw new IllegalArgumentException("La prima diagonale deve essere strettamente positiva");
        }
        if (secondaDiagonale <= 0) {
            throw new IllegalArgumentException("La seconda diagonale deve essere strettamente positiva");
        }
        this.primaDiagonale = primaDiagonale;
        this.secondaDiagonale = secondaDiagonale;
    }

    /*
     * Post-condizioni: ritorna la superficie della piastrella
     */
    @Override
    public Integer superficie() {
        // Calcolo area del rombo
        return (this.primaDiagonale * this.secondaDiagonale) / 2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Piastrella romboidale [");
        sb.append(String.format("costo=%d, ", costo()));
        sb.append(String.format("superficie=%d, ", superficie()));
        sb.append(String.format("prima diagonale=%d, ", primaDiagonale));
        sb.append(String.format("seconda diagonale=%d]", secondaDiagonale));
        return sb.toString();
    } 
    
}
