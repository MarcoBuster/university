package main

// V1: La funzione ricorsiva chiama ricorsivamente se stessa
// a partire da n (n>0) fino a raggiungere il caso base

import "fmt"

func recursiveCollatzV1(n int) int {
	fmt.Println(n)
	if n == 1 {
		return 1
	}
	if n%2 == 0 {
		return recursiveCollatzV1(n / 2)
	} else {
		return recursiveCollatzV1(n*3 + 1)
	}
}

func main() {
	var n int
	fmt.Print("n: ")
	fmt.Scan(&n)
	recursiveCollatzV1(n)
}
