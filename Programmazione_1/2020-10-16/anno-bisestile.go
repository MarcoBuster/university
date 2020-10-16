package main

import "fmt"

func main() {
	var anno int
	fmt.Println("Calcolo anno bisestile secondo la definizione ufficiale")
	fmt.Print("Inserisci anno: ")
	fmt.Scan(&anno)
	if (anno%100 == 0 && anno%400 == 0) || (anno%100 != 0 && anno%4 == 0) {
		fmt.Println("L'anno inserito è bisestile!")
	} else {
		fmt.Println("L'anno inserito non è bisestile.")
	}
}
