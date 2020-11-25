package main

import (
	"fmt"
	"os"
	"time"
)

func isPalynRecorsive(r []rune) bool {
	if len(r) <= 1 {
		return true
	}
	return r[0] == r[len(r)-1] && isPalynRecorsive(r[1:len(r)-1])
}

func isPalynIterative(r []rune) bool {
	n := len(r)
	for i := 0; i < n/2; i++ {
		if r[i] != r[n-i-1] {
			return false
		}
	}
	return true
}

// omordotuanuoraoarounautodromo
// itopinonavevanonipoti
func main() {
	s := os.Args[1]
	r := []rune(s)
	if isPalynIterative(r) && isPalynRecorsive(r) {
		fmt.Printf("%s è palindroma!\n", s)
	} else {
		fmt.Printf("%s non è palindroma\n", s)
	}
	for {
		t1 := time.Now().UnixNano()
		t2 := time.Now().UnixNano()
		fmt.Println(t2 - t1)
	}
}
