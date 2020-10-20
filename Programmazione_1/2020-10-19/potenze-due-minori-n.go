package main

import "fmt"

func main() {
	var n, s int
	fmt.Println("Stampa le potenze di 2 <= n")
	fmt.Print("Inserisci n massimo: ")
	fmt.Scan(&n)
	s = 1
	for i := 1; s*2 <= n; i++ {
		s *= 2
		fmt.Print("2^", i, "=", s, "\n")
	}
}
