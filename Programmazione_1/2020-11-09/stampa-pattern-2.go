package main

import "fmt"

/*
	******
	**   *
    * *  *
    *  * *
    *   **
    ******
*/

func rigaPiena(n int) {
	for i := 0; i < n; i++ {
		fmt.Print("*")
	}
	fmt.Println()
}

func rigaIntermedia(sp1 int, sp2 int) {
	fmt.Print("*")
	for i := 0; i < sp1; i++ {
		fmt.Print(" ")
	}
	fmt.Print("*")
	for i := 0; i < sp2; i++ {
		fmt.Print(" ")
	}
	fmt.Println("*")
}

func main() {
	var n int
	fmt.Print("Inserisci n: ")
	fmt.Scan(&n)
	rigaPiena(n)
	for i := 0; i < n-2; i++ {
		rigaIntermedia(i, n-i-3)
	}
	rigaPiena(n)
}
