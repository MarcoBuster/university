package main

import "fmt"

func main() {
	fmt.Println("Programma per stampare le 1, 2, ..., max sequenze di Collatz")
	var n, max int
	fmt.Print("Inserisci max: ")
	fmt.Scan(&max)
	for k := 1; k < max; k++ {
		n = k
		fmt.Print(n)
		for n != 1 {
			if n%2 == 0 {
				n = n / 2
			} else {
				n = 3*n + 1
			}
			fmt.Print(" -> ", n)
		}
		fmt.Println()
	}
}
