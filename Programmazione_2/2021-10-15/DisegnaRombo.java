/*
    https://github.com/prog2-unimi/esercitazioni/blob/aa2122/testi/e01/05-disegna_rombo/Testo.md
*/

import java.util.Scanner;

public class DisegnaRombo {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Integer n = in.nextInt();
        in.close();

        final int diagonal = 2*n+1;
        for (int i = 0; i < diagonal; i++) {
            for (int k = 0; k < diagonal; k++)
                if ((i <= n && k >= n-i && k < i+n+1)
                        || (i > n && k >= i-n && k-n < diagonal-i))
                    System.out.print("*");
                else
                    System.out.print(" ");
            System.out.println();
        }
    }
}
