package linked_list_2

import "fmt"

// Prints all elements of the list x on standard output, one per line
func (x List) PrintAllElements() {
	for x != nil {
		fmt.Println(x.Content)
		x = x.Next
	}
}

// Prints all elements of the list x on standard output, with a -> between
// any two successive elements
func (x List) PrintWithArrows() {
	for x != nil {
		fmt.Printf("%s", x.Content)
		x = x.Next
		if x != nil {
			fmt.Printf(" -> ")
		}
	}
	fmt.Println()
}

func (x List) String() (res string) {
	for x != nil {
		res += fmt.Sprintf("%s", x.Content)
		x = x.Next
		if x != nil {
			res += fmt.Sprintf(" -> ")
		}
	}
	return
}
