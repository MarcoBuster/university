package bancarelle;

import java.util.Objects;

/*
 * Record immutabile rappresentante un giocattolo.
 * 
 * RI:  nome e materiale non possono essere nulli.
 *      Essendo il record immutabile è sufficiente controllare la RI solo nel costruttore.
 */
public record Giocattolo(String nome, String materiale) {
    public Giocattolo {
        Objects.requireNonNull(nome);
        Objects.requireNonNull(materiale);
    }

    public boolean equals(Object other) {
        if (!(other instanceof Giocattolo)) return false;

        Giocattolo g = (Giocattolo) other;
        return this.nome.equals(g.nome) && this.materiale.equals(g.materiale);
    }

    /*
     * Funzione di astrazione
     */
    @Override
    public String toString() {
        return String.format("%s di %s", nome, materiale);
    }

    @Override
    public int hashCode() {
        return 31 * (Objects.hash(this.nome) + Objects.hash(this.materiale));
    }
}
