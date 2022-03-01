import java.util.Collections;

/*
 * La classe WordSignature rappresenta la firma di una parola.
 * La firma di una parola è la lista dei caratteri della parola ordinata 
 * in ordine alfabetico.
 */
public class WordSignature extends WordLike {
    /*
     * Costruttore di WordSignature
     * 
     * Pre-condizioni:      richiede un parametro di tipo stringa non nullo, 
     *                      privo di spazi o nuovi linea;
     * Post-condizioni:     ritorna un nuovo oggetto WordSignature;
     * Effetti collaterali: chiama il costruttore della superclasse WordLike
     *                      e riordina i caratteri in ordine alfabetico.
     */
    public WordSignature(String s) {
        super(s);
        Collections.sort(this.characters);
        assert this.repOK();
    }

    /*
     * Costruttore di WordSignature
     * 
     * Pre-condizioni:      richiede un parametro di tipo Word
     * Post-condizioni:     ritorna un nuovo oggetto WordSignature;
     * Effetti collaterali: chiama il costruttore della superclasse WordLike
     *                      e riordina i caratteri in ordine alfabetico.
     */
    public WordSignature(Word w) {
        super(w.toString());
        Collections.sort(this.characters);
        assert this.repOK();
    }
}