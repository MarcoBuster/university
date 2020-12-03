package main

import "fmt"

func f(n int, seq []int) {
	addr := &seq
	fmt.Println(addr)
	seq = append(seq, n)
	if n == 1 {
		return
	}
	f(n-1, seq)
}

func main() {
	var n int
	fmt.Scan(&n)

	result := make([]int, 0, 20)
	fmt.Println(&result)
	f(n, result)
	fmt.Println(result[0:5])
}
