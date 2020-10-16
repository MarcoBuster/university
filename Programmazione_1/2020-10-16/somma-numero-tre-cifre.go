package main

import "fmt"

func main() {
	var num int
	fmt.Println("Controllo se la somma del numero di tre cifre inserito è maggiore di 10")
	fmt.Print("Inserisci numero: ")
	fmt.Scan(&num)
	somma := num % 10                // prima cifra
	somma += (num%100 - num%10) / 10 // seconda cifra
	somma += (num - num%100) / 100   // terza cifra
	fmt.Println("La somma è", somma)
	if somma > 10 {
		fmt.Println("La somma delle cifre è maggiore di 10.")
	} else {
		fmt.Println("La somma delle cifre è minore di 10.")
	}
}
