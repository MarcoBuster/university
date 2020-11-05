package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	fmt.Println("Inserisci una frase: ")
	b := bufio.NewScanner(os.Stdin)
	b.Scan()
	s := b.Text()

	contaParole := 0
	for i, r := range s {
		fmt.Println(i, r)
	}

	for i := 0; i < len(s); i++ {
		if s[i] != ' ' && (i == 0 || s[i-1] == ' ') {
			contaParole++
		}
	}
	fmt.Println("Il numero di parole è:", contaParole)
}
