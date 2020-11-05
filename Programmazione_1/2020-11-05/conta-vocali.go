package main

import (
	"fmt"
	"io"
	"strings"
)

func main() {
	var parola string
	for {
		_, err := fmt.Scan(&parola)
		if err == io.EOF {
			break
		}
		fmt.Print(parola, ": ")

		count := 0
		for _, char := range parola {
			if strings.IndexRune("aeiouAEIOU", char) != -1 {
				count++
			}
		}
		fmt.Println(count, "vocali")
	}
}
