package main

import "fmt"

func sliceUguali(s1, s2 []int) bool {
	for _, i := range s1 {
		for _, k := range s2 {
			if k != i {
				return false
			}
		}
	}
	return true
}

func main() {
	s1 := make([]int, 10)
	s2 := make([]int, 10)
	fmt.Println("Slice uguali?", sliceUguali(s1, s2))
}
