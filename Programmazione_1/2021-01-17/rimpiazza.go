package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	var parola string
	if len(os.Args) < 2 {
		os.Exit(0)
	}
	parola = os.Args[1]
	b := bufio.NewScanner(os.Stdin)
	b.Scan()
	input := b.Text()

	var output string
	var index int
	for _, c := range input {
		if c != '#' {
			output += string(c)
			continue
		}
		output += string(parola[index % len(parola)])
		index++
	}
	fmt.Println(output)
}
