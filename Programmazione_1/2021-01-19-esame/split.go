package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func main() {
	if len(os.Args) < 3 {
		return
	}
	numeroRighe, err := strconv.Atoi(os.Args[1])
	if err != nil {
		return
	}

	nomeFile := os.Args[2]
	f, err := os.Open(nomeFile)
	if err != nil {
		return
	}

	b := bufio.NewScanner(f)
	contatore := numeroRighe + 1
	numeroTaglio := 0
	for b.Scan() {
		if contatore > numeroRighe-1 {
			fmt.Println("::::::::::::::")
			fmt.Printf("taglio-%0.2d\n", numeroTaglio)
			fmt.Println("::::::::::::::")
			contatore = 0
			numeroTaglio++
		}
		fmt.Println(b.Text())
		contatore++
	}
}
