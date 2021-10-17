/*
    https://github.com/prog2-unimi/esercitazioni/blob/aa2122/testi/e01/02-prova_del_nove/Testo.md
*/

import java.util.Scanner;

public class ProvaDelNove {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Integer n = in.nextInt();
        in.close();

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 1; k < n; k++) {
                    if ((i % 9 * j % 9) % 9 == k % 9
                            && (i * j) != k)
                        System.out.println(i + " " + j + " " + k);
                }
            }
        }
    }
}
