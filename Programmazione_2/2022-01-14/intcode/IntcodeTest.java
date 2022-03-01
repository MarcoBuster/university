package intcode;

import java.util.Scanner;

public class IntcodeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IntcodeVM vm = new IntcodeVM(scanner.nextLine());
        scanner.close();
        vm.run();
    }
}