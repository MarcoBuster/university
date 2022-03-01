package intcode;

public class InstructionBneq implements Instruction {
    public static final int OPCODE = 05;

    @Override
    public void execute(Memory memory, InstructionPointer ip, Pointer rbr) {
        if (memory.get(ip.getFirstAddress()) == 0) {
            return;
        }
        ip.set(new MemoryAddress(memory.get(ip.getSecondAddress())));
    }
}
