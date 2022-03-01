package filesystem;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import javax.naming.NameNotFoundException;

/*
 * Classe concreta rappresentante una directory
 */
public class Directory extends Entry implements Iterable<Entry> {
    /*
     * RI: entries non può essere nulla
     *     entries può anche essere vuota
     * 
     * AF: se path è _vuoto_ (non nullo), allora è la root
     */
    private final List<Entry> entries;

    /*
     * Costruttore della classe
     * 
     * Pre-condizioni:      un nome che rispetti l'RI di Entry
     * Post-condizioni:     una directory con il nome assegnato, non legata a nessun path 
     * Effetti collaterali: inizializza this.entries a una lista vuota
     */
    public Directory(final String nome) {
        super(nome);
        this.entries = new LinkedList<>();
    }

    /*
     * Aggiunge un elemento nella directory
     * 
     * Pre-condizioni:      una entry (file o directory)
     * Post-condizioni:     l'entry viene aggiunta alla directory e 
     *                      la sua path viene modificata
     */
    public void addEntry(Entry entry) {
        Objects.requireNonNull(entry);
        this.entries.add(entry);
        entry.setPath(this.path.append(entry));
    }

    /*
     * Ritorna tutte le entries nella directory
     * 
     * Post-condizioni:     una lista contente tutte le entries nella cartella
     */
    public List<Entry> getEntries() {
        return new LinkedList<Entry>(this.entries);
    }

    public Iterator<Entry> iterator() {
        return this.entries.iterator();
    }

    /*
     * Cerca una entry dal suo nome nella directory
     * 
     * Pre-condizioni:      un nome non nullo da cercare, che rispetta l'RI di Entry
     * Post-condizioni:     la Entry trovata se trovata, o l'eccezione NameNotFoundException
     */
    public Entry search(String entryName) throws NameNotFoundException {
        for (Entry e : this) {
            if (e.nome == entryName) {
                return e;
            }
        }
        throw new NameNotFoundException();
    }

    /*
     * Post-condizioni: ritorna la dimensione totale di 
     *                  tutti i file all'interno della directory
     */
    @Override
    public Integer dimensione() {
        int somma = 0;
        for (Entry e : this.entries) {
            somma += e.dimensione();
        }
        return somma;
    }

    @Override
    public String toString() {
        return String.format("%s*", super.toString());
    }
}
