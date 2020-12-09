package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	fileName := os.Args[1]
	f, err := os.Open(fileName)
	if err != nil {
		fmt.Printf("Errore nell'apertura del file: %v\n", err)
		os.Exit(1)
	}
	defer f.Close()
	b := bufio.NewScanner(f)
	for b.Scan() {
		line := b.Text()
		fmt.Printf("Line: <%s>\n", line)
	}
}
