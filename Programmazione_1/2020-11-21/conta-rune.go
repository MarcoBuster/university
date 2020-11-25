package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	var freq map[rune]int
	freq = make(map[rune]int)
	b := bufio.NewScanner(os.Stdin)
	for b.Scan() {
		riga := b.Text()
		for _, r := range riga {
			freq[r]++
		}
	}
	for r, f := range freq {
		fmt.Printf("%c\t%5d\n", r, f)
	}
}
