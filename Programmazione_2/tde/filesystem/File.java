package filesystem;

/*
 * Classe concreta rappresentante un file.
 */
public class File extends Entry {
    /*
     * RI: dimensione > 0
     */
    private final int dimensione;

    /*
     * Costruttore di File
     * 
     * Pre-condizioni:  un nome che rispetta l'RI (vedere Entry)
     *                  una dimensione strettamente positiva
     */
    public File(final String nome, int dimensione) {
        super(nome);
        if (dimensione <= 0) {
            throw new IllegalArgumentException("La dimensione del file deve essere strettamente positiva");
        }
        this.dimensione = dimensione;
    }

    /*
     * Post-condizioni: ritorna la dimensione del file
     */
    @Override
    public Integer dimensione() {
        return this.dimensione;
    }

    @Override
    public String toString() {
        return String.format("%s(%d)", super.toString(), this.dimensione());
    }
}
