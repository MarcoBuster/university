package main

import (
	"fmt"
	"os"
)

func anagrammiASCII(s string) map[string]bool {
	if s == "" {
		return map[string]bool{"": true}
	}
	var risultato map[string]bool
	risultato = make(map[string]bool)
	for i := 0; i < len(s); i++ {
		resto := s[:i] + s[i+1:]
		anagResto := anagrammiASCII(resto)
		for x := range anagResto {
			risultato[string(s[i])+x] = true
		}
	}
	return risultato
}

func main() {
	s := os.Args[1]
	lista := anagrammiASCII(s)
	for x := range lista {
		fmt.Println(x)
	}
}
