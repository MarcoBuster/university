package main

import "fmt"

func controlla(parola, tentativo string) (corrette int, correttePosSbagliata int) {
	// Controlla il tentativo inserito e ritorna il numero di lettere corrette
	// e il numero di lettere corrette messe nella posizione sbagliata
	for i := 0; i < len(parola); i++ {
		if parola[i] == tentativo[i] {
			corrette++
		}
		for k := 0; k < len(tentativo); k++ {
			if parola[i] != tentativo[i] && parola[i] == tentativo[k] {
				correttePosSbagliata++
			}
		}
	}
	return corrette, correttePosSbagliata
}

func main() {
	var parola string
	fmt.Print("Inserisci la parola da indovinare: ")
	fmt.Scan(&parola)

	for {
		var tentativo string
		fmt.Print("Inserisci il tuo tenativo: ")
		fmt.Scan(&tentativo)
		if len(tentativo) != len(parola) {
			fmt.Println("La parola che hai inserito non è valida. Riprovare.")
			continue
		}
		corrette, correttePosSbagliata := controlla(parola, tentativo)
		fmt.Printf("Lettere corrette: %d\nLettere corrette ma in posizione sbagliata: %d\n",
			corrette, correttePosSbagliata)
		if corrette == len(parola) {
			fmt.Println("Complimenti, hai vinto.")
			break
		}
	}
}
