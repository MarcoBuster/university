package intcode;

public class InstructionIncRbr implements Instruction {
    public static final int OPCODE = 9;

    @Override
    public void execute(Memory memory, InstructionPointer ip, Pointer rbr) {
        rbr.set(rbr.addr.shift(memory.get(ip.getFirstAddress())));
    }
}
