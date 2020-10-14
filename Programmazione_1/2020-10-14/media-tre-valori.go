package main

import "fmt"

func main() {
	var n1, n2, n3 int
	fmt.Print("Inserisci primo numero: ")
	fmt.Scan(&n1)
	fmt.Print("Inserisci secondo numero: ")
	fmt.Scan(&n2)
	fmt.Print("Inserisci terzo numero: ")
	fmt.Scan(&n3)
	var res float64
	res = (float64)(n1+n2+n3) / 3
	fmt.Println("Media dei tre numeri:", res)
}
