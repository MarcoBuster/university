package main

import (
	"fmt"
	"os"
)

func main() {
	fileName := os.Args[1]
	f, err := os.Create(fileName)
	if err != nil {
		fmt.Printf("Errore nell'apertura del file: %v\n", err)
		os.Exit(1)
	}
	defer f.Close()

	s := "Ciao mamma\ncome stai?\nqui tutto bene, anche se piove!...\n"
	// boomer mode
	var b []byte
	b = make([]byte, 1)
	for i := 0; i < len(s); i++ {
		b[0] = s[i]
		f.Write(b)
	}

	// boomer mode 2
	for _, r := range s {
		f.Write([]byte(string(r)))
	}

	// zoomer mode
	fmt.Fprintf(f, s)
}
