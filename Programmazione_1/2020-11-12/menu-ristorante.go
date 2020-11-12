package main

import "fmt"

func main() {
	// Usage: stampare le prenotazioni e piparle dentro il programma. Esempio (bash):
	// echo "abcdkaf" | ./menu-ristorante

	const MENU = "Menu del giorno:\n" +
		"a. pizza\n" +
		"b. penne al pomodoro\n" +
		"c. cotoletta e patatine\n" +
		"d. crostata e caffè"

	fmt.Println(MENU)
	var scelta rune
Loop:
	for {
		fmt.Scanf("%c", &scelta)
		if scelta == 10 { // EOL
			break
		}

		var ordinazione string
		switch scelta {
		case 'a':
			ordinazione = "pizza"
		case 'b':
			ordinazione = "penne al pomodoro"
		case 'c':
			ordinazione = "cotoletta e patatine"
		case 'd':
			ordinazione = "crostata e caffè"
		case 'f':
			fmt.Println("Prenotazioni prese. Arrivederci")
			break Loop
		default:
			fmt.Print(string(scelta), ": ignorata, non valida\n")
			continue Loop
		}
		fmt.Println("hai ordinato", ordinazione)
	}
}
