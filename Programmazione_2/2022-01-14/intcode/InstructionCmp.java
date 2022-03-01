package intcode;

public class InstructionCmp implements Instruction {
    public static final int OPCODE = 07;

    @Override
    public void execute(Memory memory, InstructionPointer ip, Pointer rbr) {
        if (memory.get(ip.getFirstAddress()) < memory.get(ip.getSecondAddress())) {
            memory.directAccess(ip.getThirdAddress(), 1);
        } else {
            memory.directAccess(ip.getThirdAddress(), 0);
        }
    }
}
