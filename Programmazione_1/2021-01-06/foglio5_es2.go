package main

import (
	"fmt"
	"os"
	"strconv"
)

func main() {
	if len(os.Args) < 2 {
		fmt.Println("Utilizzo: ./es2 n")
		os.Exit(1)
	}
	n, _ := strconv.Atoi(os.Args[1])

	for i := 0; i < n; i++ {
		for k := i; k < n; k++ {
			fmt.Printf("O")
		}
		for k := i * 2; k >= 0; k-- {
			if k == 0 && i == 0 {
				fmt.Printf("+")
			} else {
				fmt.Printf(" ")
			}
		}
		for k := i; k < n; k++ {
			fmt.Printf("O")
		}
		fmt.Println()
	}
}
