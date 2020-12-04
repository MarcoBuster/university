package main

import "fmt"

type Data struct {
	d int
	m int
	y int
}

type Persona struct {
	nome          string
	cognome       string
	dataDiNascita Data
}

// Data una slice di Persona, ritorna un'altra slice
// con le persone con età minore di quella specificata
func filtraPersoneEta(x []Persona, eta int) []Persona {
	var res []Persona
	for _, p := range x {
		if 2020-p.dataDiNascita.y > eta {
			res = append(res, p)
		}
	}
	return res
}

func main() {
	var persone []Persona
	persone = append(persone, Persona{"Marco", "Aceti", Data{27, 10, 2001}})
	persone = append(persone, Persona{"Linus", "Torvalds", Data{28, 12, 1969}})
	persone = append(persone, Persona{"Richard", "Stallman", Data{16, 3, 1953}})
	fmt.Println(filtraPersoneEta(persone, 20))
}
