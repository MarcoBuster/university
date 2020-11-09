package main

import "fmt"

func incrementa(p *int, k int) {
	*p += k
}

func main() {
	var y int
	y = 7
	incrementa(&y, 10)
	fmt.Println(y)
}
