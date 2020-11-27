package main

import (
	"fmt"
	"strconv"
)

func main() {
	var num int
	fmt.Print("Inserisci un numero: ")
	fmt.Scan(&num)

	numStr := strconv.Itoa(num)
	mappings := make(map[rune]string)
OuterLoop:
	for _, c := range numStr {
		for i := range mappings {
			if c == i {
				continue OuterLoop
			}
		}
		var tmp string
		fmt.Printf("Parola per %c? ", c)
		fmt.Scan(&tmp)
		mappings[c] = tmp
	}
	for _, c := range numStr {
		fmt.Printf("%s ", mappings[c])
	}
}
