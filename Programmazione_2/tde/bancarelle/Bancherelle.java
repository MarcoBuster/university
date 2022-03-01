package bancarelle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Bancherelle {
    public static void main(final String[] args) {

        /* Lettura dei parametri dalla linea di comando */
        final int numDaComprare = Integer.parseInt(args[0]);
        final Giocattolo giocattoloDaComprare = new Giocattolo(args[1], args[2]);
    
        /* Lettura del flusso di ingresso */
        final Scanner s = new Scanner(System.in);
    
        final int numBancarelle = s.nextInt();
        final Set<Bancarella> bancarelle = new HashSet<>(numBancarelle);
        final Map<Giocattolo, Integer> giocattolo2prezzo = new HashMap<>();
        final Inventario inventario = new Inventario();
    
        for (int b = 0; b < numBancarelle; b++) {
          /* Lettura di una bancarella */
          final String proprietario = s.next();
          final int numGiochi = s.nextInt();
          for (int g = 0; g < numGiochi; g++) {
            /* Lettura dei giochi della bancarella */
            final int num = s.nextInt();
            final String nome = s.next();
            final String materiale = s.next();
            final int prezzo = s.nextInt();
            final Giocattolo giocattolo = new Giocattolo(nome, materiale);
            inventario.aggiungi(giocattolo, num);
            giocattolo2prezzo.put(giocattolo, prezzo);
          }
    
          final Listino listino = new PoliticaMoltiplicativa(giocattolo2prezzo);
          
    
          final Bancarella bancarella = new Bancarella(proprietario, inventario, listino);
          bancarelle.add(bancarella);
        }
    
        s.close();
    
        final Compratore compratore = new RandomCompratore(bancarelle);
        
    
        final Acquisto ordine = compratore.compra(numDaComprare, giocattoloDaComprare);
        System.out.println(ordine);
      }
}
