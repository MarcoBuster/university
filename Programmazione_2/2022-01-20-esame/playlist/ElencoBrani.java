package playlist;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/*
 * Classe astratta ElencoBrani, rappresentante un elenco ordinato e non vuoto di brani.
 * 
 * È stato deciso di creare una classe astratta per raccogliere gli attributi e i 
 * metodi comuni di Album e Playlist
 */
public abstract class ElencoBrani implements Iterable<Album.Brano> {
    /*
     * RI: brani non nullo
     *     brani senza ripetizioni
     *     titolo non vuoto o nullo
     * 
     * L'attributo nome è pubblico perché essendo final non può comunque essere mutato
     * L'attributo brano è protetti perché è necessario accedervi dalle sottoclassi.  
     */
    public final String nome;
    protected List<Album.Brano> brani;

    /*
     * Costruttore di ElencoBrani
     * 
     * Post-condizioni:     NullPointerException se nome è nullo 
     *                      IllegalArgumentException se nome è vuota
     * Effetti collaterali: inizializza la lista dei brani
     */
    protected ElencoBrani(String nome) {
        Objects.requireNonNull(nome);
        if (nome.isEmpty()) {
            throw new IllegalArgumentException("Il nome non può essere nullo!");
        }
        this.nome = nome;
        this.brani = new ArrayList<>();
    }

    /*
     * Post-condizioni: ritorna la durata complessiva dell'elenco
     */
    public Durata durataComplessiva() {
        int durataSecondi = 0;
        for (Album.Brano b : this) {
            durataSecondi += b.durata.secondi();
        }
        return new Durata(durataSecondi);
    }
    
    /*
     * Post-condizioni: ritorna un iteratore di tutti i brani presenti nell'elenco
     */
    public Iterator<Album.Brano> iterator() {
        return this.brani.iterator();
    }

    /*
     * Cerca un brano dato il suo titolo
     * 
     * Post-condizioni: NullPointerException se l'argomento inserito è nullo
     *                  NoSuchElementException se il brano non è stato trovato
     *                  altrimenti un oggetto di tipo Brano rappresentante il brano trovato
     */
    public Album.Brano cercaBrano(final String titolo) {
        Objects.requireNonNull(titolo);
        for (Album.Brano brano : this) {
            if (brano.titolo.toLowerCase().equals(titolo.toLowerCase())) {
                return brano;
            }
        }
        throw new NoSuchElementException("Il brano non è presente nell'elenco");
    }

    /*
     * Ottieni un brano data la sua posizione nell'elenco.
     * Le posizioni partono da 1.
     * 
     * Post-condizioni: IllegalArgumentException se la posizione non è valida (<1 o >numero brani dell'album)
     *                  altrimenti il Brano corrispondente alla posizione data
     */
    public Album.Brano ottieniBrano(final int posizione) {
        if (posizione < 1 || posizione - 1 >= this.brani.size()) {
            throw new IllegalArgumentException("La posizione specificata non è valida");
        }
        return this.brani.get(posizione - 1);
    }
    
    /*
     * Ottieni la posizione di un brano.
     * Le posizioni partono da 1.
     * 
     * Post-condizioni: NullPointerException se l'argomento inserito è nullo
     *                  NoSuchElementException se il brano inserito non è presente nell'album
     *                  altrimenti un intero rappresentante la posizione del brano all'interno dell'album
     */
    public int posizione(final Album.Brano b) {
        Objects.requireNonNull(b);
        int res = this.brani.indexOf(b);
        if (res == -1) {
            throw new NoSuchElementException("Il brano non è stato trovato");
        }
        return res;
    }

    /*
     * Post-condizioni: ritorna una lista di tutti i brani dell'elenco
     */
    public List<Album.Brano> tuttiIBrani() {
        // crea una nuovo oggetto ArrayList per evitare pericolosi passaggi di reference 
        return new ArrayList<>(this.brani);
    }

    /*
     * Controlla se un brano è presente nell'elenco
     * 
     * Post-condizioni: ritorna un booleano vero se è presente, falso altrimenti
     */
    public boolean èPresente(Album.Brano b) {
        return this.brani.contains(b);
    }
}
