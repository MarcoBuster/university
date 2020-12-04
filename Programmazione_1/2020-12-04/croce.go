package main

// Data n, fai un programma che disegni una pattern così:
//     * 		] n
//     * 		]
// * * * * *
//     *
//     *
// (esempio con n=2)

import "fmt"

func main() {
	fmt.Print("Inserisci n: ")
	var n int
	fmt.Scan(&n)

	for i := 0; i < n*2+1; i++ {
		for k := 0; k < n*2+1; k++ {
			if i != n && k != n {
				fmt.Print(" ")
			} else {
				fmt.Print("*")
			}
			fmt.Print(" ")
		}
		fmt.Println()
	}
}
