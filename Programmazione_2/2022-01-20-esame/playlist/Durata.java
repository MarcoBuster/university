package playlist;
import java.util.Objects;

/*
 * Il record immutabile Durata rappresenta 
 * la lunghezza in tempo di un brano o di un album.
 * 
 * RI: secondi > 0
 */
public record Durata(int secondi) {

    /*
     * Costruttore del record Durata
     * 
     * Post-condizioni: ritorna IllegalArgumentException se i secondi inseriti sono <= 0
     */
    public Durata {
        if (secondi <= 0) {
            throw new IllegalArgumentException("La durata deve essere positiva");
        }
    }

    /*
     * Funzione di astrazione.
     * 
     * Post-condizioni: ritorna la durata formattata come H:MM:SS
     */
    public String toString() {
        int minuti = secondi / 60;
        int ore = minuti / 60;
        minuti = minuti % 60;
        StringBuilder sb = new StringBuilder();
        if (ore > 0) {
            sb.append(String.format("%d:", ore));
        }
        sb.append(String.format("%02d:%02d", minuti, secondi % 60));
        return sb.toString();
    }

    /*
     * Pre-condizioni: una stringa valida non nulla indicante una durata nel formato H:MM:SS
     * Post-condizioni: la durata rappresentata dalla stringa
     */
    public static Durata fromString(final String s) {
        int secondi = 0;
        final String[] splitted = s.split(":");
        switch (splitted.length) {
            case 1:
                secondi = Integer.parseInt(splitted[0]);
                break;
            case 2:
                secondi = Integer.parseInt(splitted[0]) * 60 + Integer.parseInt(splitted[1]);
                break;
            case 3:
                secondi = Integer.parseInt(splitted[0]) * 60 * 60 +
                        Integer.parseInt(splitted[1]) * 60 +
                        Integer.parseInt(splitted[0]);
                break;
        }
        return new Durata(secondi);
    }

    /*
     * Post-condizioni: ritorna la somma delle due durate,
     *                  o NullPointerException se l'altra durata è nulla
     */
    public Durata più(final Durata other) {
        Objects.requireNonNull(other);
        return new Durata(secondi + other.secondi);
    }
}
