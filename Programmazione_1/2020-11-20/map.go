package main

import "fmt"

func main() {
	// var m map[string]int
	m := make(map[string]int)
	m["Paolo"] = 1968
	m["Anna"] = 1987
	m["Giovanni"] = 1932
	m["Paolo"] = 1935
	fmt.Println(m)
	fmt.Println(len(m))
}
