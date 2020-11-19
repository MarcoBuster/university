package main

import (
	"fmt"
	"os"
	"strconv"
)

func calc(a, b int, op string) float64 {
	switch op {
	case "+":
		return float64(a + b)
	case "*":
		return float64(a * b)
	case "-":
		return float64(a - b)
	case "/":
		return float64(a / b)
	default:
		fmt.Println("Invalid operation selected")
		os.Exit(1)
	}
	return -1
}

func main() {
	if len(os.Args) < 4 {
		fmt.Println("Too few arguments. Usage: ./calcolatrice A OPERATION B")
		os.Exit(1)
	}
	a, err := strconv.Atoi(os.Args[1])
	if err != nil {
		fmt.Printf("Invalid argument (%s).\n", os.Args[1])
		os.Exit(1)
	}
	op := os.Args[2]
	b, err := strconv.Atoi(os.Args[3])
	if err != nil {
		fmt.Printf("Invalid argument (%s).\n", os.Args[3])
		os.Exit(1)
	}
	res := calc(a, b, op)
	fmt.Printf("Result: %.2f\n", res)
}
