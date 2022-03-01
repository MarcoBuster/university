package intcode;

public class Pointer {
    protected Memory memory;
    protected MemoryAddress addr;

    public Pointer(Memory memory, MemoryAddress addr) {
        this.memory = memory;
        this.addr = addr;
    }

    public Integer value() {
        return this.memory.get(this.addr);
    }

    public void set(MemoryAddress newAddress) {
        this.addr = newAddress;
    }
}
