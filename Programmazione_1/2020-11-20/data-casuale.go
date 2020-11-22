package main

import (
	"fmt"
	"math/rand"
	"time"
)

type Data struct {
	giorno int
	mese   int
	anno   int
}

func isAnnoBisestile(anno int) bool {
	return (anno%100 == 0 && anno%400 == 0) || (anno%100 != 0 && anno%4 == 0)
}

func giorniInMese(mese int, anno int) int {
	switch mese {
	case 1, 3, 5, 7, 8, 10, 12:
		return 31
	case 4, 6, 9, 11:
		return 30
	case 2:
		if isAnnoBisestile(anno) {
			return 29
		} else {
			return 28
		}
	}
	return 0
}

func dateCasuali(anno, k int) (date []Data) {
	for i := 0; i < k; i++ {
		var data Data
		data.anno = anno
		data.mese = rand.Intn(12) + 1
		data.giorno = rand.Intn(giorniInMese(data.mese, data.anno)-1) + 1
		date = append(date, data)
	}
	return date
}

func main() {
	rand.Seed(time.Now().UTC().UnixNano())
	var anno, k int
	fmt.Print("Inserisci un anno: ")
	fmt.Scan(&anno)
	fmt.Print("Quante date vuoi generare (k)? ")
	fmt.Scan(&k)
	fmt.Println(dateCasuali(anno, k))
}
