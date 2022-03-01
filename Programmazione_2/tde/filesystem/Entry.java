package filesystem;

import java.util.Objects;

/*
 * Classe astratta rappresenta una entry, 
 * ovvero un oggetto presente all'interno del filesystem.
 * 
 * Lo stato è rappresentato dal nome e dalla path
 */
public abstract class Entry {
    /*
     * RI: nome non può essere nullo
     *     nome non può contenere : (seperatore tra path)
     *     nome non può essere una stringa vuota, a meno che l'entry non sia la radice
     *     in tal caso, l'entry deve essere istanza di Directory
     * 
     * AF: se path è nullo, allora entry non è sta ancora inserita nel filesystem
     *     se nome è una stringa vuota, allora l'entry è la radice ed è istanza di Directory
     */
    public final String nome;
    public Path path;

    /*
     * Crea una nuova entry, senza inserirla nel filesystem.
     * 
     * Pre-condizioni:      un nome che rispetta l'RI
     * Post-condizioni:     ritorna una Entry senza percorso
     * Effetti collaterali: imposta la path a null
     */
    public Entry(final String nome) {
        Objects.requireNonNull(nome);
        if (nome.contains(":")) {
            throw new IllegalArgumentException("Nome non può contenere :");
        }
        this.nome = nome;
        this.path = null;

        // se il nome è vuoto, allora si sta provando ad inizializzare la radice
        if (nome == "") {
            if (!(this instanceof Directory)) {
                throw new IllegalArgumentException("Solo una directory può essere la radice.");
            }
            this.path = new Path();
        }
    }

    /*
     * Assegna una path alla entry. 
     * 
     * Pre-condizioni:      una path assoluta
     * Post-condizioni:     imposta l'attributo path alla path data
     */
    protected void setPath(Path path) {
        this.path = path;
    }

    /*
     * Post-condizioni: ritorna la dimensione dell'entry
     */
    public abstract Integer dimensione();

    @Override
    public String toString() {
        return this.nome;
    }
}
