package simplemap;

import java.util.List;
import java.util.Objects;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;

public class SimpleMap {
    /**
     * Un Item è una singola associazione key -> value della mappa.
     * Implementa il metodo compareTo per l'ordinamento alfabetico dalla chiave.
     */
    private record Item(String key, Integer value) implements Comparable<Item> {
        public String toString() {
            return String.format("%s: %d", key, value);
        }

        @Override
        public int compareTo(Item other) {
            return this.key.compareTo(other.key);
        }
    }

    private List<Item> items;

    public SimpleMap() {
        this.items = new ArrayList<>();
    }

    /**
     * Inserisce un elemento nella mappa.
     * 
     * @param s: la chiave da inserire, di tipo stringa
     * @param n: il valore della chiave, di tipo intero
     */
    public void put(String s, Integer n) {
        this.items.add(new Item(s, n));
        assert this.repOK();
    }

    /**
     * Data una chiave ritorna un elemento della mappa, se presente.
     * 
     * @param s la chiave da cercare nella mappa
     * @return il valore dell'elemento nella mappa data la chiave
     * @throws KeyNotFoundException se la chiave non è presente nella mappa
     */
    public Integer get(String s) throws KeyNotFoundException {
        assert this.repOK();
        for (Item item : this.items) {
            if (item.key == s) {
                return item.value;
            }
        }
        throw new KeyNotFoundException();
    }

    /**
     * Rimuove un'associazione chiave->valore dalla mappa, se presente.
     * 
     * @param s la chiave dell'associazione da rimuovere
     * @throws KeyNotFoundException se la chiave non è presente nella mappa
     */
    public void remove(String s) throws KeyNotFoundException {
        assert this.repOK();
        Iterator<Item> iterator = this.items.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.key == s) {
                this.items.remove(item);
                return;
            }
        }
        throw new KeyNotFoundException();
    }

    /**
     * Genera e restituisce l'insieme delle chiavi della mappa.
     * 
     * @return l'insieme delle chiavi della mappa.
     */
    private List<String> keyset() {
        List<String> res = new LinkedList<>();
        for (Item item : this.items) {
            res.add(item.key);
        }
        return res;
    }

    public boolean repOK() {
        // Keys must be unique and not null
        List<String> seen = new LinkedList<>();
        for (String item : this.keyset()) {
            if (item == null || seen.contains(item)) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        assert this.repOK();
        Collections.sort(this.items);
        StringBuilder sb = new StringBuilder();
        for (Item item : this.items) {
            sb.append(item.toString() + " ");
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return 31 * Objects.hash(this.items);
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof SimpleMap && this.hashCode() == other.hashCode();
    }

    public static void main(String[] args) {
        SimpleMap map = new SimpleMap();
        map.put("a", 10);
        map.put("b", 20);
        map.put("c", 30);
        System.out.println(String.format("get(a)=%d", map.get("a")));
        System.out.println(map.toString());
        System.out.println(map.hashCode());
        map.put("d", 40);
        map.remove("b");
        System.out.println(map.toString());
    }
}
