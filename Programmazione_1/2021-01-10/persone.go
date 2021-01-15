package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

type Persona struct {
	idPersona     int
	nome, cognome string
	eta           int
}
type Legame []int
type InsiemeTre [3]Persona

func parsePersona(line string) Persona {
	splittedLine := strings.Split(line, ";")
	idPersona, _ := strconv.Atoi(splittedLine[0])
	eta, _ := strconv.Atoi(splittedLine[3])
	return Persona{idPersona, splittedLine[1], splittedLine[2], eta}
}

func parseLegame(line string) Legame {
	splittedLine := strings.Split(line, ";")
	a, _ := strconv.Atoi(splittedLine[0])
	b, _ := strconv.Atoi(splittedLine[1])
	return Legame{a, b}
}

func StringPersona(p Persona) string {
	return fmt.Sprintf("%d - %s %s: %d", p.idPersona, p.nome, p.cognome, p.eta)
}

func StringInsiemeTre(i InsiemeTre) string {
	r := "Insieme formato da: \n "
	s := float64(0)
	for j, p := range i { // ma perché i???
		r += StringPersona(p)
		s += float64(p.eta)
		if j == len(i)-1 { // ultima esecuzione
			r += "."
		} else {
			r += ";"
		}
		r += "\n "
	}
	r += fmt.Sprintf("Età media: %f", s/3)
	return r
}

func main() {
	if len(os.Args) < 3 {
		os.Exit(1)
	}
	personeFn := os.Args[1]
	legamiFn := os.Args[2]

	persone := make(map[int]Persona)
	f, _ := os.Open(personeFn)
	b := bufio.NewScanner(f)
	for b.Scan() {
		line := b.Text()
		persona := parsePersona(line)
		persone[persona.idPersona] = persona
	}

	var legami []Legame
	f, _ = os.Open(legamiFn)
	b = bufio.NewScanner(f)
	for b.Scan() {
		line := b.Text()
		legami = append(legami, parseLegame(line))
	}

	mappaLegami := make(map[int]Legame)
	for pId := range persone {
		for _, l := range legami {
			if l[0] == pId {
				mappaLegami[pId] = append(mappaLegami[pId], l[1])
			} else if l[1] == pId {
				mappaLegami[pId] = append(mappaLegami[pId], l[0])
			}
		}
	}

	for k, l := range mappaLegami {
		if len(l) != 2 {
			delete(mappaLegami, k)
			continue
		}
		// Controlla che tutti quelli nel legame abbiano legami tra di loro
		if len(mappaLegami[l[0]]) != 2 || len(mappaLegami[l[1]]) != 2 {
			continue
		}
		// Elimina legami duplicati
		delete(mappaLegami, l[0])
		delete(mappaLegami, l[1])
		fmt.Println(StringInsiemeTre(InsiemeTre{persone[k], persone[l[0]], persone[l[1]]}))
	}
}
