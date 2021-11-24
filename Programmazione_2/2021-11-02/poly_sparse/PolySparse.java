/*
    https://github.com/prog2-unimi/esercitazioni/blob/aa2122/testi/e03/03-poly_sparse/Testo.md
*/

package poly_sparse;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class PolySparse {
    private final List<Term> terms;

    /**
     * Record immutabile che rappresenta un monomio, termine di un polinomio.
     * 
     * @param coeff coefficiente del monomio
     * @param degree grado del monomio
     */
    public record Term(int coeff, int degree) {
        public Term {
            if (degree < 0) {
                throw new NegativeArraySizeException();
            }
        }

        @Override
        public String toString() {
            if (coeff == 0) {
                return "";
            }
            
            StringBuilder sb = new StringBuilder();
            if (coeff >= 0) {
                sb.append("+");
            } else {
                sb.append("-");
            }
            sb.append(String.format("%dx^%d", coeff, degree));
            return sb.toString();
        }
    }

    /**
     * @return un polinomio vuoto
     */
    public PolySparse() {
        this.terms = new ArrayList<Term>();
    }

    /**
     * Crea un nuovo polinomio di tipo cx^n
     * 
     * @param c il coefficiente 
     * @param n l'esponente, deve essere >= 0
     * @return un nuovo polinomio di tipo cx^n
     * @throws NegativeExponentException se l'esponente dato è < 0
     */
    public PolySparse(int c, int d) {
        this();
        if (c != 0) {
            this.terms.add(new Term(c, d));
        }
    }

    /**
     * @return il grado del polinomio
     */
    public int degree() {
        int max = -1;
        for (Term term : this.terms) {
            if (term.degree > max) {
                max = term.degree;
            }
        }
        return max;
    }

    /**
     * Restitusci il coefficiente a un determinato grado del polinomio
     * 
     * @param d un grado del polinomio, deve essere >= 0
     * @return the coefficient, can be zero 
     * @throws NegativeExponentException se l'esponente dato è < 0
     */
    public int coeff(int d) {
        for (Term term : this.terms) {
            if (term.degree == d) {
                return term.coeff;
            }
        }
        return 0;
    }

    private static int maxDegree(PolySparse a, PolySparse b) {
        return Math.max(a.degree(), b.degree());
    }

    /**
     * Crea un nuovo polinomio aggiungendo se stesso ad un altro
     * 
     * @param p l'altro polinomio da sommare
     * @return il polinomio risultante dalla somma
     */
    public PolySparse add(PolySparse p) {
        int degree = maxDegree(this, p);
        PolySparse res = new PolySparse(0, degree);
        int sum;
        for (int i = 0; i <= degree; i++) {
            sum = this.coeff(i) + p.coeff(i);
            if (sum == 0) {
                continue;
            }
            res.terms.add(new Term(sum, i));
        }
        return res;
    }

    /**
     * @return il polinomio opposto
     */
    public PolySparse minus() {
        int degree = this.degree();
        PolySparse res = new PolySparse(0, degree);

        for (int i = 0; i <= degree; i++) {
            res.terms.add(new Term(-this.coeff(i), i));
        }
        return res;
    }

    /**
     * Crea un nuovo polinomio sottraendo un altro a se stesso
     * 
     * @param p l'altro polinomio da sottrarre
     * @return il polinomio risultante dalla differenza
     */
    public PolySparse sub(PolySparse p) {
        return this.add(p.minus());
    }

    /**
     * Crea un nuovo polinomio moltiplicando se stesso con un altro
     * 
     * @param q l'altro polinomio da moltiplicare
     */
    public PolySparse mul(PolySparse q) {
        int degree = this.degree() + q.degree();
        PolySparse res = new PolySparse(0, degree);

        int mul;
        int resCoeff;
        for (int i = 0; i <= this.degree(); i++) {
            for (int j = 0; j <= q.degree(); j++) {
                final int d = i + j;
                resCoeff = res.coeff(d);
                if (resCoeff != 0) {
                    res.terms.removeIf(t -> (t.degree == d));
                }
                mul = this.coeff(i) * q.coeff(j);
                res.terms.add(new Term(mul + resCoeff, d));
            }
        }
        return res;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        List<Term> termsCopy = new ArrayList<>(this.terms);
        Collections.reverse(termsCopy);
        for (Term term : termsCopy) {
            sb.append(term.toString() + " ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        PolySparse a = new PolySparse();
        PolySparse b = new PolySparse(4, 1);
        System.out.println("129b=" + b.toString() + "\tdegree=" +
         ((Integer) b.degree()).toString());
         PolySparse c = b.add(a);
        System.out.println("c=" + c.toString());
        c = c.add(b);
        System.out.println(c.toString());
        c = c.add(b);
        System.out.println(c.toString());
        c = c.add(new PolySparse(5, 2));
        System.out.println(c.toString());
        c = c.add(new PolySparse(5, 2));
        System.out.println(c.toString());
        c = c.add(new PolySparse(5, 0));
        System.out.println(c.toString());
        PolySparse cm = c.minus();
        System.out.println(cm.toString());
        System.out.println("c=" + c.toString());
        System.out.println("b=" + b.toString() + "\tb.degree() = " +
         ((Integer) b.degree()).toString());
        c = c.mul(b);
        System.out.println(c.toString());
    }
}
