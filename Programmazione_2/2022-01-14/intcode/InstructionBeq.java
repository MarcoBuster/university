package intcode;

public class InstructionBeq implements Instruction {
    public static final int OPCODE = 06;

    @Override
    public void execute(Memory memory, InstructionPointer ip, Pointer rbr) {
        if (memory.get(ip.getFirstAddress()) != 0) {
            return;
        }
        ip.set(new MemoryAddress(memory.get(ip.getSecondAddress())));
    }
}
