package filesystem;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.naming.NameNotFoundException;

/*
 * Classe concreta rappresentante una shell,
 * ovvero un interprete di comandi che interagisce con il filesystem.
 * 
 * Tutti i 'comandi' ritornano void e stampano i risultati su stdout
 */
public class Shell {
    /*
     * RI: workingDirectory non può essere nulla
     *     workingDirectory deve avere path assoluta (il primo elemento deve essere root)
     *     root non può essere nulla
     * 
     * AF: la workingDirectory rappresenta la directory in cui la shell si trova
     */
    private Directory workingDirectory;
    private final Directory root;

    /*
     * Costruttore della classe
     * 
     * Pre-condizioni:  root non può essere nulla
     *                  root deve essere la path assoluta della root del filesystem
     */
    public Shell(Directory root) {
        Objects.requireNonNull(root);
        this.workingDirectory = root;
        this.root = root;
        assert repOk();
    }

    private boolean repOk() {
        if (this.workingDirectory == null || this.root == null) {
            return false;
        }
        // TODO sapere se workingDirectory è la root
        return true;
    }

    private static void print(String result) {
        System.out.println(String.format(">>> %s", result));
    }

    /*
     * Ricava una entry con path assoluta da una stringa,
     * indicante una path assoluta o relativa
     * 
     * Pre-condizioni:  una stringa indicante una path. 
     *                  se inizia con : allora la path è assoluta,
     *                  altrimenti è relativa e la ricerca inizia dalla working directory
     * Post-condizioni: l'entry trovata o NameNotFoundException se la path non è valida 
     */
    public Entry parsePath(String p) throws NameNotFoundException {
        assert repOk();

        Directory result;
        if (p.charAt(0) == ':') {
            // Path assoluta
            result = this.root;
            p = p.substring(1);
        } else {
            // Path relativa
            result = this.workingDirectory;
        }
        // Dividi la stringa in pezzi, una indicante una directory (o un file)
        String[] pieces = p.split(":");
        Entry found;
        for (int i = 0; i < pieces.length; i++) {
            System.out.println(pieces[i]);
            found = result.search(pieces[i]);
            // Se un file è stato trovato
            if ((found instanceof File)) {
                if (i != pieces.length-1)  // sono arrivato alla fine?
                    throw new NameNotFoundException();
                else
                    return found;
            }
            // se invece una directory è stata trovata, prosegue
            result = (Directory) found;
        }
        return result;
    }

    /*
     * Post-condizioni: stampa la path working directory
     */
    public void pwd() {
        assert repOk();
        print(this.workingDirectory.path.toString());
    }

    /*
     * Pre-condizioni:  una stringa indicante una path esistente nel filesystem
     * Post-condizioni: stampa la lista di file e cartelle presente nella path data
     */
    private void ls(Directory dir) {
        assert repOk();
        for (Entry e : dir) {
            print(e.toString());
        }
    }
    
    /*
     * Post-condizioni: stampa la lista di file e cartelle presente nella working directory
     */
    public void ls() {
        ls(this.workingDirectory);
    }

    /*
     * Pre-condizioni:  una stringa indicante una path esistente nel filesystem
     * Post-condizioni: stampa la lista di file e cartelle presente nella path data
     */
    public void ls(String path) {
        assert repOk();
        Entry e = null;
        try {
            e = parsePath(path);
        } catch (NameNotFoundException exp) {
            print("Path non valida.");
            return;
        }
        if (!(e instanceof Directory)) {
            print("La path selezionata non è di una directory.");
            return;
        }
        ls((Directory) e);
    }

    /*
     * Post-condizioni: cambia la working directory alla radice 
     */
    public void cd() {
        assert repOk();
        this.workingDirectory = this.root;
    }

    /*
     * Pre-condizioni:  una stringa indicante una path esistente nel filesystem
     * Post-condizioni: cambia la working directory con una arbitraria,
     *                  o stampa un messaggio di errore se la path non è valida
     */
    public void cd(String path) {
        assert repOk();
        Entry e = null;
        try {
            e = parsePath(path);
        } catch (NameNotFoundException exp) {
            print("Path non valida.");
            return;
        }
        if (!(e instanceof Directory)) {
            print("La path selezionata non è di una directory.");
            return;
        }
        this.workingDirectory = (Directory) e;
    }

    /*
     * Pre-condizioni:  una stringa indicante una path esistente nel filesystem
     * Post-condizioni: crea una directory alla path data
     */
    public Directory mkdir(String path) {
        String[] pieces = path.split(":");
        String[] newPieces = Arrays.copyOfRange(pieces, 0, pieces.length-1);
        String croppedPath = String.join(":", newPieces);
        Entry e = null;
        try {
            e = parsePath(croppedPath);
        } catch (NameNotFoundException exp) {
            print("Path non valida.");
            return null;
        }
        if (!(e instanceof Directory)) {
            print("La path selezionata non ha come parent una directory.");
            return null;
        }
        Directory parent = (Directory) e;
        Directory result = new Directory(newPieces[pieces.length-1]);
        parent.addEntry(result);
        return result;
        /// una merda.
    }
}
