package intcode;

import java.util.HashMap;
import java.util.Map;

public class Memory {
    private Map<Integer, Integer> contents;
    private MemoryAddress maxAddress;

    public Memory(int size) {
        this.contents = new HashMap<>();
        initMemory(size);
    }

    private void initMemory(int size) {
        for (int i = this.contents.size(); i < size; i++) {
            this.contents.put(i, 0);
        }
        this.maxAddress = new MemoryAddress(size);
    }

    public Integer get(MemoryAddress addr) {
        if (addr.compareTo(this.maxAddress) >= 0) {
            return 0;
        }
        return this.contents.get(addr.toInteger());
    }

    // TODO: make this method private
    public void set(MemoryAddress addr, Integer content) {
        System.out.println("Set mem @ " + addr.toString() + " to content " + content.toString());
        if (addr.compareTo(this.maxAddress) >= 0) {
            initMemory(addr.toInteger());
        }
        this.contents.put(addr.toInteger(), content);
    }

    // Modalità 0, indirizzamento diretto: il parametro è l'indirizzo di una cella che dev'essere acceduta per la scrittura o la lettura.
    public Integer directAccess(MemoryAddress addr) {
        return this.get(new MemoryAddress(this.get(addr)));
    }
    public void directAccess(MemoryAddress addr, Integer newValue) {
        this.set(new MemoryAddress(this.get(addr)), newValue);
    }
    
    // Modalità 2, indirizzamento indiretto: il parametro è aggiunto al relative base register 
    // per ottenere l'indirizzo della cella che dev'essere acceduta per la scrittura o la lettura.
    public Integer indirectAccess(MemoryAddress addr, Pointer rbr) {
        return this.get(new MemoryAddress(rbr.value() + this.get(addr)));
    }
    public void indirectAccess(MemoryAddress addr, Pointer rbr, Integer newValue) {
        this.set(new MemoryAddress(rbr.value() + this.get(addr)), newValue);
    }

    public Integer access(MemoryAddress addr, MemoryMode mode, Pointer rbr) {
        switch (mode) {
            case MemoryMode.DIRECT_ACCESS:
            
        }
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.contents.toString() + "\n");
        sb.append("[");
        for (MemoryAddress i = MemoryAddress.ZERO; i.compareTo(this.maxAddress) < 0; i = i.shift(+1)) {
            sb.append(this.get(i).toString());
            sb.append(i.shift(+1).compareTo(maxAddress) < 0 ? "," : "]");
        }
        return sb.toString();
    }
}
