package main

import "fmt"

func main() {
	const K = 5
	var parola string

	for i := 0; i < K; i++ {
		fmt.Print("Inserisci una parola: ")
		fmt.Scan(&parola)
		found := false
		for _, c := range parola {
			if c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' {
				fmt.Println("Prima vocale:", string(c))
				found = true
				break
			}
		}
		if !found {
			fmt.Println("Non ho trovato nessuna vocale.")
		}
	}
}
