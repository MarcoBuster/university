package main

import "fmt"

func punti(s string) (totale int) {
	totale = 0
	for _, i := range s {
		switch i {
		case 'A':
			totale += 11
		case '3':
			totale += 10
		case 'K':
			totale += 4
		case 'Q':
			totale += 3
		case 'J':
			totale += 2
		case '7', '6', '5', '4', '2':
			totale += 0
		default:
			return -1
		}
	}
	return
}

func main() {
	var mano string
	fmt.Println("Inserisci la tua mano di briscola:")
	fmt.Scan(&mano)
	fmt.Printf("mano: %s: %d punti", mano, punti(mano))
}
