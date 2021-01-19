package main

import (
	"fmt"
	"os"
	"strconv"
)

func stampaNumero(num []int) {
	if len(num) == 0 {
		return
	}
	for _, cifra := range num {
		fmt.Print(cifra)
	}
	fmt.Println()
}

func main() {
	if len(os.Args) < 2 {
		return
	}
	input := os.Args[1]

	var num []int
	for _, cifra := range input {
		n, _ := strconv.Atoi(string(cifra))
		if len(num) != 0 && n < num[len(num)-1] {
			stampaNumero(num)
			num = []int{}
		}
		num = append(num, n)
	}
	stampaNumero(num)
}
