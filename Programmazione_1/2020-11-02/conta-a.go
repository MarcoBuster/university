package main

import "fmt"

func main() {
	var s string
	fmt.Print("Inserisci una stringa: ")
	fmt.Scan(&s)

	c := 0
	for _, r := range s {
		if r == 'a' {
			c++
		}
	}

	fmt.Println(c)
}
