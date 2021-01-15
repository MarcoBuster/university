package main

import (
	"fmt"
	"math"
	"os"
	"strconv"
)

func rimuoviCifra(nList []string) []string {
	var res []string
	for _, n := range nList {
		for i := range n {
			res = append(res, n[:i]+n[i+1:])
		}
	}
	return res
}

func main() {
	if len(os.Args) < 3 {
		os.Exit(1)
	}
	n := os.Args[1]
	d, _ := strconv.Atoi(os.Args[2])

	res := []string{n}
	for i := 0; i < d; i++ {
		res = rimuoviCifra(res)
	}

	min := math.MaxInt32
	for _, i := range res {
		k, _ := strconv.Atoi(i)
		if k < min {
			min = k
		}
	}
	fmt.Println(min)
}
