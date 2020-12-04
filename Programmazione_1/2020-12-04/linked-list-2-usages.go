package main

import (
	"./linked-list-2"
	"fmt"
)

func main() {
	var x linked_list_2.List
	x = x.AddInOrder("pippo")
	x = x.AddInOrder("pluto")
	x = x.AddInOrder("topolino")
	x = x.AddInOrder("ultimo")
	x = x.AddInOrder("abate")
	x = x.AddInOrder("ragno")
	x.PrintWithArrows()
	fmt.Printf("Lunghezza della lista: %d\n", x.Length())

	fmt.Println(x)
}
