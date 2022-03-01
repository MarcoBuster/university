package algebretta;

import java.util.Scanner;

public class Algebretta {
    private static Matrice matriceDaOperando(String operando) {
        int[][] valori = Parser.valoriMatrice(operando);
        switch (Parser.tipoMatrice(operando)) {
            case 'Z':
                return new MatriceNulla(valori);

            case 'D':
                return new MatriceDiagonale(valori);

            case 'I':
                return new MatriceIdentità(valori);
            
            default:
                return new MatriceDensa(valori);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] linea = Parser.partiOperazione(scanner.nextLine());
            String op1 = linea[0];
            String op2 = linea[2];
            String op = linea[1];
            
            Integer s = null;
            if (Parser.èScalare(op1)) {
                s = Parser.valoreScalare(op1);
            }
            if (Parser.èScalare(op2)) {
                s = Parser.valoreScalare(op2);
            }

            VettoreDenso v1 = null, v2 = null;
            if (Parser.èVettore(op1)) {
                v1 = new VettoreDenso(Parser.valoriVettore(op1));
            }
            if (Parser.èVettore(op2)) {
                v2 = new VettoreDenso(Parser.valoriVettore(op2));
            }
            if (v1 == null && v2 != null) {
                v1 = v2;
            }

            Matrice m1 = null, m2 = null;
            if (Parser.èMatrice(op1)) {
                m1 = matriceDaOperando(op1);
            }
            if (Parser.èMatrice(op2)) {
                m2 = matriceDaOperando(op2);
            }
            if (m1 == null && m2 != null) {
                m1 = m2;
            }

            /*


    prodotto scalare vettore,

    somma tra vettori,

    prodotto scalare matrice,

    somma tra matrici,

    prodotto tra matrici,

    prodotto tra matrice e vettore.

            */

            // Prodotto scalare vettore
            if (s != null && v1 != null && op.equals("*")) {
                System.out.println(v1.per(s).toString());
            }

            // Somma tra vettori
            else if (v1 != null && v2 != null && op.equals("+")) {
                System.out.println(v1.più(v2).toString());
            }

            // Prodotto scalare matrice
            else if (s != null && m1 != null && op.equals("*")) {
                System.out.println(m1.per(s).toString());
            }

            // Somma tra matrici
            else if (m1 != null && m2 != null && op.equals("+")) {
                System.out.println(m1.più(m2).toString());
            }

            // Prodotto tra matrici
            else if (m1 != null && m2 != null && op.equals("*")) {
                System.out.println(m1.per(m2).toString());
            }

            // Prodotto tra matrice e vettore
            else if (m1 != null && v1 != null && op.equals("*")) {
                System.out.println(m1.per(v1).toString());
            }
        }
        scanner.close();
    }
}
