package main

import (
	"fmt"
	"strconv"
)

func isNumber(c rune) bool {
	return c >= 48 && c <= 57
}

func checkOrdering(numbers []int) bool {
	prec := 9
	for _, n := range numbers {
		if n > prec {
			return false
		}
		prec = n
	}
	return true
}

func main() {
	var input string
	fmt.Scan(&input)

	numbers := make([]int, 0)
	for _, c := range input {
		if !isNumber(c) {
			continue
		}
		n, _ := strconv.Atoi(string(c))
		numbers = append(numbers, n)
	}
	if checkOrdering(numbers) {
		fmt.Println("Sequenza nascosta ordinata.")
	} else {
		fmt.Println("Sequenza nascosta non ordinata.")
	}
}
