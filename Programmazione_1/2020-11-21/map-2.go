package main

import "fmt"

func main() {
	m := map[string]int{
		"ciao":     3,
		"anna":     15,
		"giovanni": 3,
	}
	delete(m, "ciao")
	fmt.Println(m)
}
