package main

import (
	"fmt"
	"os"
)

func contieneDecimale(parola string) bool {
	for _, c := range parola {
		if c >= 48 && c <= 57 {
			return true
		}
	}
	return false
}

func main() {
	if len(os.Args) < 2 {
		fmt.Println("Troppi pochi argomenti")
		os.Exit(1)
	}
	input := os.Args[1:]
	fmt.Println(input)

	saltate := 0
	for _, p := range input {
		if contieneDecimale(p) {
			saltate++
			continue
		}
		fmt.Print(p, " ")
	}
	fmt.Print(saltate)
}
