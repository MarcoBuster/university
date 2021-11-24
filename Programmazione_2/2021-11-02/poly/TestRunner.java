package poly;

import java.util.Scanner;

public class TestRunner {

  private static void print(Poly p) {
    final int degree = p.degree();
    for (int i = 0; i <= degree; i++) System.out.printf("%d %d\n", p.coeff(i), i);
    System.out.println();
  }

  public static void main(String[] args) throws NegativeExponentException {
    try (Scanner s = new Scanner(System.in)) {
      int termsP = s.nextInt(), termsQ = s.nextInt();
      Poly p = new Poly(), q = new Poly();
      for (int i = 0; i < termsP; i++) p = p.add(new Poly(s.nextInt(), s.nextInt()));
      print(p);
      for (int i = 0; i < termsQ; i++) q = q.add(new Poly(s.nextInt(), s.nextInt()));
      print(q);
      print(p.minus());
      print(p.add(q));
      print(p.sub(q));
      print(p.mul(q));
    }
  }
}