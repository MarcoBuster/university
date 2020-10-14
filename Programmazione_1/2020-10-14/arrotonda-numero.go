package main

import "fmt"

func main() {
	var num float64
	fmt.Print("Inserisci numero: ")
	fmt.Scan(&num)
	var arr int
	// Non posso utilizzare l'if in questo esercizio, quindi ce lo teniamo così
	arr = int(num + 0.5)
	fmt.Println("Numero arrotondato:", arr)
}
