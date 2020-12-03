package main

import "fmt"

// V3: La funzione ricorsiva genera la successione di Collatz a partire da n,
// ma invece di restituirla, la accumula in una slice di cui riceve
// il puntatore come parametro

func recursiveCollatzV3(n int, s *[]int) {
	*s = append(*s, n)
	if n == 1 {
		return
	}
	if n%2 == 0 {
		recursiveCollatzV3(n/2, s)
	} else {
		recursiveCollatzV3(n*3+1, s)
	}
}

func main() {
	var n int
	fmt.Print("n: ")
	fmt.Scan(&n)
	var s []int
	recursiveCollatzV3(n, &s)
	fmt.Println(s)
}
