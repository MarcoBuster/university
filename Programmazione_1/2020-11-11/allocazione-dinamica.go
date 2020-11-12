package main

import "fmt"

func main() {
	var x int
	var p *int
	var q **int
	x = 7
	p = &x
	p = new(int)
	*p = 50
	q = new(*int)
	*q = &x
	**q = 5
	*q = new(int)
	**q = 12
	q = &p
	fmt.Println(x, "\t\t", p, "\t", q)
	fmt.Println(&x, "\t", &p, "\t", &q)
	fmt.Println(x, "\t\t", *p, "\t\t", **q)
}
