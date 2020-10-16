package main

// Esercizio: stabilire se un numero intero
// contiene qualche zero nelle ultime tre cifre a dx

import "fmt"

func main() {
	var num int
	fmt.Print("Inserisci numero: ")
	fmt.Scan(&num)
	if num%10 == 0 || (num-(num%10))%100 == 0 || (num-(num%100))%1000 == 0 {
		fmt.Println("Il numero contiene uno zero in una delle ultime tre cifre a destra")
	} else {
		fmt.Println("Il numero non contiene uno zero in una delle ultime tre cifre a destra")
	}
}
