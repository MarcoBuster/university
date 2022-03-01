package filesystem;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/*
 * Classe concreta immutabile rappresentante un path,
 * ovvero una lista di entry che porta dalla radice a una determinata entry
 * 
 * Le path rappresentate con questa classe sono sempre assolute
 */
public class Path implements Iterable<Entry> {
    /*
     * RI: path non nullo
     *     solo l'ultimo elemento di path può essere un file
     * 
     * AF: se path non contiene elementi allora è la radice
     *     se path contiene elementi allora quest'ultimi indicano il percorso
     *     da seguire che porta dalla radice all'ultima entry
     */
    private final List<Entry> path;

    /*
     * Costruttore della classe.
     * 
     * Post-condizioni: ritorna la path di root
     */
    public Path() {
        this.path = new LinkedList<>();
    }

    /*
     * Costruttore della classe.
     * 
     * Post-condizioni: ritorna una path costruita dalla lista di entry data
     */
    public Path(final List<Entry> path) {
        Objects.requireNonNull(path);
        this.path = new LinkedList<>(path);
        assert repOk();
    }

    /*
     * Appende una entry alla path.
     * 
     * Pre-condizioni:      entry non deve essere nulla
     *                      il metodo non può essere chiamato se 
     *                      l'ultimo elemento in path è un file
     * Post-condizioni:     aggiunge l'entry nella path 
     */
    public Path append(Entry entry) {
        Path result = new Path(this.path);
        result.path.add(entry);
        assert result.repOk();
        return result;
    }

    /*
     * Ritorna tutte le entries nella directory
     * 
     * Post-condizioni:     una lista contentente tutte le entries della path,
     *                      partendo dalla radice
     */
    public List<Entry> getPath() {
        assert repOk();
        return new LinkedList<>(this.path);
    }

    /*
     * Post-condizioni:     ritorna un iteratore che itera sequenzialmente 
     *                      sulla path, partendo dalla radice
     */
    @Override
    public Iterator<Entry> iterator() {
        assert repOk();
        return this.path.iterator();
    }

    /*
     * Controllo dell'invariante di rappresentazione
     */
    private boolean repOk() {
        if (this.path == null) {
            return false;
        }
        boolean isFile = false;
        for (Entry entry : this) {
            if (isFile) return false;
            isFile = entry instanceof File;
        }
        return true;
    }

    /*
     * Funzione d'astrazione. 
     * 
     * Tutte le path iniziano con :, in quanto sono assolute
     */
    public String toString() {
        assert repOk();
        StringBuilder sb = new StringBuilder();
        sb.append(":");
        for (int i = 0; i < this.path.size(); i++) {
            sb.append(this.path.get(i).nome);
            if (i != this.path.size()-1) {
                sb.append(":");
            }
        }
        return sb.toString();
    }
}
