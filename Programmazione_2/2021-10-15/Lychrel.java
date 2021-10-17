/*
    https://github.com/prog2-unimi/esercitazioni/blob/aa2122/testi/e01/01-lychrel/Testo.md
*/

import java.util.Scanner;

public class Lychrel {
    private static Long reverseLong(Long n) {
        String sn = n.toString();
        String reversed_sn = new String();
        for (int i=sn.length()-1; i >= 0; i--)
            reversed_sn += sn.charAt(i);
        return Long.parseLong(reversed_sn);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Long n = in.nextLong();
        in.close();
        System.out.println(n);

        String sn;
        Boolean exit = false;
        while (!exit) {
            n += reverseLong(n);
            sn = n.toString();

            exit = true;
            int num_length = sn.length();
            for (int i=1; i < num_length; i++) {
                if (sn.charAt(i) != sn.charAt(num_length-i-1)) {
                    exit = false;
                    break;
                }
            }
            System.out.println(n);
        }
    }
}
