package main

import "fmt"

func piramide(n int) {
	// 4 => 1 2 3 4 3 2 1
	// 4 => 0 1 2 3 4 5 6
	for i := 0; i < n * 2-1; i++ {
		for k := i+1; i < n && k > 0; k-- {
			fmt.Print("*")
		}
		for k := n-(i-n)-1; i >= n && k > 0; k-- {
			fmt.Print("*")
		}
		fmt.Println()
	}
}

func distesa(m int) {
	// 2 => 1 2 1
	// 3 => 2 3 2
	if m == 0 {
		return
	}
	if m == 1 {
		piramide(1)
		return
	}
	distesa(m-1)
	piramide(m)
	distesa(m-1)
}

func main() {
	distesa(4)
}
