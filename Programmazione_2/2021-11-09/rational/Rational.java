package rational;

import java.math.BigInteger;

public class Rational {
    private Integer n;
    private Integer d;

    public Rational(Integer n, Integer d) {
        if (d == 0) {
            throw new DivisionByZeroException();
        }
        this.n = n;
        this.d = d;
        this.simplify();
    }

    private void simplify() {
        for (int i = 2; i <= Math.min(this.n, this.d); i++) {
            if (this.n % i == 0 && this.d % i == 0) {
                this.n /= i;
                this.d /= i;
            }
        }
        assert this.repOK();
    }

    /**
     * Somma il numero razionale con un altro e ritorna il risultato
     *  
     * @param o l'altro razionale da sommare
     * @return un nuovo razionale risultante
     */
    public Rational sum(Rational o) {
        Integer lcm = (this.d * o.d) / (BigInteger.valueOf(this.d).gcd(BigInteger.valueOf(o.d))).intValue();
        Integer numerator = lcm / this.d * this.n + lcm / o.d * o.n;
        Rational res = new Rational(numerator, lcm);
        res.simplify();
        return res;
    }

    /**
     * @return il razionale opposto
     */
    public Rational minus() {
        return new Rational(-this.n, this.d);
    }

    /**
     * Sottrai un altro razionale al razionale stesso e ritorna il risultato
     * 
     * @param o l'altro razionale da sottrarre
     * @return un nuovo razionale risultante dalla sottrazione
     */
    public Rational sub(Rational o) {
        return this.sum(o.minus());
    }

    /**
     * Moltiplica un altro razionale al razionale stesso e ritorna il risultato
     * 
     * @param o l'altro razionale da moltiplicare
     * @return un nuovo razionale risultante dalla moltiplicazione
     */
    public Rational mul(Rational o) {
        Rational res = new Rational(this.n * o.n, this.d * o.d);
        res.simplify();
        return res;
    }

    /**
     * @return il razionale invertito
     */
    private Rational inverse() {
        return new Rational(this.d, this.n);
    }

    /**
     * Divide il razionale stesso con un altro razionale e ritorna il risultato
     * 
     * @param o l'altro razionale da dividere
     * @return un nuovo razionale risultante dalla divisione
     */
    public Rational div(Rational o) {
        return this.mul(o.inverse());
    }

    @Override
    public String toString() {
        this.simplify();
        return String.format("%d/%d", this.n, this.d);
    }

    public boolean repOK() {
        return this.d != 0;
    }

    @Override
    public Rational clone() {
        return new Rational(this.n, this.d);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Rational)) {
            return false;
        } 
        Rational otherCopy = ((Rational) other).clone();
        otherCopy.simplify();
        return this.n == otherCopy.n && this.d == otherCopy.d;
    }

    @Override
    public int hashCode() {
        return 31 * this.n + 63 * this.d;
    }

    public static void main(String args[]) {
        Rational r1 = new Rational(2, 3);
        Rational r2 = new Rational(4, 5);
        Rational r3 = r1.sum(r2);
        System.out.println(r3.toString());
        Rational r4 = new Rational(10, 15).mul(new Rational(2, 1));
        System.out.println(r4.toString());
        System.out.println(new Rational(10, 20).toString());
    }
}
