package main

import (
	"fmt"
	"os"
	"strconv"
	"unicode"
)

// caratteri alfabetici che seguono un punto devono essere maiuscoli
// caratteri alfabetici che NON seguono un punto devono essere minuscoli
func punti(s string) string {
	res := ""
	var prec rune
	for _, c := range s {
		if prec == '.' {
			res += string(unicode.ToUpper(c))
		} else {
			res += string(unicode.ToLower(c))
		}
		prec = c
	}
	return res
}

// funzione ricorsiva per contare il numero di cifre di un intero
func contaCifre(n int) int {
	if n < 10 {
		return 1
	}
	return 1 + contaCifre(n/10)
}

func main() {
	if len(os.Args) < 3 {
		return
	}
	x, _ := strconv.Atoi(os.Args[1])
	y, _ := strconv.Atoi(os.Args[2])

	// x-esima cifra binaria di y
	for i := 0; i < x; i++ {
		y /= 2
	}
	fmt.Println(y % 2)
}
