package main

import "fmt"

func divisioneByValue(x int, y int) (float64, int) {
	return float64(x) / float64(y), x % y
}

func divisioneByReference(x int, y int, risultato *float64, resto *int) {
	*risultato = float64(x) / float64(y)
	*resto = x % y
}

func main() {
	var x, y int
	fmt.Print("Inserisci x: ")
	fmt.Scan(&x)
	fmt.Print("Inserisci y: ")
	fmt.Scan(&y)

	fmt.Println("Risultato by value")
	risultato, resto := divisioneByValue(x, y)
	fmt.Println("Risultato:", risultato)
	fmt.Println("Resto:", resto)

	risultato, resto = 0, 0
	fmt.Println("Risultato by reference")
	divisioneByReference(x, y, &risultato, &resto)
	fmt.Println("Risultato:", risultato)
	fmt.Println("Resto:", resto)
}
