package main

import "fmt"

func main() {
	var s, rev string
	fmt.Print("Inserisci stringa: ")
	fmt.Scan(&s)

	rev = ""
	for _, r := range s {
		rev = string(r) + rev
	}
	fmt.Println(rev)
}
