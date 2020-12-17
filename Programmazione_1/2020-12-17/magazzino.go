package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

type Prodotto struct {
	codice         string
	descrizione    string
	prezzoUnitario float64
}
type Magazzino map[string]Prodotto

func parseProduct(productStr string) Prodotto {
	productSlice := strings.Split(productStr, ",")
	prezzo, _ := strconv.ParseFloat(productSlice[2], 64)
	return Prodotto{productSlice[0], productSlice[1], prezzo}
}

func stampaMagazzino(magazzino Magazzino, disponibilita map[string]int) {
	fmt.Println()
	fmt.Println("Codice\tDescrizione\tPrezzo unitario\tDisponibilità")
	for _, v := range magazzino {
		fmt.Printf("%s\t%s\t\t%f\t%d\n", v.codice, v.descrizione, v.prezzoUnitario, disponibilita[v.codice])
	}
}

func main() {
	if len(os.Args) < 2 {
		fmt.Println("Utilizzo: ./magazzino nomefile")
		os.Exit(1)
	}
	fileName := os.Args[1]
	f, _ := os.Open(fileName)
	b := bufio.NewScanner(f)
	defer f.Close()

	magazzino := make(Magazzino)
	disponibilita := make(map[string]int)

	for b.Scan() {
		line := b.Text()
		if strings.HasPrefix(line, "+") || strings.HasPrefix(line, "-") {
			codiceProdotto := line[2:]
			_, ok := magazzino[codiceProdotto]
			if !ok {
				fmt.Printf("Prodotto %s non presente nel magazzino.\n", codiceProdotto)
				continue
			}
			if line[0] == '+' {
				disponibilita[codiceProdotto]++
			} else if line[0] == '-' {
				disponibilita[codiceProdotto]--
			}
		} else {
			prodotto := parseProduct(line)
			magazzino[prodotto.codice] = prodotto
		}
	}
	stampaMagazzino(magazzino, disponibilita)
}
