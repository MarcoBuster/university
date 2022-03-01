import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/*
 * La classe astratta WordLike accomuna la rappresentazione dello stato
 * e alcuni metodi per rappresentare un oggetto simile a una parola.
 * Lo stato è rappresentato da una lista protetta e immutabile di caratteri, 
 * non nulla, priva di spazi o nuovi linea.
 */
public abstract class WordLike {
    protected final List<Character> characters;

    /*
     * Costruttore della classe WordLike
     * 
     * Pre-condizioni:      richiede un parametro di tipo stringa non nullo, 
     *                      privo di spazi o nuovi linea;
     * Post-condizioni:     ritorna un nuovo oggetto WordLike;
     * Effetti collaterali: popola l'array protetto this.characters 
     *                      con tutti i caratteri della parola.
     */
    public WordLike(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException("word can't be null!");
        }
        if (s.contains(" ") || s.contains("\n")) {
            throw new IllegalArgumentException("word can't contain spaces or new lines!");
        }
        this.characters = new LinkedList<>();
        for (int i = 0; i < s.length(); i++)
            this.characters.add(s.charAt(i));
    }

    /*
     * ALTRA.SUPERCAZZOLA.
     */
    protected boolean repOK() {
        if (this.characters == null || this.characters.size() == 0) {
            return false;
        }
        if (this.characters.contains(' ') || this.characters.contains('\n')) {
            return false;
        }
        return true;
    }

    /*
     * REP.INV.
     */
    @Override
    public String toString() {
        assert repOK();

        StringBuilder sb = new StringBuilder();
        for (Character chr : this.characters) {
            sb.append(chr.toString());
        }
        return sb.toString();
    }


    /* 
     * Post-condizioni:     ritorna l'hashcode dell'oggetto.
     */
    public int hashCode() {
        assert this.repOK();
        return 31 * Objects.hash(this.characters);
    }

    /*
     * Confronta l'oggetto attuale con un altro oggetto
     * 
     * Pre-condizioni:      richiede un parametro di qualsiasi tipo;
     * Post-condizioni:     ritorna vero se il riferimento o lo stato 
     *                      dei due oggetti sono uguali, falso altrimenti.
     */
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof WordLike)) {
            return false;
        }
        WordLike ow = (WordLike) other;
        assert this.repOK() && ow.repOK();
        return this.characters.equals(ow.characters);
    }
}
