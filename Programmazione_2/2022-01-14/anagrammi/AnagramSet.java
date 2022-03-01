import java.util.LinkedList;
import java.util.List;

/*
 * AnagramSet rappesenta un insieme ordinato di parole confrontabile di tipo Word anagramme tra loro.
 * Eredita la classe LinkedList<Word> e implementa l'interfaccia Comparable<AnagramSet>.
 */
public class AnagramSet extends LinkedList<Word> implements Comparable<AnagramSet> {
    public AnagramSet() {
        super();
    }

    public AnagramSet(List<Word> of) {
        super(of);
    }

    /*
     * Compara l'insieme con un altro insieme dello stesso tipo
     * Pre-condizioni:      richiede un parametro di tipo AnagramSet 
     *                      da comparare con l'oggetto
     * Post-condizioni:     ritorna un risultato affine a Comparable.compareTo
     *                      che descrive la relazione d'ordine tra i due oggetti
     */
    @Override
    public int compareTo(AnagramSet other) {
        assert this.repOK() && other.repOK();
        if (this.size() < other.size()) {
            return 1;
        }
        if (this.size() > other.size()) {
            return -1;
        }

        int comparisonResult;
        while (this.iterator().hasNext() && other.iterator().hasNext()) {
            comparisonResult = this.iterator().next()
                .compareTo(other.iterator().next());
            if (comparisonResult != 0) {
                return comparisonResult;
            }
        }
        return 0;
    }

    protected boolean repOK() {
        // Controlla che tutte le parole siano anagramme tra loro
        // controllando la prima parola con tutte le altre
        Word firstWord = this.getFirst();
        for (Word word : this) {
            if (!firstWord.isAnagramOf(word)) {
                return false;
            }
        }
        return true;
    }
}
