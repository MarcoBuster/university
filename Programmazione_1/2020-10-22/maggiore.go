package main

// Scrivere un programma Go maggiore.go che legge due interi e stampa il maggiore fra i due.

import "fmt"

func main() {
	var n1, n2 int
	fmt.Print("Inserisci n_1: ")
	fmt.Scan(&n1)
	fmt.Print("Inserisci n_2: ")
	fmt.Scan(&n2)
	if n1 > n2 {
		fmt.Println(n1)
	} else {
		fmt.Println(n2)
	}
}
