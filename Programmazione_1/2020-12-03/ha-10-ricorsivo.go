package main

import (
	"fmt"
	"strconv"
)

func recursiveFindTen(numbers []int) bool {
	if len(numbers) == 0 {
		return false
	}
	if numbers[0] == 10 {
		return true
	}
	return recursiveFindTen(numbers[1:])
}

func main() {
	var numbers []int

	for {
		var numberStr string
		fmt.Print("Insert a number to add it to the list or a non-number to terminate the input: ")
		fmt.Scan(&numberStr)
		number, err := strconv.Atoi(numberStr)
		if err != nil {
			break
		}
		numbers = append(numbers, number)
	}
	result := recursiveFindTen(numbers)
	fmt.Println("Has ten?", result)
}
