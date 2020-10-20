package main

import "fmt"

func main() {
	var n, s int
	fmt.Println("Stampa le prime n potenze di 2")
	fmt.Print("Inserisci n massimo: ")
	fmt.Scan(&n)
	s = 1
	for i := 1; i <= n; i++ {
		s *= 2
		fmt.Print("2^", i, "=", s, "\n")
	}
}
