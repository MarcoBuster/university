package main

import (
	"os"
	"fmt"
	"io/ioutil"
)

func main() {
	if len(os.Args) < 3 {
		fmt.Println("Usage: ./copia src dst")
		os.Exit(1)
	}
	data, err := ioutil.ReadFile(os.Args[1])
	if err != nil {
		fmt.Println("Errore durante l'apertura del file:", err)
		os.Exit(1)
	}
	err = ioutil.WriteFile(os.Args[2], data, 0644)
	if err != nil {
		fmt.Println("Errore durante la scrittura del file:", err)
		os.Exit(1)
	}
}

