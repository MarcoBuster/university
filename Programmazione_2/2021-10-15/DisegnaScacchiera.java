/*
    https://github.com/prog2-unimi/esercitazioni/tree/aa2122/testi/e01/04-disegna_scacchiera
*/

import java.util.Scanner;

public class DisegnaScacchiera {
    public static void main(String args[]) {
        final int N_COLUMNS = 8;
        final int N_ROWS = N_COLUMNS;

        Scanner in = new Scanner(System.in);
        Integer n = in.nextInt();
        in.close();

        for (int i = 0; i < N_COLUMNS * n; i++) {
            for (int k = 0; k < N_ROWS * n; k++) {
                if ((k / n) % 2 == (i / n) % 2)
                    System.out.print("-");
                else
                    System.out.print("#");
            }
            System.out.println();
        }
    }
}
