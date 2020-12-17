package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func main() {
	f, _ := os.Open("morse.txt")
	b := bufio.NewScanner(f)
	defer f.Close()

	morseMap := make(map[rune]string)
	for b.Scan() {
		line := b.Text()
		line = strings.ToUpper(line)
		morseMap[rune(line[0])] = line[2:]
	}

	scanner := bufio.NewScanner(os.Stdin)
	for scanner.Scan() {
		line := scanner.Text()
		line = strings.ToUpper(line)
		for _, c := range line {
			fmt.Printf("%s / ", morseMap[c])
		}
		fmt.Println()
	}
}
