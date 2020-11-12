package main

import "fmt"

func main() {
	type punt *int
	var x, y, z punt
	fmt.Println(x, y, z)
}
