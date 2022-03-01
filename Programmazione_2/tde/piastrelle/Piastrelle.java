package piastrelle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Piastrelle {

    private static Piastrella parsePiastrella(String line) {
        String[] pieces = line.split(" ");
        if (pieces.length < 2 || pieces.length > 4) {
            throw new IllegalArgumentException("La linea è malformata");
        }

        int[] params = new int[pieces.length-1];
        for (int i = 1; i < pieces.length; i++) {
            params[i-1] = Integer.parseInt(pieces[i]);
        }
        switch (pieces[0]) {
            case "Q":
                return new PiastrellaQuadrata(params[1], params[0]);
            case "R":
                return new PiastrellaRomboidale(params[2], params[0], params[1]);
            case "T":
                return new PiastrellaTriangolare(params[2], params[0], params[1]);
            default:
                throw new IllegalArgumentException("La linea non rappresenta nessuna piastrella nota");
        }
    }

    private static Pavimentazione parsePavimentazione(String line, List<Superficie> superfici) {
        String[] pieces = line.split(" ");
        if (pieces.length < 2) {
            throw new IllegalArgumentException("La linea è malformata");
        }
        if (((pieces.length-1) % 2) != 0) {
            throw new IllegalArgumentException("Il numero di parametri per la pavimentazione non è corretto");
        }

        int[] params = new int[pieces.length-1];
        for (int i = 1; i < pieces.length; i++) {
            params[i-1] = Integer.parseInt(pieces[i]);
        }

        Pavimentazione risultato = new Pavimentazione();
        Integer quantità, indice;
        for (int i = 0; i+1 < params.length; i += 2) {
            quantità = params[i];
            indice = params[i+1];
            risultato.aggiungi(superfici.get(indice), quantità);
        }
        return risultato;
    }

    private static Superficie parse(String line, List<Superficie> superfici) {
        if (line.charAt(0) == 'P') {
            return parsePavimentazione(line, superfici);
        } else {
            return parsePiastrella(line);
        }
    }

    public static void main(String[] args) {
        /*
        PiastrellaQuadrata pCucina = new PiastrellaQuadrata(3, 2);
        Pavimentazione cucina = new Pavimentazione(pCucina, 42);
        
        PiastrellaRomboidale pBagno = new PiastrellaRomboidale(5, 4, 2);
        Pavimentazione bagno = new Pavimentazione(pBagno, 65);

        Pavimentazione casa = new Pavimentazione();
        casa.aggiungi(cucina, 1);
        casa.aggiungi(bagno, 2);

        System.out.println(String.format("Superficie totale casa: %d", casa.superficie()));
        System.out.println(String.format("Costo totale casa: %d", casa.costo()));
        */

        Scanner scanner = new Scanner(System.in);
        String line;
        Superficie p;
        List<Superficie> superfici = new ArrayList<>();
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            p = parse(line, superfici);
            if (p instanceof Pavimentazione) {
                System.out.println(String.format("%d\t%d", p.superficie(), p.costo()));
            }
            superfici.add(p);
        }
        scanner.close();
    }
}
