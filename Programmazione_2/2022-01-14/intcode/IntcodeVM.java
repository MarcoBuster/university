package intcode;

public class IntcodeVM {
    private Memory memory;
    private InstructionPointer instructionPointer;
    private Pointer relativeBaseRegister;
    private boolean halted = false;

    public IntcodeVM(String code) {
        System.out.println("(DEBUG) Input code: " + code);

        String[] rawInstructions = code.split(",", 0);
        this.memory = new Memory(rawInstructions.length);

        MemoryAddress addr = MemoryAddress.ZERO;
        for (String instr : rawInstructions) {
            this.memory.set(addr, Integer.parseInt(instr));
            addr = addr.shift(+1);
        }
        this.instructionPointer = new InstructionPointer(memory, MemoryAddress.ZERO);
        this.relativeBaseRegister = new Pointer(memory, MemoryAddress.ZERO);
    }

    public void run() {
        int i = 0;
        while (!halted && i < 10) {
            runInstruction();
            i++;
        }
    }

    private void runInstruction() {
        System.out.println(memory.toString());
        System.out.println(instructionPointer.toString());

        Instruction instr;
        System.out.println("RUNNING OPCODE=" + instructionPointer.getOpcode());
        switch (instructionPointer.getOpcode()) {
            case 1:
                instr = new InstructionSum();
                instr.execute(memory, instructionPointer, relativeBaseRegister);
                instructionPointer.set(instructionPointer.addr.shift(4));
                break;
            
            case 2:
                instr = new InstructionMult();
                instr.execute(memory, instructionPointer, relativeBaseRegister);
                instructionPointer.set(instructionPointer.addr.shift(4));
                break;

            case 3:
                instr = new InstructionStdin();
                instr.execute(memory, instructionPointer, relativeBaseRegister);
                instructionPointer.set(instructionPointer.addr.shift(2));
                break;

            case 4:
                instr = new InstructionStdout();
                instr.execute(memory, instructionPointer, relativeBaseRegister);
                instructionPointer.set(instructionPointer.addr.shift(2));
                break;

            case 5:
                instr = new InstructionBneq();
                instr.execute(memory, instructionPointer, relativeBaseRegister);
                break;

            case 6:
                instr = new InstructionBeq();
                instr.execute(memory, instructionPointer, relativeBaseRegister);
                break;

            case 7:
                instr = new InstructionCmp();
                instr.execute(memory, instructionPointer, relativeBaseRegister);
                instructionPointer.set(instructionPointer.addr.shift(4));
                break;

            case 8:
                instr = new InstructionCmp();
                instr.execute(memory, instructionPointer, relativeBaseRegister);
                instructionPointer.set(instructionPointer.addr.shift(4));
                break;
            
            case 9:
                instr = new InstructionIncRbr();
                instr.execute(memory, instructionPointer, relativeBaseRegister);
                instructionPointer.set(instructionPointer.addr.shift(2));
                break;

            case 99:
                this.halted = true;
                break;
        }

        System.out.println("\npost-execution:");

        System.out.println(memory.toString());
        System.out.println(instructionPointer.toString());

        System.out.println("\n-------------\n");
    }
}
