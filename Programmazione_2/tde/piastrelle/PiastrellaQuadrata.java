package piastrelle;

import java.util.Objects;

/*
 * Questa classe concreta immutabile rappresenta una piastrella quadrata.
 * Oltre agli attributi della piastrella generica, la classe rappresenta:
 * - la base del triangolo
 * - l'altezza del triangolo
 * ed implementa quindi il metodo superficie()
 * 
 * Lo stato è modificato solo dal costruttore, che controlla l'RI. 
 * Non è quindi necessario scrivere il metodo repOK.
 */
public class PiastrellaQuadrata extends Piastrella {
    /*
     * RI: lato non può essere nullo
     *     lato > 0
     */
    private Integer lato;

    /*
     * Costruttore della classe.
     * 
     * Pre-condizioni: tutti i parametri devono rispettare l'RI di Piastrella e PiastrellaQuadrata
     * Effetti collaterali: gli attributi base e altezza vengono inizializzati
     */
    public PiastrellaQuadrata(Integer costo, Integer lato) {
        super(costo);
        Objects.requireNonNull(lato);
        if (lato <= 0) {
            throw new IllegalArgumentException("Il lato non può essere nullo");
        }
        this.lato = lato;
    }

    /*
     * Post-condizioni: ritorna la superficie della piastrella
     */
    @Override
    public Integer superficie() {
        // Calcolo dell'area di un quadrato
        return this.lato * this.lato;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Piastrella quadrata [");
        sb.append(String.format("costo=%d, ", costo()));
        sb.append(String.format("superficie=%d, ", superficie()));
        sb.append(String.format("lato=%d]", lato));
        return sb.toString();
    } 
}
