package main

import "fmt"

func main() {
	var n int
	fmt.Print("Inserisci n: ")
	fmt.Scan(&n)

	for i, k := 0, 2; i < n; k++ {
		var z int
		for z = 2; z < k; z++ {
			if k%z == 0 {
				break
			}
		}
		if k == z {
			i++
			fmt.Println(k)
		}
	}
}
