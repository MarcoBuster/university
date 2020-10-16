package main

import "fmt"

func main() {
	var annoNascita int
	fmt.Println("Puoi votare? Scopriamolo insieme.")
	fmt.Print("Inserisci il tuo anno di nascita: ")
	fmt.Scan(&annoNascita)
	eta := 2020 - annoNascita
	if eta < 18 {
		fmt.Println("Sei ancora troppo piccolo per votare! Riprova fra qualche anno.")
	}
	if eta >= 18 {
		fmt.Println("Puoi votare la Camera dei Deputati.")
	}
	if eta >= 25 {
		fmt.Println("Puoi votare il Senato della Repubblica.")
	}
}
