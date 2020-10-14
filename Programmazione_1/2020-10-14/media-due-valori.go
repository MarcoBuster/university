package main

import "fmt"

func main() {
	var n1, n2 int
	fmt.Print("Inserisci primo numero: ")
	fmt.Scan(&n1)
	fmt.Print("Inserisci secondo numero: ")
	fmt.Scan(&n2)
	var res float64
	res = (float64)(n1+n2) / 2
	fmt.Println("Media dei due numeri:", res)
}
