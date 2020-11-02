package main

import "fmt"

func main() {
	var n int
	fmt.Print("Inserisci n: ")
	fmt.Scan(&n)

	for i := 2; i <= n; i++ {
		var k int
		for k = 2; k < i; k++ {
			if i%k == 0 {
				break
			}
		}
		if i == k {
			fmt.Println(i)
		}
	}
}
