package main

// Programma per calcolare data una data qualsiasi
// quanti giorni mancano al primo gennaio e a Natale
// assumendo che tutti i mesi siano di 30 giorni

import "fmt"

func main() {
	var d, m int
	fmt.Print("Inserisci il giorno: ")
	fmt.Scan(&d)
	fmt.Print("Inserisci il mese: ")
	fmt.Scan(&m)
	var dest1, dest2 int // dest1 = primo genn; dest2 = natale
	dest1 = (12-m)*30 + (30 - d)
	dest2 = (12-m)*30 + (25 - d)
	fmt.Println("Al 1 gennaio mancano", dest1, "giorni")
	fmt.Println("Al 25 dicembre mancano", dest2, "giorni")
}
