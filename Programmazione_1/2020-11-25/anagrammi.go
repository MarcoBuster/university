package main

import (
	"fmt"
	"os"
)

func anagrammi(r []rune) []string {
	if len(r) == 0 {
		return []string{""}
	}
	var risultato []string
	for i := 0; i < len(r); i++ {
		// Considero la stringa r escluso l'i-esimo carattere
		resto := []rune(string(r[:i]) + string(r[i+1:]))
		// Ne calcolo gli anagrammi
		lista := anagrammi(resto)
		// E ora metto l'i-esimo carattere davanti a ciascun anagramma
		for _, x := range lista {
			risultato = append(risultato, string(r[i])+x)
		}
	}
	return risultato
}

func main() {
	// fmt
	s := os.Args[1]
	r := []rune(s)
	risultato := anagrammi(r)
	for _, x := range risultato {
		fmt.Println(x)
	}
}
