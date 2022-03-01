package intcode;

public class InstructionStdout implements Instruction {
    public static final int OPCODE = 04;

    @Override
    public void execute(Memory memory, InstructionPointer ip, Pointer rbp) {
        Integer n = memory.directAccess(ip.getFirstAddress());
        System.out.print(Character.toChars(n));
    }
}
