package intcode;

import java.util.Scanner;

public class InstructionStdin implements Instruction {
    public static final int OPCODE = 03;

    @Override
    public void execute(Memory memory, InstructionPointer ip, Pointer rbp) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        scanner.close();
        memory.directAccess(ip.getFirstAddress(), n);
    }
}

