package bancarelle;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

/*
 * Classe mutabile rappresentante un inventario.
 * Un inventario è una collezione di giocattoli con la loro quantità.
 * 
 * RI: gli elementi all'interno della mappa non possono essere nulli,
 *     per ogni giocattolo le quantità devono essere strettamente maggiori di zero.
 */
public class Inventario implements Iterable<Giocattolo> {
    // final perché il riferimento alla mappa non può mai cambiare
    final private Map<Giocattolo, Integer> elements;

    /*
     * Inizializza un inventario vuoto.
     * 
     * Post-condizioni:     genera un inventario vuoto
     * Effetti collaterali: inizializza l'attributo 'elements'
     */
    public Inventario() {
        this.elements = new HashMap<>();
    }

    /*
     * Restituisce la quantità di un giocattolo all'interno dell'inventario.
     * 
     * Pre-condizioni:      un giocattolo non nullo presente all'inventario
     * Post-condizioni:     restitusice la quantità corrispondente
     */
    public Integer quantità(final Giocattolo g) {
        Objects.requireNonNull(g);
        Integer qty = this.elements.get(g);
        if (qty == null) {
            throw new IllegalArgumentException("Il giocattolo non è presente nell'inventario");
        }
        return qty;
    }

    /*
     * Aggiunge una quantità di giocattolo all'inventario.
     * 
     * Pre-condizioni:      un giocattolo non nullo da aggiungere e una quantità strettamente positiva
     * Post-condizioni:     il giocattolo viene aggiunto all'inventario per la quantità data
     * Effetti collaterali: se il giocattolo non esisteva nella mappa 'this.elements', viene aggiunta una nuova entry
     */
    public void aggiungi(final Giocattolo g, final int quantità) {
        Objects.requireNonNull(g);
        if (quantità <= 0) {
            throw new IllegalArgumentException("La quantità di acquisto deve essere strettamente positiva");
        }
        Integer qty = this.elements.get(g);
        if (qty == null) {  // Il giocattolo non è ancora presente nella mappa
            qty = 0;
        }
        this.elements.put(g, qty+quantità);
    }

    /*
     * Rimuove una quantità di giocattolo dall'inventario.
     * 
     * Pre-condizioni:      un giocattolo non nullo presente nell'inventario da rimuovere e una quantità strettamente positiva
     * Post-condizioni:     il giocattolo viene rimosso dall'inventario per la quantità data
     * Effetti collaterali: se un giocattolo viene completamente rimosso dall'inventario (quantità=0) 
     *                      allora viene rimossa la entry dalla mappa
     */
    public void rimuovi(final Giocattolo g, final int quantità) {
        Objects.requireNonNull(g);
        if (quantità <= 0) {
            throw new IllegalArgumentException("La quantità di acquisto deve essere strettamente positiva");
        }
        Integer qty = this.elements.get(g);
        if (qty == null) {  // Il giocattolo non è presente nella mappa
            throw new NoSuchElementException("L'elemento che si sta provando a rimuovere dall'inventario non è nell'inventario");
        }
        if (qty - quantità < 0) {
            throw new IllegalArgumentException("La quantità specificata è superiore alla quantità dell'elemento nell'inventario");
        } else if (qty - quantità == 0) {
            this.elements.remove(g);
        } else {
            this.elements.put(g, qty-quantità);
        }
    }

    /*
     * Post-condizioni:     restituisce un iteratore dei giocattoli presenti nell'inventario
     */
    public Iterator<Giocattolo> iterator() {
        return this.elements.keySet().iterator();
    }
}
