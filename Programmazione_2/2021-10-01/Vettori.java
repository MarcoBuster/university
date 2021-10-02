import java.util.Arrays;

public class Vettori {
    public static void main(String[] args) {
        // Dichiarazione di un array di interi
        int[] y = {1, 2, 3, 4, 5};
        // Anche gli array sono un oggetti

        // Stampa il riferimento, non i valori
        System.out.println(y); 
        // Per stampare i valori usiamo Arrays.toString()
        System.out.println(Arrays.toString(y));
        System.out.println(y.toString());

        String[] w = {"ciao", "mamma"};
        System.out.println(Arrays.toString(w));
        w[0] = "addio";
        System.out.println(Arrays.toString(w));

        int[][] m = {{1, 2}, {3, 4, 5}};
        int[] v = m[0];  // ora v referenzia il primo vettore di m 

        System.out.println("m prima delle modifiche");
        System.out.println(Arrays.toString(m[0]));
        System.out.println(Arrays.toString(m[1]));
        System.out.println("v prima delle modifiche");
        System.out.println(Arrays.toString(v));

        v[1] = 100;

        // Anche m[0] è stato modificato, perché è referenziato da v
        System.out.println("m dopo le modifiche");
        System.out.println(Arrays.toString(m[0]));
        System.out.println(Arrays.toString(m[1]));
        System.out.println("v dopo le modifiche");
        System.out.println(Arrays.toString(v));
    }
}
