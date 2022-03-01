package intcode;

public class MemoryAddress implements Comparable<MemoryAddress> {
    public static final MemoryAddress ZERO = new MemoryAddress(0);

    private Integer address;

    public MemoryAddress(int address) {
        if (address < 0) {
            throw new IllegalArgumentException("address can't be < 0!");
        }
        this.address = address;
    }

    public Integer toInteger() {
        return this.address;
    }

    public MemoryAddress shift(Integer amount) {
        return new MemoryAddress(this.address + amount);
    }

    @Override
    public int compareTo(MemoryAddress other) {
        return this.address.compareTo(other.address);
    }

    public int hashCode() {
        return this.address * 31;
    }

    public String toString() {
        return address.toString();
    }
}
