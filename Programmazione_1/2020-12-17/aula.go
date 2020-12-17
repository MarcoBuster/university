package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

type Aula struct {
	banchi [][]bool
}

//crea un'aula delle dimensione specificate
//ritorna l'aula e il valore true se le dimensioni sono corrette (entrambe >= 1)
//ritorna un'aula qualsiasi e false altrimenti
//in un'aula appena creata tutti i banchi sono liberi
func creaAula(nfile, ncol int) (Aula, bool) {
	if nfile < 1 || ncol < 1 {
		return Aula{[][]bool{}}, false
	}
	banchi := make([][]bool, nfile)
	for i := range banchi {
		banchi[i] = make([]bool, ncol)
	}
	return Aula{banchi}, false
}

//stampa la disposizione di un'aula come una griglia
//mettendo delle 'x' per i posti occupati
//e dei '_' per quelli liberi
//(aggiungendo eventuali //spazi per migliorare l'effetto)
func stampaAula(aula Aula) {
	fmt.Println()
	for fila := range aula.banchi {
		for col := range aula.banchi[fila] {
			if aula.banchi[fila][col] {
				fmt.Printf("x\t")
			} else {
				fmt.Printf("_\t")
			}
		}
		fmt.Println()
	}
}

//metodo che produce una stringa che descrive la disposizione di un'aula
//come una griglia mettendo delle 'x' per i posti occupati
//e dei '_' per quelli liberi (aggiungendo eventuali
//spazi per migliorare l'effetto)
func (aula Aula) String() string {
	res := "\n"
	for fila := range aula.banchi {
		for col := range aula.banchi[fila] {
			if aula.banchi[fila][col] {
				res += fmt.Sprintf("x\t")
			} else {
				res += fmt.Sprintf("_\t")
			}
		}
		res += "\n"
	}
	return res
}

//occupa un "banco" di un'aula corrispondente a una certa posizione
//restituisce false se per qualsiasi motivo l'operazione NON ha esito,
//cioè se lo stato complessivo dell'aula non cambia
func occupa(a Aula, fila, col int) bool {
	if fila < 0 || col < 0 || fila > len(a.banchi)-1 || col > len(a.banchi[fila])-1 {
		return false
	}
	if a.banchi[fila][col] {
		return false
	}
	a.banchi[fila][col] = true
	return true
}

//libera (cioè rende nuovamente disponibile) un "banco" di un'aula che corrisponde a una certa posizione
//restituisce false se per qualsiasi motivo l'operazione NON ha esito,
//cioè se lo stato complessivo dell'aula non cambia
func libera(a Aula, fila, col int) bool {
	if fila < 0 || col < 0 || fila > len(a.banchi)-1 || col > len(a.banchi[fila])-1 {
		return false
	}
	if !a.banchi[fila][col] {
		return false
	}
	a.banchi[fila][col] = false
	return true
}

//verifica il distanziamento tra banchi
//criterio di distanziamento:
//nessun banco occupato nelle posizioni immeditamente adiacenti sulla stessa fila e colonna
//restituisce true se e solo se il banco specificato è in posizione "sicura"
func verificaDistanziamento(a Aula, fila, col int) bool {
	if fila < 0 || col < 0 || fila > len(a.banchi)-1 || col > len(a.banchi[fila])-1 {
		return false
	}

	// -1.-1	0.-1	1.-1
	// -1.0		0.0		1.0
	// -1.1		0.1		1.1

	for dx := range []int{-1, 0, 1} {
		for dy := range []int{-1, 0, 1} {
			if (dx == 0 && dy == 0) || (dx != 0 && dy != 0) {
				continue
			}
			cFila := fila + dx
			cCol := col + dy
			if cFila < 0 || cCol < 0 || cFila > len(a.banchi)-1 || cCol > len(a.banchi[fila])-1 {
				continue
			}
			if a.banchi[cFila][cCol] {
				return false
			}
		}
	}
	return true
}

func parseInput(line string) (rune, int, int) {
	azione := line[0]
	if azione == 'p' {
		return rune(azione), -1, -1
	}
	r, _ := strconv.Atoi(string(line[3]))
	c, _ := strconv.Atoi(string(line[5]))
	return rune(azione), r, c
}

func main() {
	if len(os.Args) < 2 {
		fmt.Println("Usage: ./aula nomefile")
		os.Exit(1)
	}
	f, _ := os.Open(os.Args[1])
	b := bufio.NewScanner(f)
	aula, _ := creaAula(7, 6)
	for b.Scan() {
		line := b.Text()
		azione, r, c := parseInput(line)
		ok := true
		switch azione {
		case 'p':
			stampaAula(aula)
			break
		case '+':
			ok = occupa(aula, r, c)
			break
		case '-':
			ok = libera(aula, r, c)
			break
		case 'v':
			dist := verificaDistanziamento(aula, r, c)
			if dist {
				fmt.Printf("Distanziamento rispettato per %d %d\n", r, c)
			} else {
				fmt.Printf("Distanziamento non rispettato per %d %d\n", r, c)
			}
			break
		}
		if !ok {
			fmt.Println("ERRORE.")
		}
	}
}
