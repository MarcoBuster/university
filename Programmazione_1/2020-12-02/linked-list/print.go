package linked_list

import "fmt"

// Prints all elements of the linked-list x on standard output, one per line
func PrintAllElements(x List) {
	for x != nil {
		fmt.Println(x.Content)
		x = x.Next
	}
}

// Prints all elements of the linked-list x on standard output, with a -> between
// any two successive elements
func PrintWithArrows(x List) {
	for x != nil {
		fmt.Printf("%s", x.Content)
		x = x.Next
		if x != nil {
			fmt.Printf(" -> ")
		}
	}
	fmt.Println()
}

// Prints all elements (like PrintAllElements) but it's recursive
func RecursivePrint(x List) {
	if x == nil {
		return
	}
	fmt.Println(x.Content)
	RecursivePrint(x.Next)
}
