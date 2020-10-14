package main

// Esercizio: stabilire se un numero intero
// inserito termina o meno con 3

import "fmt"

func main() {
	var n int
	fmt.Print("Inserisci il numero: ")
	fmt.Scan(&n)
	if n%10 == 3 {
		fmt.Println("Il numero termina con 3!")
	} else {
		fmt.Println("Il numero non termina con 3")
	}
}
