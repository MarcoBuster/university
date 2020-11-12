package main

import "fmt"

func operazioniUnnamed(n1, n2 int) (int, int, int) {
	return n1 + n2, n1 * n2, n1 - n2
}
func operazioniNamed(n1, n2 int) (somma int, prodotto int, diff int) {
	somma = n1 + n2
	prodotto = n1 * n2
	diff = n1 - n2
	return
}

func main() {
	fmt.Println("Operazioni di base")

	var n1, n2 int
	fmt.Print("Inserisci n1: ")
	fmt.Scan(&n1)
	fmt.Print("Inserisci n2: ")
	fmt.Scan(&n2)

	s1, p1, d1 := operazioniUnnamed(n1, n2)
	s2, p2, d2 := operazioniNamed(n1, n2)

	if s1 == s2 && p1 == p2 && d1 == d2 {
		fmt.Println("Il programma funziona correttamente.")
	} else {
		fmt.Println("Il programma non funziona correttamente.")
	}
}
