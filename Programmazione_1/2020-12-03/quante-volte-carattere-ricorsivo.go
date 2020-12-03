package main

import (
	"fmt"
)

func recursiveFindOccurrences(s []rune, c rune) int {
	if len(s) == 0 {
		return 0
	}
	if s[0] == c {
		return 1 + recursiveFindOccurrences(s[1:], c)
	} else {
		return recursiveFindOccurrences(s[1:], c)
	}
}

func main() {
	var s []rune
	var c string

	for {
		fmt.Print("Insert a rune to add it to the list; x to exit: ")
		fmt.Scan(&c)
		if c == "x" {
			break
		}
		s = append(s, rune(c[0])) // rune(c[0]): I know it's not the best solution but I think (?) it's enough
	}
	fmt.Print("Insert the rune to find: ")
	fmt.Scan(&c)
	result := recursiveFindOccurrences(s, rune(c[0]))
	fmt.Println("# occurrences:", result)
}
