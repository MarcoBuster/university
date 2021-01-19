package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func main() {
	if len(os.Args) < 3 {
		return
	}
	larghezza, err := strconv.Atoi(os.Args[1])
	if err != nil {
		return
	}

	nomeFile := os.Args[2]
	f, err := os.Open(nomeFile)
	if err != nil {
		return
	}

	b := bufio.NewScanner(f)
	b.Split(bufio.ScanRunes)
	counter := 0
	prec := ""
	for b.Scan() {
		char := b.Text()
		if char == "\n" {
			if prec == " " { // handle empty new lines
				continue
			}
			char = " "
		}
		fmt.Print(char)

		prec = char
		counter++
		if counter >= larghezza {
			fmt.Print("\n")
			counter = 0
		}
	}
}
