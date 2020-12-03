package main

import (
	"fmt"
	"strconv"
)

func recursiveSumIntegers(numbers []int) int {
	if len(numbers) == 0 {
		return 0
	}
	return numbers[0] + recursiveSumIntegers(numbers[1:])
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
	sum := recursiveSumIntegers(numbers)
	fmt.Println("Sum:", sum)
}
