package piastrelle;

import java.util.Objects;

/*
 * Questa classe concreta immutabile rappresenta una piastrella triangolare.
 * Oltre agli attributi della piastrella generica, la classe rappresenta:
 * - la base del triangolo
 * - l'altezza del triangolo
 * ed implementa quindi il metodo superficie()
 * 
 * Lo stato è modificato solo dal costruttore, che controlla l'RI. 
 * Non è quindi necessario scrivere il metodo repOK.
 */
public class PiastrellaTriangolare extends Piastrella {
    /*
     * RI: base, altezza non possono essere nulli
     *     base > 0
     *     altezza > 0
     */
    private Integer base;
    private Integer altezza;

    /*
     * Costruttore della classe.
     * 
     * Pre-condizioni: tutti i parametri devono rispettare l'RI di Piastrella e PiastrellaTriangolare
     * Effetti collaterali: gli attributi base e altezza vengono inizializzati
     */
    public PiastrellaTriangolare(Integer costo, Integer base, Integer altezza) {
        super(costo);

        Objects.requireNonNull(base);
        Objects.requireNonNull(altezza);
        if (base <= 0) {
            throw new IllegalArgumentException("La base deve essere strettamente positiva");
        }
        if (altezza <= 0) {
            throw new IllegalArgumentException("L'altezza deve essere stretatmente positiva");
        }
    }

    /*
     * Post-condizioni: ritorna la superficie della piastrella
     */
    @Override
    public Integer superficie() {
        // Calcolo dell'area di un triangolo
        return (this.base * this.altezza) / 2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Piastrella triangolare [");
        sb.append(String.format("costo=%d, ", costo()));
        sb.append(String.format("superficie=%d, ", superficie()));
        sb.append(String.format("base=%d, ", base));
        sb.append(String.format("altezza=%d]", altezza));
        return sb.toString();
    }   
}
