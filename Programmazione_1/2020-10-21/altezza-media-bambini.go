package main

import "fmt"

func main() {
	var nBambini, alt, totale int
	var media float64
	fmt.Print("Quanti sono i bambini? ")
	fmt.Scan(&nBambini)
	for i := 0; i < nBambini; i++ {
		fmt.Print("Inserisci altezza bambino ", i+1, "/", nBambini, ": ")
		fmt.Scan(&alt)
		totale += alt
	}
	media = float64(totale) / float64(nBambini)
	fmt.Println("Altezza media:", media)
}
