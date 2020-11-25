package main

import "fmt"

func fib(n int) int {
	if n == 0 || n == 1 {
		return 1
	}
	return fib(n-1) + fib(n-2)
}

func main() {
	for n := 1; n < 100; n++ {
		fmt.Println(float64(fib(n)) / float64(fib(n-1)))
	}
}
