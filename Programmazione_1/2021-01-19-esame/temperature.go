package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"sort"
	"strconv"
)

func main() {
	b := bufio.NewScanner(os.Stdin)

	max := 0
	min := math.MaxInt8
	freq := make(map[int]int)
	for b.Scan() {
		n, err := strconv.Atoi(b.Text())
		if err != nil {
			return
		}
		if n > max {
			max = n
		} else if n < min {
			min = n
		}
		freq[n]++
	}
	fmt.Printf("max : %d, %d volte; min : %d, %d volte\n", max, freq[max], min, freq[min])

	var keys []int // needed for sorting
	for k := range freq {
		keys = append(keys, k)
	}
	sort.Ints(keys)

	for i, temperature := range keys {
		fmt.Printf("%d:%d", temperature, freq[temperature])
		if i != len(keys)-1 { // don't print the space if it's the last iteration
			fmt.Print(" ")
		}
	}
	fmt.Println()

	var candidates []int
	var maxFreq = 0
	for temperature, frequency := range freq {
		if frequency > maxFreq {
			maxFreq = frequency
			candidates = []int{temperature}
		} else if frequency == maxFreq {
			candidates = append(candidates, temperature)
		}
	}
	sort.Ints(candidates)
	fmt.Printf("temperature %v con frequenza %d, la massima frequenza\n", candidates, maxFreq)
}
