package main

// Esercizio: controlla se un numero inserito ha una cifra 3

import (
	"fmt"
	"os"
)

func main() {
	var n int
	fmt.Println("Inserisci numero da controllare: ")
	fmt.Scan(&n)
	for n > 1 {
		if n%10 == 3 {
			fmt.Println("Il numero contiene un 3")
			os.Exit(0)
		}
		n /= 10
	}
	fmt.Println("Il numero non contiene un 3")
}
