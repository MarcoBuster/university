package main

import (
	"fmt"
	"io/ioutil"
	"os"
)

func main() {
	fileName := os.Args[1]
	s, _ := ioutil.ReadFile(fileName)
	fmt.Printf("%s", s)
}
