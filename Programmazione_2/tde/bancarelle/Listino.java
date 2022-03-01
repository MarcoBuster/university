package bancarelle;

/*
 * Interfaccia rappresentante un listino, ovvero
 * una politica di prezzo per un dato giocattolo.
 */
public interface Listino {
    /*
     * Pre-condizioni:  un giocattolo g non nullo presente nel listino e una quantità strettamente positiva
     * Post-condizioni: dipende dall'implementazione
     */
    public int prezzo(Giocattolo g, int quantità);
}
