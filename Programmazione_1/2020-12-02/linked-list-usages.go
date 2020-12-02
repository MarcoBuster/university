package main

import (
	"./linked-list"
)

func main() {
	var x linked_list.List
	x = linked_list.AddInOrder(x, "pippo")
	x = linked_list.AddInOrder(x, "pluto")
	x = linked_list.AddInOrder(x, "topolino")
	x = linked_list.AddInOrder(x, "minnie")
	x = linked_list.AddInOrder(x, "quaraquaqua")
	linked_list.PrintAllElements(x)
	linked_list.PrintWithArrows(x)
	linked_list.RecursivePrint(x)
	x = linked_list.AddAt(x, "burro", 4)
	linked_list.PrintWithArrows(x)
	x = linked_list.DeleteItem(x, 0)
	linked_list.PrintWithArrows(x)
}
