package main

import "fmt"

func main() {
	var n int
	fmt.Print("Inserisci un numero da 1 a 99: ")
	fmt.Scan(&n)

	var s string
	if n < 20 {
		switch {
		case n == 1:
			s += "uno"
		case n == 2:
			s += "due"
		case n == 3:
			s += "tre"
		case n == 4:
			s += "quattro"
		case n == 5:
			s += "cinque"
		case n == 6:
			s += "sei"
		case n == 7:
			s += "sette"
		case n == 8:
			s += "otto"
		case n == 9:
			s += "nove"
		case n == 10:
			s += "dieci"
		case n == 11:
			s += "undici"
		case n == 12:
			s += "dodici"
		case n == 13:
			s += "tredici"
		case n == 14:
			s += "quattordici"
		case n == 15:
			s += "quindici"
		case n == 16:
			s += "sedici"
		case n == 17:
			s += "diciassette"
		case n == 18:
			s += "diciotto"
		case n == 19:
			s += "diciannove"
		}
	} else { // n > 20
		switch {
		case n >= 20 && n < 30:
			s += "vent"
		case n >= 30 && n < 40:
			s += "trent"
		case n >= 40 && n < 50:
			s += "quarant"
		case n >= 50 && n < 60:
			s += "cinquant"
		case n >= 60 && n < 70:
			s += "sessant"
		case n >= 70 && n < 80:
			s += "settant"
		case n >= 80 && n < 90:
			s += "ottant"
		case n >= 90 && n < 100:
			s += "novant"
		}

		switch {
		case n%10 == 1:
			s += "uno"
		case n%10 == 2:
			s += "adue"
		case n%10 == 3:
			s += "atre"
		case n%10 == 4:
			s += "aquattro"
		case n%10 == 5:
			s += "acinque"
		case n%10 == 6:
			s += "asei"
		case n%10 == 7:
			s += "asette"
		case n%10 == 8:
			s += "otto"
		case n%10 == 9:
			s += "anove"
		}
	}

	fmt.Println(s)
}
