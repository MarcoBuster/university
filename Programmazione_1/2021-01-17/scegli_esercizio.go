package main

import (
	"fmt"
	"io/ioutil"
	"math/rand"
	"time"
)

func main() {
	files, _ := ioutil.ReadDir("./labprog/esercizi")
	rand.Seed(time.Now().UnixNano())
	choice := rand.Intn(len(files))
	fmt.Println(files[choice].Name())
}
