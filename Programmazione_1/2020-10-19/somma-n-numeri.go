package main

import "fmt"

func main() {
	var n, i, s int
	fmt.Print("Inserisci numero N: ")
	fmt.Scan(&n)
	for i <= n {
		s += i
		i++
	}
	fmt.Println("Somma dei primi N numeri con ciclo for:", s)
	fmt.Println("Somma dei primi N numeri con Gauss:", n*(n+1)/2)
}
