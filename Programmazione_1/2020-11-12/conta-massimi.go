package main

import "fmt"

func main() {
	var numero int
	fmt.Scan(&numero)
	count := 1
	max := numero
	for i := 1; i < 10; i++ {
		fmt.Scan(&numero)
		if numero == max {
			count++
		} else if numero > max {
			max = numero
			count = 1
		}
	}
	fmt.Println("Numero massimo:", max)
	fmt.Println("Conteggio numero massimo:", count)
}
