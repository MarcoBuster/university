package main

import "fmt"

type data struct {
	g int
	m int
	a int
}

type persona struct {
	nome, cognome string
	altezza       int
	peso          int
	dataDiNascita data
	emoglobina    float64 // sono tanto confuso quanto te
}

func main() {
	var dataDiNascita data
	dataDiNascita.g = 27
	dataDiNascita.m = 10
	dataDiNascita.a = 2001
	dataDiNascita.g, dataDiNascita.m, dataDiNascita.a = 27, 10, 2001

	var marcoAceti persona
	marcoAceti.nome = "Marco"
	marcoAceti.cognome = "Aceti"
	marcoAceti.altezza = 189 // Capito Tinder?
	marcoAceti.peso = 69
	marcoAceti.dataDiNascita = dataDiNascita
	marcoAceti.emoglobina = 420

	marcoAceti = persona{
		nome:          "Marco",
		cognome:       "Aceti",
		altezza:       189,
		peso:          69,
		dataDiNascita: dataDiNascita,
		emoglobina:    420,
	}
	fmt.Println(marcoAceti)
}
