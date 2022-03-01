/*
 * La classe immutabile Word rappresenta una parola Unicode,
 * in grado di: 
 * - calcolare la propria firma
 * - determinare se è anagramma di un'altra 
 * - essere comparata con altre parole.
 * Eredita la classe astratta WordLike ed implementa la classe Comparable<Word>.
 */
public final class Word extends WordLike implements Comparable<Word> {
    /*
     * Costruttore di Word
     * 
     * Pre-condizioni:      richiede un parametro di tipo stringa non nullo, 
     *                      privo di spazi o nuovi linea;
     * Post-condizioni:     ritorna un nuovo oggetto Word;
     * Effetti collaterali: chiama il costruttore della superclasse WordLike.
     */
    public Word(String s) {
        super(s);
    }

    /*
     * Post-condizioni:     restituisce un nuovo oggetto di tipo WordSignature
     *                      rappresentante la firma della parola.
     */
    public WordSignature getSignature() {
        assert this.repOK();
        return new WordSignature(this);
    }

    /*
     * Pre-condizioni:      richiede un parametro other di tipo Word;
     * Post-condizioni:     restituisce vero o falso se la parola è anagramma dell'altra;
     * Effetti collaterali: calcola la firma della parola attuale e dell'altra.
     */
    public boolean isAnagramOf(Word other) {
        assert this.repOK() && other.repOK();
        return this.getSignature().equals(other.getSignature());
    }

    /*
     * Pre-condizioni:      richiede un parametro other di tipo Word;
     * Post-condizioni:     compara la parola con un'altra.
     *                      Il funzionamento è analogo a String.compare(...).
     */
    public int compareTo(Word other) {
        assert this.repOK() && other.repOK();
        return this.toString().compareTo(other.toString());
    }
}
