package playlist;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/*
 * La classe mutabile Playlist rappresenta una collezione ordinata di brani,
 * non vuota e senza ripetizioni.
 * 
 * A differenza di Album, la Playlist essendo mutabile permette di 
 * chiamare metodi per modificare la lista dei brani.
 * La classe eredita la classe astratta ElencoBrani e aggiunge inoltre 
 * altri metodi osservazionali specifici per le playlist
 */
public class Playlist extends ElencoBrani {

    /*
     * Costruttore di Playlist
     */
    public Playlist(String nome) {
        super(nome);
    }
    
    /*
     * Aggiungi un brano alla playlist
     * 
     * Post-condizioni: aggiunge il brano all'elenco, in ultima posizione;
     *                  se il brano è già presente, non fa nulla
     */
    public void aggiungi(Album.Brano b) {
        try {
            this.posizione(b);
        } catch (NoSuchElementException e) {
            this.brani.add(b);
        }
    }

    /*
     * Rimuovi un brano dalla playlist
     * 
     * Post-condizioni: rimuove il brano dall'elenco
     *                  se il brano non è presente, NoSuchElementException
     */
    public void rimuovi(Album.Brano b) {
        if (!èPresente(b)) {
            throw new NoSuchElementException("il brano non era presente nella playlist");
        }
        this.brani.remove(b);
    }

    /*
     * Funzione di astrazione
     * 
     * Post-condizioni: ritorna una stringa rappresentante la playlist secondo il 
     *                  formato richiesto dal testo
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Nome playlist: %s\n", this.nome));
        for (int i = 0; i < this.brani.size(); i++) {
            Album.Brano b = ottieniBrano(i + 1);
            sb.append(
                String.format("%d - %s, (da \"%s\")\n", 
                            i + 1, b.toString(), b.album().nome)
            );
        }
        sb.append(String.format("Durata totale: %s", this.durataComplessiva().toString()));
        return sb.toString();
    }

    /*
     * Post-condizioni: ritorna una lista di tutti i brani della playlist appartenenti a
     *                  un dato album, o NullPointerException se l'album dato è nullo
     */
    public List<Album.Brano> braniDiAlbum(Album a) {
        Objects.requireNonNull(a);
        List<Album.Brano> risultato = new ArrayList<>();
        for (Album.Brano b : this) {
            // controllo la reference
            if (b.album() != a) {
                continue;
            }
            risultato.add(b);
        }
        return risultato;
    }

    /*
     * Post-condizioni: ritorna una lista di gli album presenti nella playlist senza ripetizioni
     */
    public List<Album> tuttiGliAlbum() {
        List<Album> risultato = new ArrayList<>();
        for (Album.Brano b : this) {
            if (!risultato.contains(b.album())) {
                risultato.add(b.album());
            }
        }
        return risultato;
    }

    /*
     * Fondi la playlist con un'altra playlist.
     * Nella nuova playlist vengono prima inseriti i brani senza ripetizioni
     * di questa playlist, poi dell'altra.
     * 
     * Post-condizioni: ritorna una nuova playlist risultante della fusione tra questa e l'altra
     *                  o NullPointerException se l'altra playlist è nulla
     */
    public Playlist fondi(Playlist altra, String nome) {
        Objects.requireNonNull(altra);
        Playlist risultato = new Playlist(nome);
        // aggiungi i brani di this
        for (Album.Brano b : this) {
            if (risultato.èPresente(b)) {
                continue;
            }
            risultato.aggiungi(b);
        }
        // aggiungi i brani di altra
        for (Album.Brano b : altra) {
            if (risultato.èPresente(b)) {
                continue;
            }
            risultato.aggiungi(b);
        }
        return risultato;
    }
}
