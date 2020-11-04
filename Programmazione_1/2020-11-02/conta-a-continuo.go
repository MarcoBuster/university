package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	var s string
	b := bufio.NewScanner(os.Stdin)

	for b.Scan() {
		// Leggo una riga
		s = b.Text()
		// Conto usando il contatore c i caratteri a nella riga
		c := 0
		for _, r := range s {
			if r == 'a' {
				c++
			}
		}
		fmt.Println(c)
	}
}
