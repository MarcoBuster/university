package bancarelle;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class RandomCompratore extends Compratore {
    public RandomCompratore(Set<Bancarella> bancherelle) {
        super(bancherelle);
    }

    @Override
    public Acquisto compra(int num, Giocattolo giocattolo) {
        final List<Bancarella> listaBancherelle = new LinkedList<>();
        for (Bancarella bancarella : bancherelle) {
            listaBancherelle.add(bancarella);
        }
        
        Map<Bancarella, Integer> acquistiBancherelle = new HashMap<>();
        int quantitàTotale = 0;
        int prezzoTotale = 0;
        for (int i = 0; i < num && listaBancherelle.size() > 0; i++) {
            Collections.shuffle(listaBancherelle);
            Bancarella scelta = listaBancherelle.get(0);
            
            int[] info;  // info[0] = quantità, info[1] = prezzo unitario
            try {
                info = scelta.inserzioni().get(giocattolo);
            } catch (NoSuchElementException e) {
                listaBancherelle.remove(scelta);
                continue;
            }
            if (info[0] <= 0) {
                listaBancherelle.remove(scelta);
                continue;
            }

            scelta.vendi(giocattolo, 1);
            Integer quantitàGiàAcquistata = acquistiBancherelle.get(scelta);
            if (quantitàGiàAcquistata == null) {
                quantitàGiàAcquistata = 0;
            }
            acquistiBancherelle.put(scelta, quantitàGiàAcquistata+1);
            quantitàTotale++;
            prezzoTotale += scelta.prezzo(giocattolo, 1);
        }
        return new Acquisto(giocattolo, quantitàTotale, prezzoTotale, acquistiBancherelle);
    }
}
