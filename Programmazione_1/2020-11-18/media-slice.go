package main

import (
	"fmt"
	"os"
	"strconv"
)

func media(x []int) float64 {
	somma := 0
	for _, t := range x {
		somma += t
	}
	return float64(somma) / float64(len(x))
}

func main() {
	var valori []int
	for i := 1; i < len(os.Args); i++ {
		v, err := strconv.Atoi(os.Args[i])
		if err != nil {
			fmt.Printf("L'argomento %s non si può convertire!", os.Args[i])
			continue
		}
		valori = append(valori, v)
	}
	if len(valori) == 0 {
		fmt.Printf("Non posso calcolare la media di zero valori")
	} else {
		fmt.Printf("La media è %7.2f\n", media(valori))
	}
}
