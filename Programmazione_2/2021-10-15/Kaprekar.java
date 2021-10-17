/*
    https://github.com/prog2-unimi/esercitazioni/blob/aa2122/testi/e01/06-kaprekar/Testo.md
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Kaprekar {
    public static final int KAPREKAR = 6174;
    public static final int N_LENGTH = 4;

    public static ArrayList<Integer> intToDigits(Integer n) {
        ArrayList<Integer> digits = new ArrayList<>();
        for (int i = 0; i < N_LENGTH; i++)
            digits.add((int) (n / Math.pow(10, i) % 10));
        return digits;
    }
    public static Integer digitsToInt(ArrayList<Integer> digits, Boolean reverse) {
        Integer n = 0;
        for (int i = 0; i < N_LENGTH; i++)
            n += (int) (digits.get(!reverse ? i : N_LENGTH-1-i) * Math.pow(10, i));
        return n;
    }

    public static int transform(int n) {
        ArrayList<Integer> digits = intToDigits(n);
        Collections.sort(digits);
        Integer n1 = digitsToInt(digits, false);
        Integer n2 = digitsToInt(digits, true);
        return (int) Math.abs((double) n1 - n2);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Integer n = in.nextInt();
        in.close();

        System.out.println(n);

        while (n != KAPREKAR) {
            n = transform(n);
            System.out.println(n);
        };
    }
}
