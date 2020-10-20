package main

import "fmt"

func main() {
	var x, y int
	fmt.Print("Inserisci primo numero: ")
	fmt.Scan(&x)
	fmt.Print("Inserisci secondo numero: ")
	fmt.Scan(&y)
	for r := x % y; r != 0; {
		x = y
		y = r
		r = x % y
	}
	fmt.Println("MCD=", y)
}
