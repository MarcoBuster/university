package main

import (
	"fmt"
	"strconv"
)

func giorniInMese(mese int) int {
	switch mese {
	case 1, 3, 7, 8, 10, 12:
		return 31
	case 4, 5, 6, 9, 11:
		return 30
	case 2:
		return 28
	}
	return 0
}

func main() {
	fmt.Println("Inserisci una stringa in formato dd-mm-yyyy")
	var dataStringa string
	fmt.Scan(&dataStringa)
	mese, _ := strconv.Atoi(dataStringa[3:5])
	anno, _ := strconv.Atoi(dataStringa[6:])
	fmt.Printf("Nel mese %d dell'anno %d ci sono %d giorni\n", mese, anno, giorniInMese(mese))
}
