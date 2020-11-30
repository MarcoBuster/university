package main

import (
	"fmt"
	"math/rand"
	"os"
	"palyn/check"
	"palyn/gen"
	"strconv"
	"time"
)

func main() {
	s := os.Args[1]
	fmt.Printf("I'm going to check if %s is palyndrome\n", s)
	it := check.IterIsPalyn(s)
	rec := check.RecursiveIsPalyn(s)
	fmt.Printf("Iteratively --- result: %v\n", it)
	fmt.Printf("Recursively --- result: %v\n", rec)

	rand.Seed(time.Now().UnixNano())
	n, _ := strconv.Atoi(os.Args[2])
	fmt.Printf("I'm going to generate a palyndrome string of length %d\n", n)
	r1 := gen.IterativeGenPalyn(n)
	fmt.Printf("Iteratively --- result: %s\n", r1)
	r2 := gen.RecursiveGenPalyn(n)
	fmt.Printf("Recursively --- result: %s\n", r2)
}
