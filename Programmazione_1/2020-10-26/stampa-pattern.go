package main

import "fmt"

func main() {
	var n int
	// Pattern 1: stampa * in n righe e n colonne
	fmt.Print("P1. Inserisci n: ")
	fmt.Scan(&n)
	for i := 0; i < n; i++ {
		for k := 0; k < n; k++ {
			fmt.Print("*")
		}
		fmt.Print("\n")
	}

	// Pattern 2: stampa * in n righe a mo' di triangolo ma con la base a sinistra
	fmt.Print("P2. Inserisci n: ")
	fmt.Scan(&n)
	for i := 0; i < n; i++ {
		for k := n; k > i; k-- {
			fmt.Print("*")
		}
		fmt.Print("\n")
	}

	// Pattern 3: boh non so descriverlo in una linea di commento
	fmt.Print("P3. Inserisci n: ")
	fmt.Scan(&n)
	for i := n; i >= 0; i-- {
		for k := 0; k < i; k++ {
			if i == n || k == 0 || k == i-1 {
				fmt.Print("*")
			} else {
				fmt.Print(" ")
			}
		}
		fmt.Println()
	}
}
