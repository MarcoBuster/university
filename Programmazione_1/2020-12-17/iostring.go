package main

import (
	"os"
	"fmt"
)

func main() {
    if len(os.Args) < 2 {
		fmt.Println("Usage: ./IOstring date")
		os.Exit(1)
	}
	rawDate := os.Args[1]

	var d, m, y int
	fmt.Sscanf(rawDate, "%d/%d/%d", &d, &m, &y)
	fmt.Printf("anno: %d, mese: %d, giorno: %d\n", y, m, d)
}
