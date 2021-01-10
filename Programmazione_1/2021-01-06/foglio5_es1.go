package main

import (
	"fmt"
	"os"
	"strings"
	"unicode"
)

func main() {
	var password string
	fmt.Scan(&password)
	corretta := true
	var errors []string

	if len(password) < 12 {
		corretta = false
		errors = append(errors, "- La pw deve avere una lunghezza minima di 12 caratteri")
	}

	nMinuscole, nMaiuscole, nCifre, nSpeciali := 0, 0, 0, 0
	for _, c := range password {
		if unicode.IsLetter(c) {
			if strings.ToLower(string(c)) == string(c) {
				nMinuscole++
			} else if strings.ToUpper(string(c)) == string(c) {
				nMaiuscole++
			}
		} else if unicode.IsDigit(c) {
			nCifre++
		} else {
			nSpeciali++
		}
	}
	if nMinuscole < 2 {
		corretta = false
		errors = append(errors, "- Almeno 2 caratteri della pw devono rappresentare delle lettere minuscole")
	}
	if nMaiuscole < 2 {
		corretta = false
		errors = append(errors, "- Almeno 2 caratteri della pw devono rappresentare delle lettere maiuscole")
	}
	if nCifre < 3 {
		corretta = false
		errors = append(errors, "- Almeno 3 caratteri della pw devono rappresentare delle cifre decimali")
	}
	if nSpeciali < 4 {
		corretta = false
		errors = append(errors, "- Almeno 4 caratteri della pw non devono rappresentare lettere o cifre decimali")
	}

	if corretta {
		fmt.Println("La pw è ben definita!")
		os.Exit(0)
	}
	fmt.Println("La pw non è definita correttamente:")
	for _, e := range errors {
		fmt.Println(e)
	}
}
