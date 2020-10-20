package main

import "fmt"

func main() {
	var n int
	fmt.Println("Countdown")
	fmt.Print("Inserisci un numero n: ")
	fmt.Scan(&n)
	for i := n; i != 0; i-- {
		fmt.Println(i)
	}
}
