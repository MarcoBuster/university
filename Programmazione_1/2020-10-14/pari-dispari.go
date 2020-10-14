package main

import "fmt"

func main() {
	var n int
	fmt.Print("Inserisci un numero: ")
	fmt.Scan(&n)
	if n%2 == 0 {
		fmt.Println("Il numero è pari")
	} else {
		fmt.Println("Il numero è dispari")
	}
}
