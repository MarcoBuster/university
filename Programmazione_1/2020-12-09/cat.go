package main

import (
	"fmt"
	"io"
	"os"
)

func main() {
	fileName := os.Args[1]
	f, err := os.Open(fileName)
	if err != nil {
		fmt.Printf("Errore nell'apertura del file: %v\n", err)
		os.Exit(1)
	}
	// defer esegue l'operazione *alla fine* della funzione.
	// Se ci sono più defer, vengono eseguiti in ordine diverso
	// (dall'ultimo inserito al primo)
	defer f.Close()

	var b []byte
	b = make([]byte, 1)
	for {
		_, err := f.Read(b)
		if err == io.EOF {
			return
		}
		fmt.Printf("%c", b[0])
	}
}
