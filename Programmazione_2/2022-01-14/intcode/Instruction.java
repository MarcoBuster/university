package intcode;

public interface Instruction {
    public void execute(Memory memory, InstructionPointer ip, Pointer relativeBasePointer);
}
