package intcode;

public class InstructionSum implements Instruction {
    public static final int OPCODE = 01;

    @Override
    public void execute(Memory memory, InstructionPointer ip, Pointer rbp) {
        Integer result = memory.directAccess(ip.getFirstAddress()) + 
            memory.directAccess(ip.getSecondAddress());
        memory.directAccess(ip.getThirdAddress(), result);
    }
}
