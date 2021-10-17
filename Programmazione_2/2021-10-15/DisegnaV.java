/*
    https://github.com/prog2-unimi/esercitazioni/blob/aa2122/testi/e01/03-disegna_v/Testo.md
*/

import java.util.Scanner;

public class DisegnaV {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Integer n = in.nextInt();
        in.close();

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n*2; k++) {
                if (k == i || k == (n*2)-(i+2)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
