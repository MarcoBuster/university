package main

import "fmt"

func main() {
	var h, m int
	fmt.Print("Inserisci ora: ")
	fmt.Scan(&h)
	fmt.Print("Inserisci minuto: ")
	fmt.Scan(&m)
	var res int
	res = (23 - h) * 60 + (60 - m)
	fmt.Println("Mancano", res, "minuti a mezzanotte")
}
