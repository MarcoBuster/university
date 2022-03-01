package playlist;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
 * La classe immutabile Album rappresenta una 
 * collezione ordinata di brani, non vuota e senza ripetizioni.
 * 
 * La classe eredita la classe astratta ElencoBrani.
 */
 public class Album extends ElencoBrani {
    /*
     * La classe immutabile Brano rappresenta un brano musicale,
     * caraterizzato da un nome e una durata.
     * Come suggerito dal testo, la classe Brano è innestata all'interno della 
     * classe Album, perché Album condivide parte del suo stato con Brano.
     */
    public class Brano {
        /*
         * RI: titolo non vuoto o nullo
         *     durata non vuoto o nullo
         *     durata > 0
         *     brani non vuoto e senza ripetizioni
         */
        public final String titolo;
        public final Durata durata;

        /*
         * Costruttore della classe brano
         * 
         * Post-condizioni: NullPointerException se titolo è nullo
         *                  IllegalArgumentException se titolo è vuoto
         *                  altrimenti l'oggetto costruito
         */
        public Brano(final String titolo, final Durata durata) {
            Objects.requireNonNull(titolo);
            if (titolo.isEmpty()) {
                throw new IllegalArgumentException("Titolo non può essere vuoto");
            }
            this.titolo = titolo;
            this.durata = durata;
        }

        /*
         * Post-condizioni: ottieni l'oggetto Album del brano
         */
        public Album album() {
            return Album.this;
        }

        /*
         * Funzione di astrazione
         * 
         * Post-condizioni: ritorna il brano in formato nome (durata)
         */
        public String toString() {
            return String.format("\"%s\" (%s)", this.titolo, this.durata.toString());
        }
    }

    /*
     * Costruttore della classe album
     * 
     * Pre-condizioni:  una lista di titoloBrani e duranteBrani lunghe uguali
     *                  con nomi non nulli o vuoti e durate non nulle e strettamente positive
     *                  senza ripetizioni di brani
     * Post-condizioni: l'oggetto Album creato
     */
    public Album(final String nomeAlbum, final List<String> titoloBrani, final List<String> durateBrani) {
        super(nomeAlbum);

        List<Brano> brani = new ArrayList<>();
        for (int i = 0; i < titoloBrani.size(); i++) {
            Durata durataBrano = Durata.fromString(durateBrani.get(i));
            brani.add(new Brano(titoloBrani.get(i), durataBrano));
        }
        this.brani = brani;
    }
    /*
     * Funzione di astrazione
     * 
     * Post-condizioni: ritorna una stringa rappresentante l'album secondo il 
     *                  formato richiesto dal testo
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Titolo album: %s\n", this.nome));
        for (int i = 0; i < this.brani.size(); i++) {
            Brano b = ottieniBrano(i + 1);
            sb.append(String.format("%d - %s\n", i + 1, b.toString()));
        }
        sb.append(String.format("Durata totale: %s", this.durataComplessiva().toString()));
        return sb.toString();
    }
}
