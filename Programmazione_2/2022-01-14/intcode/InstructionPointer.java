package intcode;

public class InstructionPointer extends Pointer {
    private Integer opcode;
    private MemoryAddress first, second, third;
    private MemoryMode firstMode, secondMode, thirdMode;

    public InstructionPointer(Memory memory, MemoryAddress addr) {
        super(memory, addr);

        int cell = memory.get(addr);
        this.opcode = cell % 100;
        this.first = addr.shift(+1);
        this.second = addr.shift(+2);
        this.third = addr.shift(+3);

        // ABCDE
        // 00123 / 100 = 001
        cell /= 100;
        this.firstMode = MemoryMode.fromInteger(cell % 10);
        this.secondMode = MemoryMode.fromInteger(cell/10 % 10);
        this.thirdMode = MemoryMode.fromInteger(cell/100 % 10);
    }

    @Override
    public void set(MemoryAddress newAddress) {
        super.set(newAddress);
        this.opcode = memory.get(addr);
        this.first = addr.shift(+1);
        this.second = addr.shift(+2);
        this.third = addr.shift(+3);
    }

    public Integer getOpcode() {
        return this.opcode;
    }

    public MemoryAddress getFirst() {
        return this.first;
    }
    public MemoryAddress getSecond() {
        return this.second;
    }
    public MemoryAddress getThird() {
        return this.third;
    }

    public MemoryMode getFirstMode() {
        return this.firstMode;
    }
    public MemoryMode getSecondMode() {
        return this.secondMode;
    }
    public MemoryMode getThirdMode() {
        return this.thirdMode;
    }

    public String toString() {
        return "IP @" + this.addr.toString() + ": " + this.memory.get(addr) + "\t" +
            "args: " + this.first.toString() + ", " + this.second.toString() + ", " + 
            this.third.toString();
    }
    
}
