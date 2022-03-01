package bancarelle;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

/*
 * Classe immutabile (nei riferimenti) rappresentante una bancarella.
 */
public class Bancarella {
    /*
     * RI:  proprietario, inventario e listino non possono essere nulli.
     *      il listino deve poter calcolare il prezzo di tutti gli elementi nell'inventario.
     */
    private final String proprietario;
    private final Inventario inventario;
    private final Listino listino;

    /*
     * Pre-condizioni:  argomenti rispettanti l'RI
     * Post-condizioni: una bancarella con i dati rappresentati
     */
    public Bancarella(final String p, final Inventario i, final Listino l) {
        Objects.requireNonNull(p);
        Objects.requireNonNull(i);
        Objects.requireNonNull(l);

        this.proprietario = p;
        this.inventario = i;
        this.listino = l;
    }

    /*
     * Post-condizioni:     ritorna il proprietario della bancarella
     */
    public String getProprietario() {
        return this.proprietario;
    }

    /*
     * Pre-condizioni:      un giocattolo non nullo da vendere e una quantità strettamente positiva
     * Post-condizioni:     il giocattolo viene rimosso dall'inventario per la quantità data
     * Effetti collaterali: l'inventario viene modificato
     */
    public void vendi(Giocattolo g, int quantità) {
        this.inventario.rimuovi(g, quantità);
        assert repOk();
    }

    /*
     * Post-condizioni:     ritorna una mappa con keyset l'insieme dei giocattoli
     *                      e valori un array di interi di lunghezza 2 rappresentante la quantità e il prezzo unitario
     */
    public Map<Giocattolo, int[]> inserzioni() {
        assert repOk();

        Map<Giocattolo, int[]> res = new HashMap<>();
        for (Giocattolo g : this.inventario) {
            // quantità, prezzo unitario
            int[] info = new int[]{this.inventario.quantità(g), this.listino.prezzo(g, 1)};
            res.put(g, info);
        }
        return res;
    }

    /*
     * Equivalente a Listino.prezzo
     */
    public Integer prezzo(Giocattolo g, Integer q) {
        assert repOk();
        return this.listino.prezzo(g, q);
    }

    @Override
    public int hashCode() {
        return 31 * Objects.hashCode(proprietario) * Objects.hashCode(listino) * Objects.hashCode(inventario);
    }

    public boolean repOk() {
        // Controlla che sia possibile ricavare il prezzo di tutti gli elementi dell'inventario
        for (Giocattolo g : this.inventario) {
            try {
                this.listino.prezzo(g, 1);
            } catch (NoSuchElementException e) {
                return false;
            }
        }
        return true;
    }
}
