package main

import "fmt"

func main() {
	var n, c int
	fmt.Print("Inserisci numero: ")
	fmt.Scan(&n)
	if n == 0 {
		c = 1
	}
	for n != 0 {
		n /= 10
		c++
	}
	fmt.Println("Numero cifre:", c)
}
