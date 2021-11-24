/*
    https://github.com/prog2-unimi/esercitazioni/blob/aa2122/testi/e03/02-poly/Testo.md
*/

package poly;

import java.lang.Math;

public class Poly {
    private final int[] coefficients;

    /**
     * @return un polinomio vuoto
     */
    public Poly() {
        this.coefficients = new int[0];
    }

    /**
     * Crea un nuovo polinomio di tipo cx^n
     * 
     * @param c il coefficiente 
     * @param n l'esponente, deve essere >= 0
     * @return un nuovo polinomio di tipo cx^n
     * @throws NegativeExponentException se l'esponente dato è < 0
     */
    public Poly(int c, int n) throws NegativeExponentException {
        if (n < 0) {
            throw new NegativeExponentException();
        }
        this.coefficients = new int[n+1];
        this.coefficients[n] = c;
    }

    /**
     * Crea un nuovo polinomio di tipo cx^n, senza scatenare eccezioni.
     * Da utilizzare solo se si è certi che l'esponente è positivo.
     * 
     * @param c il coefficiente
     * @param n l'esponente, deve essere >= 0
     * @return un nuovo polnomio di tipo cx^n
     */
    private static Poly unsafePoly(int c, int n) {
        Poly res = null;
        try {
            res = new Poly(c, n);
        } catch (NegativeExponentException e) {
            // Questo non dovrebbe accadere,
            // perché questo metodo si chiama solo
            // quando si stra creando un Poly da un altro Poly.
            return res;
        }
        return res;
    }

    /**
     * @return il grado del polinomio
     */
    public int degree() {
        return this.coefficients.length - 1;
    }

    /**
     * Restitusci il coefficiente a un determinato grado del polinomio
     * 
     * @param d un grado del polinomio, deve essere >= 0
     * @return the coefficient, can be zero 
     * @throws NegativeExponentException se l'esponente dato è < 0
     */
    public int coeff(int d) {
        if (d > this.degree()) {
            return 0;
        }
        return this.coefficients[d];
    }

    private static int maxDegree(Poly a, Poly b) {
        return Math.max(a.degree(), b.degree());
    }

    /**
     * Crea un nuovo polinomio aggiungendo se stesso ad un altro
     * 
     * @param p l'altro polinomio da sommare
     * @return il polinomio risultante dalla somma
     */
    public Poly add(Poly p) {
        int degree = maxDegree(this, p);
        Poly res = unsafePoly(0, degree);

        for (int i = 0; i <= degree; i++) {
            res.coefficients[i] = this.coeff(i) + p.coeff(i);
        }
        return res;
    }

    /**
     * @return il polinomio opposto
     */
    public Poly minus() {
        int degree = this.degree();
        Poly res = unsafePoly(0, degree);

        for (int i = 0; i <= this.degree(); i++) {
            res.coefficients[i] = -this.coeff(i);
        }
        return res;
    }

    /**
     * Crea un nuovo polinomio sottraendo un altro a se stesso
     * 
     * @param p l'altro polinomio da sottrarre
     * @return il polinomio risultante dalla differenza
     */
    public Poly sub(Poly p) {
        return this.add(p.minus());
    }

    /**
     * Crea un nuovo polinomio moltiplicando se stesso con un altro
     * 
     * @param q l'altro polinomio da moltiplicare
     */
    public Poly mul(Poly q) {
        int degree = this.degree() + q.degree();
        Poly res = unsafePoly(0, degree);

        for (int i = 0; i <= this.degree(); i++) {
            for (int j = 0; j <= q.degree(); j++) {
                res.coefficients[i+j] += this.coeff(i) * q.coeff(j);
            }
        }
        return res;
    }

    public String toString() {
        String res = "";
        for (Integer i = this.degree(); i >= 0; i--) {
            Integer c = this.coeff(i);
            if (c == 0) {
                continue;
            }
            if (c > 0) {
                res += "+";
            }
            if (i != 0) {
                res += (c.toString() + "x^" +  i.toString());
            } else {
                res += c.toString();
            }
            res += " ";
        }
        return res;
    }

    public static void main(String[] args) throws NegativeExponentException {
        Poly a = new Poly();
        Poly b = new Poly(4, 1);
        System.out.println("129b=" + b.toString() + "\tdegree=" +
         ((Integer) b.degree()).toString());
        Poly c = b.add(a);
        System.out.println("c=" + c.toString());
        c = c.add(b);
        System.out.println(c.toString());
        c = c.add(b);
        System.out.println(c.toString());
        c = c.add(new Poly(5, 2));
        System.out.println(c.toString());
        c = c.add(new Poly(5, 2));
        System.out.println(c.toString());
        c = c.add(new Poly(5, 0));
        System.out.println(c.toString());
        Poly cm = c.minus();
        System.out.println(cm.toString());
        System.out.println("c=" + c.toString());
        System.out.println("b=" + b.toString() + "\tb.degree() = " +
         ((Integer) b.degree()).toString());
        c = c.mul(b);
        System.out.println(c.toString());
    }
}
