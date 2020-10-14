package main

import "fmt"

func main() {
	var num float64
	fmt.Print("Inserisci numero: ")
	fmt.Scan(&num)
	var res float64
	res = num - float64(int(num))
	fmt.Println("Parte frazionaria:", res)
}
